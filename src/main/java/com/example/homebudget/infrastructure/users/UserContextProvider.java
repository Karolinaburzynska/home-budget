package com.example.homebudget.infrastructure.users;

import com.example.homebudget.domain.users.HomeBudgetUser;
import org.springframework.security.core.context.SecurityContextHolder;

public enum UserContextProvider {
    INSTANCE;

    public static HomeBudgetUser getUserContext(){
        return (HomeBudgetUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
