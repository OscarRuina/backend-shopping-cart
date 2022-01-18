package com.team98.shoppingcart.service.implementation;

import com.team98.shoppingcart.model.entity.Role;
import com.team98.shoppingcart.repository.IRoleRepository;
import com.team98.shoppingcart.service.abstraction.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findBy(String name) {
        return roleRepository.findByName(name);
    }
}
