package com.team98.shoppingcart.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CART_ITEMS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "CART_ITEMS_ID")
    private Long id;

    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @ManyToOne
    private Product product;

    @JoinColumn(name = "USERS_ID", nullable = false)
    @ManyToOne
    private User user;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

}