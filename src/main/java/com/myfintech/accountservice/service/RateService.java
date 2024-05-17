package com.myfintech.accountservice.service;

import org.springframework.stereotype.Service;

@Service
public class RateService {
  private static final double RATE = 16.70;

  /**
   * Get rate value
   *
   * @return double rate value
   */
  public double getRate() {
    return RATE;
  }
}
