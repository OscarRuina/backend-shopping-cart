package com.team98.shoppingcart.service.abstraction;

import com.team98.shoppingcart.model.request.UserAuthenticationRequest;
import com.team98.shoppingcart.model.response.UserDetailsResponse;

public interface IAuthenticationService {

    UserDetailsResponse login(UserAuthenticationRequest authenticationRequest);

}
