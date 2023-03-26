package com.example.homebudget.api.users;

import com.example.homebudget.domain.users.HomeBudgetUser;

record UserDetailsResponse(
        String username,
        String email,
        String userId
) {
    static UserDetailsResponse fromDomain(HomeBudgetUser user) {
        return new UserDetailsResponse(user.getUsername(), user.email(), user.userId().value());
    }
}
