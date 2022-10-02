package org.supermmx.leetcode.q00099;

import static org.supermmx.leetcode.common.Tag.*;

import java.util.Arrays;
import java.util.List;

import org.supermmx.leetcode.common.Problem;
import org.supermmx.leetcode.common.Solution;
import org.supermmx.leetcode.common.Problem.Difficulty;

/**
 * No.3 Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @difficulty medium
 * @tags hash-table, string, sliding-window
 */
public interface Q_00005 {
    public abstract String longestPalindrome(String s);

    public abstract class Q_00005_Solution extends Solution implements Q_00005 {
        protected Q_00005_Solution() {
            this.problem = P00005;
        }

        @Override
        public Object solve(Object... args) {
            return longestPalindrome((String)args[0]);
        }
    }

    public static final Problem P00005 = Problem.builder()
            .index(5)
            .title("Longest Palindromic Substring")
            .description("Given a string s, return the longest palindromic substring in s.")
            .link("https://leetcode.com/problems/longest-palindromic-substring/")
            .difficulty(Difficulty.MEDIUM)
            .tags(Arrays.asList(STRING, DYNAIC_PROGRAMMING))
            .build();

    /**
     * To get all the versions
     */
    public static List<Class<? extends Solution>> getVersions() {
        return Arrays.asList(Q_00005_V1.class);
    }

}
