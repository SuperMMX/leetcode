package org.supermmx.leetcode.q00099;

import org.supermmx.leetcode.q00099.Q_00005.Q_00005_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00005_V1 extends Q_00005_Solution {
    public Q_00005_V1() {
        version = 1;
        name = "Brute Force";
        description = "Go through each one as the center char or chars and increase the ranges";
        comment = "Standard enumeration solution";
    }

    @Override
    public String longestPalindrome(String s) {
        if (s == null | s.length() == 0) {
            return s;
        }

        int length = s.length();

        // minimum one
        int[] resHolder = { 0, 0, 1 };

        // center char
        int cc = 0;
        while (cc < length) {
            log.debug("==== cc = {}", cc);

            // checking single
            checkRange(s, length, cc, true, resHolder);

            // checking double
            checkRange(s, length, cc, false, resHolder);

            // advance next as the center char
            cc ++;
        }

        String res = s.substring(resHolder[0], resHolder[1] + 1);

        log.debug("==== Input: {}", s);
        log.debug("==== Result: [ {}, {} ], String: {}", resHolder[0], resHolder[1], res);

        return res;
    }

    private void checkRange(String s, int length,
                            int cc, boolean isSingle,
                            int[] resHolder) {
        // single
        int start = cc - 1;
        int end = cc + 1;
        int size = 3;

        // double
        if (!isSingle) {
            start = cc;
            size = 2;
        }

        // extend to both ends
        while (start >= 0 && end < length) {
            // not the same char
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }

            // advance one on both ends
            start --;
            end ++;
            size += 2;
        }

        // either break or stop over the boudary,
        // need to go back one and check the size
        if (size - 2 > resHolder[2]) {
            resHolder[0] = start + 1;
            resHolder[1] = end - 1;
            resHolder[2] = size - 2;
        }

    }
}
