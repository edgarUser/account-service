package com.myfintech.accountservice.restclient;

import com.myfintech.accountservice.restclient.response.RatesResponse;
import feign.FeignException;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;

public class FallbackWithFactory implements ExchangeRateClient {

  private final Throwable cause;

  public FallbackWithFactory(Throwable cause) {
    this.cause = cause;
  }

  @Override
  public RatesResponse getRates(String base) {
    if (cause instanceof FeignException.BadRequest) {
      return null;
    }
    throw new NoFallbackAvailableException("Throwing Runtime Exception", new RuntimeException());
  }
}
