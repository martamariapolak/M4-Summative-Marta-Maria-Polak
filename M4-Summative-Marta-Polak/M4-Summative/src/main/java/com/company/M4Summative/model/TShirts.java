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
@Table(name = "t_shirt")
public class TShirts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_shirt_id")
    private Integer id;


    @NotEmpty
    @Length(max = 255, min = 1)
    private String size;

    @NotEmpty
    @Length(max = 20, min = 1)
    private String color;

    @NotEmpty
    @Length(max = 255, min = 1)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int quantity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TShirts(String size, String color, String description, BigDecimal price, int quantity) {
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public TShirts() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirts tShirts = (TShirts) o;
        return quantity == tShirts.quantity && Objects.equals(id, tShirts.id) && Objects.equals(size, tShirts.size) && Objects.equals(color, tShirts.color) && Objects.equals(description, tShirts.description) && Objects.equals(price, tShirts.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "TShirts{" + "id=" + id + ", size='" + size + '\'' + ", color=" + color + ", description='" + description + '\'' + ", price=" + price + ", quantity=" + quantity + '}';
    }
}