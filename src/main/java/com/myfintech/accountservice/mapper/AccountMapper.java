package com.myfintech.accountservice.mapper;

import com.myfintech.accountservice.entity.AccountEntity;
import com.myfintech.accountservice.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  Account toAccountModel(AccountEntity accountEntity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "creation", expression = "java(new java.util.Date())")
  AccountEntity toAccountEntity(Account account);
}
