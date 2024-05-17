package com.myfintech.accountservice.service;

import com.myfintech.accountservice.model.Account;
import java.util.List;

public interface AccountService {
  List<Account> getAccounts();

  Account getAccount(String accountId);

  Account saveAccount(Account account);
}
