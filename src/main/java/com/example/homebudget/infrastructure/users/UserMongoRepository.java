package com.example.homebudget.infrastructure.users;

import com.example.homebudget.domain.users.HomeBudgetUser;
import com.example.homebudget.domain.users.UserId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserMongoRepository extends MongoRepository<HomeBudgetUser, UserId>, UserRepository {
}
