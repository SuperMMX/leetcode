package org.supermmx.leetcode.q00099;

import java.util.HashSet;
import java.util.Set;

import org.supermmx.leetcode.q00099.Q_00003.Q_00003_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00003_V1 extends Q_00003_Solution {
    public Q_00003_V1() {
        version = 1;
        name = "Brute Force";
        description = "Check windows from longest to shortest for repeating chars with a HashSet";
        comment = "Standard enumeration solution";
    }

    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null | s.length() == 0) {
            return 0;
        }

        long startTime = System.currentTimeMillis();

        Set<Character> chars = new HashSet<>();
        int length = s.length();

        for (int i = 0; i < length; i ++) {
            char c = s.charAt(i);
            chars.add(c);
        }

        int uniqueChars = chars.size();
        log.info("==== Unique chars: {}", uniqueChars);

        // only one unique char: the result is 1
        // only two unique char: the result is 2
        // no dups in the whole string: the result is the length
        if (uniqueChars <= 2
            || uniqueChars == length) {
            log.info("==== V1 Result: {}, Running {}ms", uniqueChars, (System.currentTimeMillis() - startTime));
            return uniqueChars;
        }

        boolean found = false;

        // the longest is the unique chars
        int result = uniqueChars;

        int resultStart = -1;
        int resultEnd = -1;

        // the shortest length is 1
        while (result > 2) {
            for (int start = 0; start <= length - result; start ++) {
                int end = start + result - 1;

                boolean hasDup = false;

                chars = new HashSet<>();
                for (int i = start; i <= end; i ++) {
                    char c = s.charAt(i);
                    if (chars.contains(c)) {
                        hasDup = true;
                        break;
                    } else {
                        chars.add(c);
                    }
                }

                if (!hasDup) {
                    //log.info("==== no dup found: start: {}, end: {}", start, end);
                    found = true;
                    resultStart = start;
                    resultEnd = end;
                    break;
                }
            }

            if (found) {
                break;
            }

            result --;
        }

        log.info("==== V1 Result: {}, [ {}, {} ], Running {}ms",
                 result, resultStart, resultEnd, (System.currentTimeMillis() - startTime));

        return result;
    }
}
