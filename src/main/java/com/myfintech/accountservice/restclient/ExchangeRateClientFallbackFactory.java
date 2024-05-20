package com.myfintech.accountservice.restclient;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateClientFallbackFactory implements FallbackFactory<FallbackWithFactory> {
  @Override
  public FallbackWithFactory create(Throwable cause) {
    return new FallbackWithFactory(cause);
  }
}
