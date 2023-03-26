package com.example.homebudget.domain.users;

import org.springframework.stereotype.Service;

import java.util.List;


public interface UserRegistrationService {
    List<String>  defaultRoles = List.of("USER");
    HomeBudgetUser registerNewUser (String userName, String password, String email, List<String> roles);
}
