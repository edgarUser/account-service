package com.myfintech.accountservice.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {
  private String id;
  private String customerId;
  private Double amount;
  private Double amountUsd;
  private Date creation;
  private Date lastModification;
}
