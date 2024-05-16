package com.myfintech.accountservice.service;

import com.myfintech.accountservice.model.Account;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class InMemoryAccountService implements AccountService {

  private static final double RATE = 16.70;
  private final List<Account> accounts;

  /**
   * Constructor to initialize the in memory accounts.
   * */
  public InMemoryAccountService() {
    accounts = new ArrayList<>(List.of(
        Account.builder().id("abc-123")
            .customerId("c-001")
            .amount(1000.00)
            .creation(new Date())
            .lastModification(new Date()).build()));
  }

  /**
   * Get all the accounts saved here in memory.
   * @return List of accounts
   * */
  @Override
  public List<Account> getAccounts() {
    accounts.forEach(account -> account.setAmountUsd(account.getAmount() * RATE));
    return accounts;
  }

  /**
   * Get account by id saved here in memory.
   * @param accountId id of the account
   * @return Optional Account value
   * */
  @Override
  public Optional<Account> getAccount(String accountId) {
    return accounts.stream().filter(account -> account.getId().equals(accountId)).findFirst();
  }
}
