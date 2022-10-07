package org.supermmx.leetcode.q00099;

import static org.supermmx.leetcode.common.Tag.*;

import java.util.Arrays;
import java.util.List;

import org.supermmx.leetcode.common.Problem;
import org.supermmx.leetcode.common.Solution;
import org.supermmx.leetcode.common.Problem.Difficulty;

/**
 * No.6 Zigzag Conversion
 */
public interface Q_00006 {
    public abstract String convert(String s, int numRows);

    public abstract class Q_00006_Solution extends Solution implements Q_00006 {
        protected Q_00006_Solution() {
            this.problem = P00006;
        }

        @Override
        public Object solve(Object... args) {
            return convert((String)args[0], (int)args[1]);
        }
    }

    public static final Problem P00006 = Problem.builder()
            .index(6)
            .title("Zigzag Conversion")
            .description("")
            .link("https://leetcode.com/problems/zigzag-conversion/")
            .difficulty(Difficulty.MEDIUM)
            .tags(Arrays.asList(STRING))
            .build();

    /**
     * To get all the versions
     */
    public static List<Class<? extends Solution>> getVersions() {
        return Arrays.asList(Q_00006_V1.class,
                             Q_00006_V2.class);
    }

}
