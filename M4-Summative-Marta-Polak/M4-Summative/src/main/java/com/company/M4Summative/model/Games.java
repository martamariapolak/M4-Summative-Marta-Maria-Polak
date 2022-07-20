package com.company.M4Summative.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "game")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
    @Column(name = "game_id")
    private Integer id;

//    @NotEmpty
    @NotNull
    @Length(max = 50, min = 1)
    private String title;

    @NotNull
    @Column(name = "esrb_rating ")
//    @Length(max = 50, min = 1)
    private int ESRBRating;

//    @NotEmpty
    @NotNull
    @Length(max = 255, min = 1)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotEmpty
//    @NotNull
    @Length(max = 50, min = 1)
    private String studio;

    @NotNull
    private int quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getESRBRating() {
        return ESRBRating;
    }

    public void setESRBRating(int ESRBRating) {
        this.ESRBRating = ESRBRating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Games(Integer id, String title, int ESRBRating, String description, BigDecimal price, String studio, int quantity) {
        this.id = id;
        this.title = title;
        this.ESRBRating = ESRBRating;
        this.description = description;
        this.price = price;
        this.studio = studio;
        this.quantity = quantity;
    }

    public Games() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return id == games.id && ESRBRating == games.ESRBRating && quantity == games.quantity && Objects.equals(title, games.title) && Objects.equals(description, games.description) && Objects.equals(price, games.price) && Objects.equals(studio, games.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ESRBRating, description, price, studio, quantity);
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ESRBRating=" + ESRBRating +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}