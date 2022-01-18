package com.team98.shoppingcart.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String address;
    private String deliveryDirection;
    private int phone;
    private String city;
    private String state;
    private String country;
    private String postCode;
    private String photo;

}
