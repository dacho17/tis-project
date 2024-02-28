package com.tistask.popproducts.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

    @Column(name = "created_date")
	private Timestamp createdDate;

    @Column(name = "code", unique = true, length = 15)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "price_eur")
    private double priceEUR;

    @Column(name = "price_usd")
    private double priceUSD;

    @Column(name = "description")
    private String description;

    public Product() {}

    public Product(Timestamp createdDate, String code, String name, double priceEUR, double priceUSD, String description) {
        this.createdDate = createdDate;
        this.code = code;
        this.name = name;
        this.priceEUR = priceEUR;
        this.priceUSD = priceUSD;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceEUR() {
        return priceEUR;
    }

    public void setPriceEUR(double priceEUR) {
        this.priceEUR = priceEUR;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", createdDate=" + createdDate + ", code=" + code + ", priceEUR=" + priceEUR
                + ", priceUSD=" + priceUSD + ", description=" + description + "]";
    }
}
