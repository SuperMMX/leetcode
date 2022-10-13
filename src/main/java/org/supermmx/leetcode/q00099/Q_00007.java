package org.supermmx.leetcode.q00099;

import static org.supermmx.leetcode.common.Tag.*;

import java.util.Arrays;
import java.util.List;

import org.supermmx.leetcode.common.Problem;
import org.supermmx.leetcode.common.Solution;
import org.supermmx.leetcode.common.Problem.Difficulty;

/**
 * No.7 Reverse Integer
 */
public interface Q_00007 {
    public abstract int reverse(int x);

    public abstract class Q_00007_Solution extends Solution implements Q_00007 {
        protected Q_00007_Solution() {
            this.problem = P00007;
        }

        @Override
        public Object solve(Object... args) {
            return reverse((int)args[0]);
        }
    }

    public static final Problem P00007 = Problem.builder()
            .index(7)
            .title("Reverse Integer")
            .description("Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.")
            .link("https://leetcode.com/problems/reverse-integer/")
            .difficulty(Difficulty.MEDIUM)
            .tags(Arrays.asList(MATH))
            .build();

    /**
     * To get all the versions
     */
    public static List<Class<? extends Solution>> getVersions() {
        return Arrays.asList(Q_00007_V1.class);
    }

}
