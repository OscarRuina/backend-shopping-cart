package com.team98.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.team98.shoppingcart.model.entity.Product;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}
