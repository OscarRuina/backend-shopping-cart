package com.team98.shoppingcart.service.implementation;

import com.team98.shoppingcart.common.JwtUtil;
import com.team98.shoppingcart.common.converter.ConvertUtils;
import com.team98.shoppingcart.config.ApplicationRole;
import com.team98.shoppingcart.model.entity.Role;
import com.team98.shoppingcart.model.entity.User;
import com.team98.shoppingcart.model.request.UserAuthenticationRequest;
import com.team98.shoppingcart.model.request.UserRegisterRequest;
import com.team98.shoppingcart.model.response.UserDetailsResponse;
import com.team98.shoppingcart.model.response.UserRegisterResponse;
import com.team98.shoppingcart.repository.IUserRepository;
import com.team98.shoppingcart.service.abstraction.IAuthenticationService;
import com.team98.shoppingcart.service.abstraction.IUserRegisterService;
import com.team98.shoppingcart.service.abstraction.IRoleService;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService, IAuthenticationService,
        IUserRegisterService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ConvertUtils convertUtils;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format("User {0} not found.", username));
        }
        return user;
    }

    @Override
    public UserDetailsResponse login(UserAuthenticationRequest authenticationRequest) {

        User user = userRepository.findByEmail(authenticationRequest.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format("User {0} not found.", authenticationRequest.getEmail()));
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        return new UserDetailsResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getAddress(),
                user.getDeliveryDirection(),
                user.getPhone(),
                user.getCity(),
                user.getState(),
                user.getCountry(),
                user.getPostCode(),
                user.getPhoto(),
                jwtUtil.generateToken(user));
    }

    @Override
    @Transactional
    public UserRegisterResponse register(UserRegisterRequest registerRequest) {

        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            throw new BadCredentialsException("User already registered!!!");
        }
        User user = userRepository.save(buildUser(registerRequest));
        return convertUtils.toResponse(user, jwtUtil.generateToken(user));
    }

    private User buildUser(UserRegisterRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
        user.setAddress(registerRequest.getAddress());
        user.setDeliveryDirection(registerRequest.getDeliveryDirection());
        user.setPhone(registerRequest.getPhone());
        user.setCity(registerRequest.getCity());
        user.setState(registerRequest.getState());
        user.setCountry(registerRequest.getCountry());
        user.setPostCode(registerRequest.getPostCode());
        user.setPhoto(registerRequest.getPhoto());
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName(ApplicationRole.USER.getFullRoleName()));
        user.setRoles(roles);
        return user;
    }
}
