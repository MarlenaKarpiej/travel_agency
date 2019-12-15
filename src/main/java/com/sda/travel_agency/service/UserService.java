package com.sda.travel_agency.service;

import com.sda.travel_agency.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface  UserService {
    void registerUser(String username, String password, String passwordConfirm);

    List<AppUser> getAllUsers();

    Optional<AppUser> findUserByUsername(String username);

}
