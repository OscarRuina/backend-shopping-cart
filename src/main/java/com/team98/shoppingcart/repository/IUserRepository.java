package com.team98.shoppingcart.repository;

import com.team98.shoppingcart.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}
