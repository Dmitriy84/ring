package com.utils;

import lombok.var;

public final class MathUtil {
  private MathUtil() {}

  public static double average(Integer numbers[]) {
    var sum = 0;

    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
    }

    return sum / numbers.length;
  }

  public static Double[] deviationSquares(Integer[] numbers, double average) {
    var deviations = new Double[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      deviations[i] = Math.pow(numbers[i] - average, 2);
    }

    return deviations;
  }
}
