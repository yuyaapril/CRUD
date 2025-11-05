package com.bib.ojt.system.config;

import com.bib.ojt.system.config.components.CustomSuccessLoginHandler;
import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Project  စ run ရင် configuration စ အလုပ်လုပ်
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, CustomSuccessLoginHandler customSuccessLoginHandler) throws Exception {
        //route filter
        //Custom
        //login(login page ,success url
        //logout (logout page , logout success url)
        //403 pages
        //401 not login yet => login page

        //Rout
        //Permission
        //(Home . about us , permission all)
        //(User detail info list , permission AD)
        //(Information , user register , user AD)
        //(Information , user register , user )

        //route filter
        http.authorizeHttpRequests(auth -> auth
                .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
                .requestMatchers("/", "/about" ,"contact-us","/css/**" ,"/js/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated() //logined
        )
                .formLogin(login -> login
                        .loginPage("/login")
                        .successHandler(customSuccessLoginHandler)
//                        .defaultSuccessUrl("/success")
                        .permitAll()
                );

        return http.build();
    }
}
