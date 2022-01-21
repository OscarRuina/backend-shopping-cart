
package com.team98.shoppingcart.service.abstraction;

import com.team98.shoppingcart.model.request.UserRegisterRequest;
import com.team98.shoppingcart.model.response.UserRegisterResponse;

public interface IUserRegisterService {

    UserRegisterResponse register(
            UserRegisterRequest registerRequest);

}