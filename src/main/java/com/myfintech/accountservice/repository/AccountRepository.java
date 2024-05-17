package com.myfintech.accountservice.repository;

import com.myfintech.accountservice.entity.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountEntity, String> {
}
