package com.cognizant.algorithms.exercise7;

public class Exercise7Demo {
    public static void run() {
        System.out.println("\n=== Exercise 7: Financial Forecasting ===");

        double presentValue = 1000.0; // Initial investment
        double growthRate = 0.05;     // 5% growth rate
        int periods = 10;            // 10 years

        System.out.println("Calculating Future Value recursively for PV = $1000, Growth = 5%, 10 periods...");
        double fv = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("Future Value: $%.2f%n", fv);

        System.out.println("\nCalculating using Optimized Memoized method...");
        double fvOpt = FinancialForecasting.calculateFutureValueOptimized(presentValue, growthRate, periods);
        System.out.printf("Memoized Future Value: $%.2f%n", fvOpt);

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Basic Recursion: O(periods) call stack depth since we make one call per period.");
        System.out.println("- Optimization: Memoization stores intermediate results to avoid redundant tree calculations in branching recursions.");
    }
}
