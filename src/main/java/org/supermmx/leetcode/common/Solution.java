package org.supermmx.leetcode.common;

import lombok.Getter;
import lombok.Setter;

/**
 * A solution to a problem
 */
@Getter
@Setter
public abstract class Solution {
    /** The corresponding problem */
    protected Problem problem;

    /** The solution version */
    protected int version;
    /** The solution name */
    protected String name;
    /** The solution description */
    protected String description;
    /** Time complexity */
    protected String time;
    /** Space complexity */
    protected String space;
    /** Some comment */
    protected String comment;

    /**
     * The generic method to solve the problem with the input
     *
     * @param args the input arguments
     *
     * @return the result
     */
    public abstract Object solve(Object... args);

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}
