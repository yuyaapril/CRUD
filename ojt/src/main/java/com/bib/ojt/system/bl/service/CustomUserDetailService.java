package com.bib.ojt.system.bl.service;


import com.bib.ojt.system.persistence.dao.user.CustomUserRepository;
import com.bib.ojt.system.persistence.entity.CustomUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

//   @Autowired
//    private UserRepository userRepository;

//    Constructor Injection
    private final CustomUserRepository customUserRepository;
    CustomUserDetailService(CustomUserRepository customUserRepository){
        this.customUserRepository = customUserRepository;
    }

    /**
     * @param username , login data
     * @return
     * @throws UsernameNotFoundException
     * */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       CustomUser customUser = this.customUserRepository.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return User
                .withUsername(username)
                .password(customUser.getPassword())
                .roles(customUser.getRole().getName())
                .build();
    }
}
