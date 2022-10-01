package org.supermmx.leetcode.common;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * A problem definition
 */
@Data
@Builder
public class Problem {
    public enum Difficulty {
        EASY, MEDIUM, HARD
    }

    /** The problem index */
    private int index;
    /** The title of the problem */
    private String title;
    /** The short description of the problem */
    private String description;
    /** The official problem link in LeetCode */
    private String link;
    /** The difficulty of the problem */
    private Difficulty difficulty;
    /** The tags of the problem */
    private List<String> tags;
}
