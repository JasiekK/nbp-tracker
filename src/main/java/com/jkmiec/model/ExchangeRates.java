package com.jkmiec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "pozycja")
@Entity
@Table(name = "exchange_rates")
public class ExchangeRates {
    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;
    private String name;
    private int converter;
    private String code;
    private String averageExchangeRate;

    public ExchangeRates() {
    }

    public ExchangeRates(String name, int converter, String code, String averageExchangeRate) {
        this.name = name;
        this.converter = converter;
        this.code = code;
        this.averageExchangeRate = averageExchangeRate;
    }

    public Long getId() {
        return id;
    }

    @XmlElement(name = "nazwa_waluty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "przelicznik")
    public int getConverter() {
        return converter;
    }

    public void setConverter(int converter) {
        this.converter = converter;
    }

    @XmlElement(name = "kod_waluty")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name = "kurs_sredni")
    public String getAverageExchangeRate() {
        return averageExchangeRate;
    }

    public void setAverageExchangeRate(String averageExchangeRate) {
        this.averageExchangeRate = averageExchangeRate;
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "name='" + name + '\'' +
                ", converter=" + converter +
                ", code='" + code + '\'' +
                ", averageExchangeRate=" + averageExchangeRate +
                '}';
    }
}
