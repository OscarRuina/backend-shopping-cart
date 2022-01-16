package com.team98.shoppingcart.config.seeder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.team98.shoppingcart.model.entity.Product;
import com.team98.shoppingcart.repository.IProductRepository;

public class ProductsSeeder implements CommandLineRunner {

  private static final String IMAGE = "https://foo.jpg";

  @Autowired
  private IProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub
    loadProducts();
  }

  private void loadProducts() {
    if (productRepository.count() == 0) {
      loadProductsSeed();
    }
  }

  private void loadProductsSeed() {
    productRepository
        .save(buildProduct(1L, "name1", "alias1", "short1", "long1", new BigDecimal("1"),
            new BigDecimal("1"), 1,
        "category1", 1, "trademark1", 1.1, 1.1, 1.1, 1.1, 1, 1));

    productRepository
        .save(buildProduct(2L, "name2", "alias2", "short2", "long2", new BigDecimal("2"),
            new BigDecimal("2"), 2, "category2", 2, "trademark2", 2.2, 2.2, 2.2, 2.2, 2, 2));

    productRepository
        .save(buildProduct(3L, "name3", "alias3", "short3", "long3", new BigDecimal("3"),
            new BigDecimal("3"), 3, "category3", 3, "trademark3", 3.3, 3.3, 3.3, 3.3, 3, 3));

    productRepository
        .save(buildProduct(4L, "name4", "alias4", "short4", "long4", new BigDecimal("4"),
            new BigDecimal("4"), 4, "category4", 4, "trademark4", 4.4, 4.4, 4.4, 4.4, 4, 4));

    productRepository
        .save(buildProduct(5L, "name5", "alias5", "short5", "long5", new BigDecimal("5"),
            new BigDecimal("5"), 5, "category5", 5, "trademark5", 5.5, 5.5, 5.5, 5.5, 5, 5));

    productRepository
        .save(buildProduct(6L, "name6", "alias6", "short6", "long6", new BigDecimal("6"),
            new BigDecimal("6"), 6, "category6", 6, "trademark6", 6.6, 6.6, 6.6, 6.6, 6, 6));

    productRepository
        .save(buildProduct(7L, "name7", "alias7", "short7", "long7", new BigDecimal("7"),
            new BigDecimal("7"), 7, "category7", 7, "trademark7", 7.7, 7.7, 7.7, 7.7, 7, 7));

    productRepository
        .save(buildProduct(8L, "name8", "alias8", "short8", "long8", new BigDecimal("8"),
            new BigDecimal("8"), 8, "category8", 8, "trademark8", 8.8, 8.8, 8.8, 8.8, 8, 8));

    productRepository
        .save(buildProduct(9L, "name9", "alias9", "short9", "long99", new BigDecimal("9"),
            new BigDecimal("9"), 9, "category9", 9, "trademark9", 9.9, 9.9, 9.9, 9.9, 9, 9));

    productRepository.save(buildProduct(10L, "name10", "alias10", "short10", "long10",
        new BigDecimal("10"), new BigDecimal("10"), 10, "category10", 10, "trademark10", 10.10,
        10.10, 10.10, 10.10, 10, 10));
  }

  private Product buildProduct(long id, String name, String alias, String shortDescription,
      String longDescription, BigDecimal listPrice, BigDecimal webPrice, int discount,
      String category, int stock, String trademark, double weight, double height, double width,
      double lengthy, int score, int commentsCount) {
    return new Product(id, name, alias, shortDescription, longDescription, listPrice, webPrice,
        discount, IMAGE, false, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()),
        category, stock, trademark, weight, height, width, lengthy, score, commentsCount);
  }
}


