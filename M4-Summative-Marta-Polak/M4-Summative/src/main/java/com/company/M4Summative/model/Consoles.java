package com.company.M4Summative.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "consoles")
public class Consoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "console_id")
    private Integer id;

    @NotNull
    @Length(max = 50, min = 1)
    private String model;

    @NotNull
    @Length(max = 50, min = 1)
    private String manufacturer;

    @NotNull
    @Length(max = 50, min = 1)
    @Column(name = "memory_amount")
    private String memoryAmount;

    @NotNull
    @Length(max = 50, min = 1)
    private String processor;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int quantity;

    public Consoles(Integer id, String model, String manufacturer, String memoryAmount, String processor, BigDecimal price, int quantity) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.memoryAmount = memoryAmount;
        this.processor = processor;
        this.price = price;
        this.quantity = quantity;
    }

    public Consoles() {
    }

    @Override
    public String toString() {
        return "Consoles{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryAmount='" + memoryAmount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consoles consoles = (Consoles) o;
        return quantity == consoles.quantity && Objects.equals(id, consoles.id) && Objects.equals(model, consoles.model) && Objects.equals(manufacturer, consoles.manufacturer) && Objects.equals(memoryAmount, consoles.memoryAmount) && Objects.equals(processor, consoles.processor) && Objects.equals(price, consoles.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemory_amount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
}