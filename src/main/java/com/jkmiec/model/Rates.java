package com.jkmiec.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@Embeddable
public class Rates {

    @ElementCollection
    @CollectionTable(
            name="rate",
            joinColumns=@JoinColumn(name="exchange_rates_id")
    )
    private Set<Rate> rate;

    public Rates() {
    }

    public Rates(Set<Rate> rate) {
        this.rate = rate;
    }
    @XmlElement(name = "Rate")
    public Set<Rate> getRate() {
        return rate;
    }

    public void setRate(Set<Rate> rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "rate=" + rate +
                '}';
    }
}
