package org.supermmx.leetcode.q00099;

import static org.supermmx.leetcode.common.Tag.*;

import java.util.Arrays;
import java.util.List;

import org.supermmx.leetcode.common.Problem;
import org.supermmx.leetcode.common.Solution;
import org.supermmx.leetcode.common.Problem.Difficulty;

/**
 * No.8 String to Integer (atoi)
 */
public interface Q_00008 {
    public abstract int myAtoi(String s);

    public abstract class Q_00008_Solution extends Solution implements Q_00008 {
        protected Q_00008_Solution() {
            this.problem = P00008;
        }

        @Override
        public Object solve(Object... args) {
            return myAtoi((String)args[0]);
        }
    }

    public static final Problem P00008 = Problem.builder()
            .index(8)
            .title("String to Integer (atoi)")
            .description("Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).")
            .link("https://leetcode.com/problems/string-to-integer-atoi/")
            .difficulty(Difficulty.MEDIUM)
            .tags(Arrays.asList(STRING))
            .build();

    /**
     * To get all the versions
     */
    public static List<Class<? extends Solution>> getVersions() {
        return Arrays.asList(Q_00008_V1.class);
    }

}
