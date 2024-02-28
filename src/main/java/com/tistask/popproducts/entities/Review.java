package com.tistask.popproducts.entities;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
    
    @Column(name = "created_date")
	private Timestamp createdDate;

    @Column(name = "reviewer")
    private String reviewer;

    @Column(name = "text")
    private String text;

    @Column(name = "rating")
    private short rating;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

    public Review() {}

    public Review(Timestamp createdDate, String reviewer, String text, short rating, Product product) {
        this.createdDate = createdDate;
        this.reviewer = reviewer;
        this.text = text;
        this.rating = rating;
        this.product = product;
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

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", createdDate=" + createdDate + ", reviewer=" + reviewer + ", text=" + text
                + ", rating=" + rating + ", productId=" + product.getId()+ "]";
    }
}
