package com.bib.ojt.system.config;

import com.bib.ojt.system.persistence.dao.role.RoleRepository;
import com.bib.ojt.system.persistence.dao.user.CustomUserRepository;
import com.bib.ojt.system.persistence.entity.CustomUser;
import com.bib.ojt.system.persistence.entity.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            CustomUserRepository customUserRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ){
        return args -> {
            //Role
            Role adminRole = roleRepository.findByName("ADMIN")
                    .orElseGet(() -> roleRepository.save(new Role(null, "ADMIN")));
            Role userRole = roleRepository.findByName("USER")
                    .orElseGet(() -> roleRepository.save(new Role(null, "USER")));

            // Role adminRole =  roleRepository.findByName("ADMIN");
            //if( adminRole == null){
            //create admin role }

            //User table
            if(customUserRepository.findByUsername("admin").isEmpty()){
                CustomUser admin = new CustomUser();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole(adminRole);
                customUserRepository.save(admin);
                System.out.println("admin  - admin123 , user created!...");

                if(customUserRepository.findByUsername("user").isEmpty()){
                    CustomUser user = new CustomUser();
                    user.setUsername("user");
                    user.setPassword(passwordEncoder.encode("user123"));
                    user.setRole(userRole);
                    customUserRepository.save(user);
                    System.out.println("user  - user123 , user created!...");
                }
            }
        };
    }
}
