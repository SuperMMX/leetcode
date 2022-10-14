package org.supermmx.leetcode.q00099;

import org.supermmx.leetcode.q00099.Q_00008.Q_00008_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00008_V1 extends Q_00008_Solution {
    public Q_00008_V1() {
        version = 1;
        name = "Check Tenth";
        description = "Check against MAX_VALUE / 10 or MIN_VALUE / 10 and the remainder";
        timeO = "O(n)";
        spaceO = "O(c)";
        execTime = 4;
        execTimePercentage = 41.74;
        execMemory = 43;
        execMemoryPercentage = 54.25;
        comment = "";
    }

    private static final int MAX_10 = Integer.MAX_VALUE / 10;

    @Override
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }

        // max: 2147483647, min: -2147483648

        char[] chars = s.toCharArray();
        int n = chars.length;

        boolean positive = true;
        int res = 0;

        int i = 0;

        // leading spaces
        while (i < n && chars[i] == ' ') {
            i ++;
        }

        // sign
        if (i < n) {
            char c = chars[i];
            if (c == '-') {
                positive = false;
                i ++;
            } else if (c == '+') {
                positive = true;
                i ++;
            }
        }

        // read left chars
        while (i < n) {
            char c = chars[i];

            // non-digits, stop here
            if (c < '0' || c > '9') {
                break;
            }

            int d = c - '0';

            // check
            if (res > MAX_10
                || (res == MAX_10
                    && ((positive && d > 7)
                        || (!positive && d > 8))
                    )) {
                if (positive) {
                    res = Integer.MAX_VALUE;
                } else {
                    res = Integer.MIN_VALUE;
                }

                return res;
            }

            res = res * 10 + d;

            i ++;
        }

        // final value with correct sign
        if (!positive) {
            res = -res;
        }

        return res;
    }
}
