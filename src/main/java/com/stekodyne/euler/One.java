package com.stekodyne.euler;

public class One {

    public static long run(long upto) {
        long sum = 0;

        // Time complexity O(log n)
        if (upto > 2) {
            sum += getSeriesSum(upto, 3);
        }

        if (upto > 4) {
            sum += getSeriesSum(upto, 5);
        }

        if (upto > 14) {
            sum -= getSeriesSum(upto, 15);
        }

        return sum;
    }

    private static long getSeriesSum(long upto, long multiplier) {
        long multiplicand = 0;

        multiplicand = searchMaxFactor(upto, multiplier);

        return summation(multiplier, multiplicand);
    }

    private static long searchMaxFactor(long upto, long multiplier) {
        return searchMaxFactor(upto, multiplier, 1, upto);
    }

    private static long searchMaxFactor(long upto, long multiplier, long low, long high) {
        long lo = low;
        long hi = high;
        long found = 0;
        while (lo <= hi) {

            if (lo == hi) {
                if (upto > (multiplier * lo)) {
                    found = lo;
                }
                break;
            }

            long mid = lo + (hi - lo) / 2;

            if (upto < (multiplier * mid)) {
                found = mid;
                hi = mid - 1;
            } else if (upto > (multiplier * mid)) {
                found = mid;
                lo = mid + 1;
            } else if (upto == (multiplier * mid)) {
                found = mid - 1;
                break;
            }
        }
        return found;
    }

    private static long summation(long multiplier, long multiplicand) {
        return (multiplicand * (multiplier * multiplicand + multiplier)) / 2;
    }

}
