package com.myfintech.accountservice.controller;

import com.myfintech.accountservice.model.Account;
import com.myfintech.accountservice.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AccountController {

  private AccountService accountService;

  /**
   * Get all the accounts.
   *
   * @return List of accounts
   */
  @GetMapping(path = "/accounts")
  public ResponseEntity<List<Account>> getAccounts() {
    return new ResponseEntity<>(accountService.getAccounts(), HttpStatusCode.valueOf(200));
  }

  /**
   * Create and account.
   *
   * @param account account details
   * @return Account send in the request
   */
  @PostMapping(path = "/accounts")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    return new ResponseEntity<>(accountService.saveAccount(account), HttpStatusCode.valueOf(200));
  }

  /**
   * Get account by id.
   *
   * @param accountId id of the account
   * @return Optional Account value
   */
  @GetMapping(path = "/accounts/{accountId}")
  public ResponseEntity<Account> getAccount(@PathVariable(name = "accountId") String accountId) {
    return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatusCode.valueOf(200));
  }

}
