package com.team98.shoppingcart.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsResponse {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonInclude(Include.NON_NULL)
    private String password;
    private String address;
    private String deliveryDirection;
    private int phone;
    private String city;
    private String state;
    private String country;
    private String postCode;
    private String photo;
    @JsonInclude(Include.NON_NULL)
    private String jwt;

}
