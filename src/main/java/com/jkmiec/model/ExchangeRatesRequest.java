package com.jkmiec.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "current_rate_view")
public class ExchangeRatesRequest {

    @Id
    private Long id;
    @Column(name = "effective_date")
    private Date date;
    private String currency;
    private String code;
    private BigDecimal mid;

    public ExchangeRatesRequest() {
    }

    public ExchangeRatesRequest(Long id, Date date, String currency, String code, BigDecimal mid) {
        this.id = id;
        this.date = date;
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }
}
