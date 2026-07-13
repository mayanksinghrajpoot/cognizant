package com.cognizant.algorithms.exercise7;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    /**
     * Simple Recursive Growth calculation.
     * Formula: FV = PV * (1 + growthRate)^periods
     * Recursive definition:
     *   Base case: periods == 0 -> return currentValue (PV)
     *   Recursive case: calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1)
     * Time Complexity: O(periods) - linear call stack depth.
     */
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    /**
     * Optimized Recursive Growth calculation using Memoization.
     * Prevents re-computing identical subproblems (although for simple exponential growth it is already O(N)).
     * For complex branching recursion (e.g. Fibonacci, grid paths), memoization reduces O(2^N) to O(N).
     */
    private static final Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double result = calculateFutureValueOptimized(currentValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, result);
        return result;
    }
}
