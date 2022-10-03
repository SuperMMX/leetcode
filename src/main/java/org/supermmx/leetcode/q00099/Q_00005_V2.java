package org.supermmx.leetcode.q00099;

import java.util.Arrays;

import org.supermmx.leetcode.q00099.Q_00005.Q_00005_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00005_V2 extends Q_00005_Solution {
    public Q_00005_V2() {
        version = 2;
        name = "Dynamic Programming";
        description = "";
        comment = "";
    }

    @Override
    public String longestPalindrome(String s) {
        if (s == null | s.length() == 0) {
            return s;
        }

        char[] array = s.toCharArray();
        int length = array.length;

        // store the result for the last two range sizes
        // whether the string is a palindrome
        boolean[][] palArray = new boolean[2][];
        // ranges with size 1 are all true
        palArray[0] = new boolean[length];
        Arrays.fill(palArray[0], true);

        int resStart = 0;
        int resEnd = 0;
        int resSize = 1;

        for (int size = 2; size <= length; size ++) {
            if (log.isDebugEnabled()) {
                log.debug("Size = {}", size);
                log.debug("Array 1: {}", Arrays.toString(palArray[0]));
                log.debug("Array 2: {}", Arrays.toString(palArray[1]));
            }

            // current count of ranges with the specified size
            int count = length - size + 1;
            boolean[] currentArray = new boolean[count];

            for (int start = 0; start < count; start ++) {
                int end = start + size - 1;

                boolean isPal =
                    // start char is the same as the end char
                    (array[start] == array[end]
                     // either only two chars
                     && ((size == 2)
                         // or the inner string is a palindrome
                         || palArray[0][start + 1]));

                // set the current value
                currentArray[start] = isPal;

                if (isPal && size > resSize) {
                    resStart = start;
                    resEnd = end;
                    resSize = size;
                }
            }

            if (log.isDebugEnabled()) {
                log.debug("Current Array: {}", Arrays.toString(currentArray));
            }

            if (size > 2) {
                palArray[0] = palArray[1];
            }

            palArray[1] = currentArray;
        }

        String res = s.substring(resStart, resEnd + 1);

        return res;
    }
}
