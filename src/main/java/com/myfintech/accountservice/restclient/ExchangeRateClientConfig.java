package com.myfintech.accountservice.restclient;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

public class ExchangeRateClientConfig {

  @Bean
  Retryer retryer() {
    return new Retryer.Default(500, 500, 5);
  }
}
