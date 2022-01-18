package com.team98.shoppingcart.config.seeder;

import com.team98.shoppingcart.config.ApplicationRole;
import com.team98.shoppingcart.model.entity.Role;
import com.team98.shoppingcart.model.entity.User;
import com.team98.shoppingcart.repository.IRoleRepository;
import com.team98.shoppingcart.repository.IUserRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersSeeder implements CommandLineRunner {

    private static final String PHOTO = "https://foo.jpg";

    private static final long ROLE_USER = 1L;

    private static final long ROLE_ADMIN = 2L;

    private static final String PASSWORD = "12345";

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
        loadRoles();
        loadUsers();
    }

    private void loadRoles() {
        if (roleRepository.count() == 0) {
            roleRepository.save(buildRole(ApplicationRole.USER));
            roleRepository.save(buildRole(ApplicationRole.ADMIN));
        }
    }

    private Role buildRole(ApplicationRole applicationRole) {
        Role role = new Role();
        role.setId(getRoleId(applicationRole));
        role.setName(applicationRole.getFullRoleName());
        return role;
    }

    private long getRoleId(ApplicationRole applicationRole) {
        return applicationRole == ApplicationRole.USER ? ROLE_USER : ROLE_ADMIN;
    }

    private void loadUsers() {
        if (userRepository.count() == 0) {
            loadUsersWithRoleUser();
            loadUsersWithRoleAdmin();
        }
    }

    private void loadUsersWithRoleUser() {
        userRepository.save(
                buildUser(1L, "Homero", "Simpson", "hsimpson@gmail.com", "Siempreviva 1234",
                        "Siempreviva 1234", 5551111, "Lanus", "Buenos Aires", "Argentina", "1010"));
        userRepository.save(
                buildUser(2L, "Bart", "Simpson", "bsimpson@gmail.com", "Siempreviva 1234",
                        "Siempreviva 1234", 5551111, "Lanus", "Buenos Aires", "Argentina", "1010"));
        userRepository.save(
                buildUser(3L, "Lisa", "Simpson", "lsimpson@gmail.com", "Siempreviva 1234",
                        "Siempreviva 1234", 5551111, "Lanus", "Buenos Aires", "Argentina", "1010"));
    }

    private void loadUsersWithRoleAdmin() {
        userRepository.save(
                buildUserAdmin(4L, "Joaquin", "Aman", "jaman@gmail.com", "Calle Falsa 1234",
                        "Calle Falsa 1234", 1122223333, "Lanus", "Buenos Aires", "Argentina",
                        "1010"));
        userRepository.save(
                buildUserAdmin(5L, "Matias", "Cevini", "mcevini@gmail.com", "Calle Falsa 1235",
                        "Calle Falsa 1235", 1122224444, "Lanus", "Buenos Aires", "Argentina",
                        "1010"));
        userRepository.save(
                buildUserAdmin(6L, "Oscar", "Ruina", "oruina@gmail.com", "Calle Falsa 1236",
                        "Calle Falsa 1236", 1122225555, "Banfield", "Buenos Aires", "Argentina",
                        "1010"));
    }

    private User buildUser(long id, String firstname, String lastname, String email, String address,
            String deliveryDirection, int phone, String city, String state, String country,
            String postcode) {
        return new User(id, firstname, lastname, email, bCryptPasswordEncoder.encode(PASSWORD),
                address, deliveryDirection, phone, city, state, country, postcode, PHOTO,
                List.of(roleRepository.findById(ROLE_USER).get()), Timestamp.from(Instant.now()),
                false);
    }

    private User buildUserAdmin(long id, String firstname, String lastname, String email,
            String address,
            String deliveryDirection, int phone, String city, String state, String country,
            String postcode) {
        return new User(id, firstname, lastname, email, bCryptPasswordEncoder.encode(PASSWORD),
                address, deliveryDirection, phone, city, state, country, postcode, PHOTO,
                List.of(roleRepository.findById(ROLE_ADMIN).get()), Timestamp.from(Instant.now()),
                false);
    }
}
