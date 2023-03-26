package com.example.homebudget.infrastructure.users;

import com.example.homebudget.domain.users.HomeBudgetUser;

import java.util.Optional;

public interface UserRepository {
    Optional<HomeBudgetUser> findByName(String name);
    HomeBudgetUser save(HomeBudgetUser homeBudgetUser);
    boolean existsByEmailOrName(String email, String name);

}
