package service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private static final double RATE = 16.70;

  /**
   * Method to do the rate conversion.
   * @param a matrix of vales
   * @return matrix of values converted
   * */
  public double[] conversion(double[] a) {
    double[] result = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      result[i] = RATE * a[i];
    }
    return result;
  }
}
