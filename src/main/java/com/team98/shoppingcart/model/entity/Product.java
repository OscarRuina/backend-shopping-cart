package com.team98.shoppingcart.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ALIAS", nullable = true)
    private String alias;

    @Column(name = "SHORT_DESCRIPTION", nullable = false, length = 100)
    private String shortDescription;

    @Column(name = "LONG_DESCRIPTION", nullable = false, length = 255)
    private String longDescription;

    @Column(name = "LIST_PRICE", nullable = false)
    private BigDecimal listPrice;

    @Column(name = "WEB_PRICE", nullable = false)
    private BigDecimal webPrice;

    @Column(name = "DISCOUNT", nullable = true)
    private int discount;

    @Column(name = "IMAGE", nullable = true)
    private String image;

    @Column(name = "SOFT_DELETE", nullable = true)
    private boolean softDelete;

    @CreationTimestamp
    @Column(name = "CREATION_DATE", nullable = true)
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name = "UPDATE_DATE", nullable = true)
    private Timestamp updateDate;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "STOCK", nullable = false)
    private int stock;

    @Column(name = "TRADEMARK", nullable = false)
    private String trademark;

    @Column(name = "WEIGHT", nullable = true)
    private double weight;

    @Column(name = "HEIGHT", nullable = true)
    private double height;

    @Column(name = "WIDTH", nullable = true)
    private double width;

    @Column(name = "LENGTHY", nullable = true)
    private double lengthy;

    @Column(name = "SCORE", nullable = true)
    private int score;

    @Column(name = "COMMENTS_COUNT", nullable = true)
    private int commentsCount;

}
