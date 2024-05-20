package com.myfintech.accountservice.service;

import com.myfintech.accountservice.restclient.ExchangeRateClient;
import com.myfintech.accountservice.restclient.response.RatesResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RateService {

  private ExchangeRateClient exchangeRateClient;

  /**
   * Get rate value
   *
   * @return double rate value
   */
  public double getRate() {
    double rate = 17.0;
    log.info("USD Rate : {}", rate);
    RatesResponse rates = exchangeRateClient.getRates("USD");
    rate = rates.getRates().get("MXN");
    log.info("USD Rate : {}", rate);
    return rate;
  }
}
