package com.jkmiec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;


@XmlRootElement(name = "ExchangeRatesTable")
@Entity
@Table(name = "exchange_rates")
public class ExchangeRates {
    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;
    private String tab;
    private String no;
    private Date effectiveDate;
    private Rates rates;

    public ExchangeRates() {
    }

    public ExchangeRates(String tab, String no, Date effectiveDate, Rates rates) {
        this.tab = tab;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public Long getId() {
        return id;
    }

    @XmlElement(name = "Table")
    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    @XmlElement(name = "No")
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @XmlElement(name = "EffectiveDate")
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @XmlElement(name = "Rates")
    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeRatesTable{" +
                "id=" + id +
                ", tab='" + tab + '\'' +
                ", no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", rates=" + rates +
                '}';
    }
}
