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
public interface Q_00003 {
    public abstract int lengthOfLongestSubstring(String s);

    public abstract class Q_00003_Solution extends Solution implements Q_00003 {
        protected Q_00003_Solution() {
            this.problem = P00003;
        }

        @Override
        public Object solve(Object... args) {
            return lengthOfLongestSubstring((String)args[0]);
        }
    }

    public static final Problem P00003 = Problem.builder()
            .index(3)
            .title("Longest Substring Without Repeating Characters")
            .description("Given a string s, find the length of the longest substring without repeating characters.")
            .link("https://leetcode.com/problems/longest-substring-without-repeating-characters/")
            .difficulty(Difficulty.MEDIUM)
            .tags(Arrays.asList(HASH_TABLE, STRING, SLIDING_WINDOW))
            .build();

    /**
     * To get all the versions
     */
    public static List<Class<? extends Solution>> getVersions() {
        return Arrays.asList(Q_00003_V1.class,
                             Q_00003_V2.class);
    }

}
