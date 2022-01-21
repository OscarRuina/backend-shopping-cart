package com.team98.shoppingcart.service.abstraction;

import com.team98.shoppingcart.model.entity.Role;

public interface IRoleService {

    Role findByName(String name);
}
