package com.myfintech.accountservice.service;

import com.myfintech.accountservice.model.Account;
import java.util.List;
import java.util.Optional;

public interface AccountService {
  List<Account> getAccounts();
  Optional<Account> getAccount(String accountId);
}
