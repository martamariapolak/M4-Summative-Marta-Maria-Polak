package com.company.M4Summative.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processing_fee")
public class ProcessingFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    @Column(name = "product_type")
    @Length(max = 20, min = 1)
    private String productType;

    @NotNull
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(productType, that.productType) && Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }

    @Override
    public String toString() {
        return "ProcessingFee{" +
                "productType='" + productType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
