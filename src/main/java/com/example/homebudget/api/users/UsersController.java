package com.example.homebudget.api.users;

import com.example.homebudget.domain.users.HomeBudgetUser;
import com.example.homebudget.domain.users.UserRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/users")
@RestController
public class UsersController {

    private final UserRegistrationService registrationService;

    // Constructor
    UsersController(UserRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    ResponseEntity<UserDetailsResponse> registerNewUser(
            @Valid @RequestBody UserRegistrationRequest request
    ) {
        HomeBudgetUser homeBudgetUser = registrationService.registerNewUser(request.name(), request.password(), request.email(),UserRegistrationService.defaultRoles);
      return ResponseEntity.ok(UserDetailsResponse.fromDomain(homeBudgetUser));

    }
}
