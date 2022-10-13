package org.supermmx.leetcode.q00099;

import org.supermmx.leetcode.q00099.Q_00007.Q_00007_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00007_V1 extends Q_00007_Solution {
    public Q_00007_V1() {
        version = 1;
        name = "Normal mod and times";
        description = "";
        time = "";
        space = "";
        comment = "";
    }

    private static final int MAX_10 = Integer.MAX_VALUE / 10;
    private static final int MIN_10 = Integer.MIN_VALUE / 10;

    @Override
    public int reverse(int x) {
        // max: 2147483647, min: -2147483648

        int res = 0;
        int n = x;

        boolean positive = (x > 0);

        while (n != 0) {
            int d = n % 10;

            // check
            if (positive) {
                if (res > MAX_10
                    || (res == MAX_10
                        && d > 7)) {
                    res = 0;
                    break;
                }
            } else {
                // negative
                if (res < MIN_10
                    || (res == MIN_10
                        && d < -8)) {
                    res = 0;
                    break;
                }
            }

            res = res * 10 + d;

            log.debug("N: {}, D: {}, Res: {}", n, d, res);

            n = n / 10;
        }

        return res;
    }
}
