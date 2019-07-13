package com.sda.travel_agency.service;

import com.sda.travel_agency.entity.UserRole;

import java.util.Set;

public interface  UserRoleService {
    Set<UserRole> getDefaultUserRoles();
}
