package com.team98.shoppingcart.common.converter;

import com.team98.shoppingcart.model.entity.User;
import com.team98.shoppingcart.model.response.UserRegisterResponse;
import org.springframework.stereotype.Component;

@Component
public class ConvertUtils {

    public UserRegisterResponse toResponse(User user, String jwt) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setId(user.getId());
        userRegisterResponse.setFirstName(user.getFirstName());
        userRegisterResponse.setLastName(user.getLastName());
        userRegisterResponse.setEmail(user.getEmail());
        userRegisterResponse.setAddress(user.getAddress());
        userRegisterResponse.setDeliveryDirection(user.getDeliveryDirection());
        userRegisterResponse.setPhone(user.getPhone());
        userRegisterResponse.setCity(user.getCity());
        userRegisterResponse.setState(user.getState());
        userRegisterResponse.setCountry(user.getCountry());
        userRegisterResponse.setPostCode(user.getPostCode());
        userRegisterResponse.setJwt(jwt);
        return userRegisterResponse;
    }
}