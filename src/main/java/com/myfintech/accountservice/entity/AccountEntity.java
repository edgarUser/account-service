package com.myfintech.accountservice.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
public class AccountEntity {

  @Id
  private String id;
  private String customerId;
  private Double amount;
  private Double amountUsd;
  private Date creation;
  private Date lastModification;
}
