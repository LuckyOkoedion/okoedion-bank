package com.lucky.OkoedionBank.Auth;

import com.lucky.OkoedionBank.Entities.UserEntity;
import com.lucky.OkoedionBank.Repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    private UserRepository applicationUserRepository;

    public ApplicationUserDetailsService(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity applicationUser = applicationUserRepository.findByEmail(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
    }

}
