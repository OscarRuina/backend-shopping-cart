package com.team98.shoppingcart.controllers;

import com.team98.shoppingcart.model.request.UserRegisterRequest;
import com.team98.shoppingcart.model.response.UserRegisterResponse;
import com.team98.shoppingcart.service.abstraction.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserRegisterService registerService;

    @PostMapping(value = "api/auth/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegisterResponse> register(
            @RequestBody UserRegisterRequest registerRequest) {
        return new ResponseEntity<>(registerService.register(registerRequest),HttpStatus.CREATED);
    }

}
