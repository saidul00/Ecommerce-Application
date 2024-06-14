package dev.saidul.EcomPaymentService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Currency extends BaseModel{
    private String currencyTAG;
    private String currencyName;
    private String country;
}
