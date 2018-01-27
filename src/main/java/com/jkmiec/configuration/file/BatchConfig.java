package com.jkmiec.configuration.file;

import com.jkmiec.model.ExchangeRates;
import com.jkmiec.service.IExchangeRatesService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private static final String ROOT_ELEMENT_NAME = "ExchangeRatesTable";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private IExchangeRatesService exchangeRatesService;

    @Autowired
    public BatchConfig(IExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @Bean(name = "myJob")
    public Job job(Step importStep) {
        return jobBuilderFactory.get("myJob")
                .incrementer(new RunIdIncrementer())
                .flow(importStep)
                .end()
                .build();
    }

    @Bean
    public Step importStep(ItemReader<ExchangeRates> importReader,
                           ItemWriter<ExchangeRates> importWriter) {
        return stepBuilderFactory.get("myImportStep")
                .<ExchangeRates, ExchangeRates>chunk(10)
                .reader(importReader)
                .writer(importWriter)
                .build();
    }

    @StepScope
    @Bean(name = "myImportStep")
    public StaxEventItemReader<ExchangeRates> importReader(@Value("#{jobParameters[file_path]}") String filePath) {

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(ExchangeRates.class);

        StaxEventItemReader<ExchangeRates> reader = new StaxEventItemReader<>();
        reader.setResource(new FileSystemResource(filePath));
        reader.setFragmentRootElementName(ROOT_ELEMENT_NAME);
        reader.setUnmarshaller(jaxb2Marshaller);

        return reader;
    }

    @Bean
    public ItemWriter<ExchangeRates> importWriter() {
        return items -> items.forEach(exchangeRatesService::save);
    }

}


