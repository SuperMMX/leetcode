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
    protected String timeO;
    /** Space complexity */
    protected String spaceO;
    /** Time executed in ms in LeetCode */
    protected int execTime;
    /** Time executed percentage */
    protected double execTimePercentage;
    /** Memory used in MB in LeetCode */
    protected double execMemory;
    /** Memory used percentage */
    protected double execMemoryPercentage;
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
