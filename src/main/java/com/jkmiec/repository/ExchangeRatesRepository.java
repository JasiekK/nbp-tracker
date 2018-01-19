package com.jkmiec.repository;

import com.jkmiec.model.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Long> {
}
