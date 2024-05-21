package com.myfintech.accountservice.service;

import com.myfintech.accountservice.entity.AccountEntity;
import com.myfintech.accountservice.mapper.AccountMapper;
import com.myfintech.accountservice.model.Account;
import com.myfintech.accountservice.repository.AccountRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

  private AccountRepository repository;
  private AccountMapper mapper;
  private RateService rateService;

  /**
   * Get all the accounts saved here in memory.
   *
   * @return List of accounts
   */
  @Override
  public List<Account> getAccounts() {
    List<Account> accounts = repository.findAll().stream().map(entity -> mapper.toAccountModel(entity)).toList();
    accounts.forEach(account -> account.setAmountUsd(account.getAmount() * rateService.getRate()));
    return accounts;
  }

  /**
   * Get account by id saved here in memory.
   *
   * @param accountId id of the account
   * @return Optional Account value
   */
  @Override
  public Account getAccount(String accountId) {
    Optional<AccountEntity> accountEntity = repository.findById(accountId);
    return accountEntity.isPresent() ? mapper.toAccountModel(accountEntity.get()) : Account.builder().build();
  }

  /**
   * Save account into db
   *
   * @param account account details
   * @return Account same object send
   */
  @Override
  public Account saveAccount(Account account) {
    account.setLastModification(new Date());
    account.setAmountUsd(account.getAmount() * rateService.getRate());
    account.setId(repository.save(mapper.toAccountEntity(account)).getId());
    return account;
  }
}
