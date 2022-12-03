package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Role;
import com.jd.spring.data.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.relation.RoleResult;

/**
 * Created by jd birla on 02-12-2022 at 12:39
 */
@SpringBootTest
public class ManyToManyUniDirectionalMappingTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void SaveUser() {
        User user = new User();

        user.setFirstName("Jitu");
        user.setLastName("Birla");
        user.setEmail("Jitu@gmail.com");
        user.setPassword("Secets");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        userRepository.save(user);

    }

    @Test
    void updateUser() {
        User user = userRepository.findById(1L).get();
        user.setFirstName("BABU");
        user.setEmail("BABU@GMAIL.COM");


        Role user_role = new Role();
        user_role.setName("ROLE_USER");

        user.getRoles().add(user_role);
        userRepository.save(user);

    }

    @Test
    void fetchUser() {
        User user = userRepository.findById(1L).get();
        System.out.println(user.getRoles());
        System.out.println(user);

    }

    @Test
    void  deleteUser() {
       userRepository.deleteById(1L);


    }
}
