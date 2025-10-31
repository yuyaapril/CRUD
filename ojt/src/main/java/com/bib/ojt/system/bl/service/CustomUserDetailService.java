package com.bib.ojt.system.bl.service;


import com.bib.ojt.system.persistence.dao.user.UserRepository;
import com.bib.ojt.system.persistence.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class CustomUserDetailService implements UserDetailsService {

//    @Autowired
//    private UserRepository userRepository;

//    Constructor Injection
    private final UserRepository userRepository;
    CustomUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= this.userRepository.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .roles(user.getRole().getName())
                .build();
    }
}
