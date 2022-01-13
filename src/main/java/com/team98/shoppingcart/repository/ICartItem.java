package com.team98.shoppingcart.repository;

import com.team98.shoppingcart.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItem extends JpaRepository<CartItem, Long> {

}
