package com.sda.travel_agency.service;

import com.sda.travel_agency.entity.AppUser;
import com.sda.travel_agency.entity.UserRole;
import com.sda.travel_agency.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService{

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> appUserOptional = appUserRepository.findByEmail(email);
        if (appUserOptional.isPresent()) {
            AppUser appUser = appUserOptional.get();

            String[] rolesArray = appUser.getRoles()
                    .stream()
                    .map(UserRole::getName)
                    .toArray(String[]::new);

            return User.builder()
                    .username(appUser.getEmail())
                    .password(appUser.getPassword())
                    .roles(rolesArray)
                    .build();
        }

        throw new UsernameNotFoundException("Unable to find user with that email.");
    }
}
