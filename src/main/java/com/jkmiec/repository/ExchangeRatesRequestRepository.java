package com.jkmiec.repository;


import com.jkmiec.model.ExchangeRatesRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRatesRequestRepository extends JpaRepository<ExchangeRatesRequest, Long> {

    @Query("select e from ExchangeRatesRequest e where e.code = 'CHF' or e.code = 'USD' or e.code = 'EUR'")
    List<ExchangeRatesRequest> getBigThereByByCode();

}
