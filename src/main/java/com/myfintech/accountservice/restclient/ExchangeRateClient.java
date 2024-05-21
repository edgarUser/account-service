package com.myfintech.accountservice.restclient;

import com.myfintech.accountservice.restclient.response.RatesResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "exchangeService",
    url = "https://open.er-api.com",
    fallbackFactory = ExchangeRateClientFallbackFactory.class,
    configuration = ExchangeRateClientConfig.class)
public interface ExchangeRateClient {

  @CircuitBreaker(name = "exchangeServiceCircuitBraker")
  @RequestMapping(method = RequestMethod.GET, value = "/v6/latest/{base}")
  RatesResponse getRates(@PathVariable String base);
}
