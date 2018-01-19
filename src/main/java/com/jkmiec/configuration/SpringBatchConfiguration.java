package com.jkmiec.configuration;

import com.jkmiec.model.ExchangeRates;
import com.jkmiec.repository.ExchangeRatesRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SpringBatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Bean
    public StaxEventItemReader<ExchangeRates> exchangeItemReader() {

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(ExchangeRates.class);

        StaxEventItemReader<ExchangeRates> reader = new StaxEventItemReader<>();
        reader.setResource(new ClassPathResource("/data/a013z180118.xml"));
        reader.setFragmentRootElementName("pozycja");
        reader.setUnmarshaller(jaxb2Marshaller);

        return reader;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .<ExchangeRates, ExchangeRates>chunk(10)
                .reader(exchangeItemReader())
                .writer(exchangeItemWriter())
                .build();
    }

    @Bean
    public ItemWriter<? super ExchangeRates> exchangeItemWriter() {
        return items -> items.forEach(exchangeRatesRepository::save);
    }

    @Bean
    public Job job() {
        return jobBuilderFactory
                .get("job")
                .start(step1())
                .build();
    }
}
