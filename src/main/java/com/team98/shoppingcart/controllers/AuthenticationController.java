package com.team98.shoppingcart.controllers;

import com.team98.shoppingcart.model.request.UserAuthenticationRequest;
import com.team98.shoppingcart.model.response.UserDetailsResponse;
import com.team98.shoppingcart.service.abstraction.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping(value = "api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailsResponse> login(
            @RequestBody UserAuthenticationRequest authenticationRequest) {
        UserDetailsResponse user = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(user);

    }

}