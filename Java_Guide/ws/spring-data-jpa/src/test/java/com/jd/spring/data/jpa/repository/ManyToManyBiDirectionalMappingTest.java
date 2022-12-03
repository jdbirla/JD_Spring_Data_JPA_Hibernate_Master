package com.jd.spring.data.jpa.repository;

import com.jd.spring.data.jpa.entity.Role;
import com.jd.spring.data.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by jd birla on 02-12-2022 at 12:39
 */
@SpringBootTest
public class ManyToManyBiDirectionalMappingTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void SaveRole() {
        User user = new User();

        user.setFirstName("Jitu");
        user.setLastName("Birla");
        user.setEmail("Jitu@gmail.com");
        user.setPassword("Secets");


        User admin = new User();

        admin.setFirstName("admin");
        admin.setLastName("admi1");
        admin.setEmail("admi1@gmail.com");
        admin.setPassword("admi1passs");



        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleAdmin.getUsers().add(user);
        roleAdmin.getUsers().add(admin);

        user.getRoles().add(roleAdmin);
        admin.getRoles().add(roleAdmin);

        roleRepository.save(roleAdmin);

    }


    @Test
    void fetchRole() {
        List<Role> all =roleRepository.findAll();
        all.forEach((r) -> {
            System.out.println(r.getName());
            r.getUsers().forEach(u -> System.out.println(u.getFirstName()));
        });
    }


}
