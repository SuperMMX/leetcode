package org.supermmx.leetcode.q00099;

import java.util.Arrays;

import org.supermmx.leetcode.q00099.Q_00003.Q_00003_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00003_V3 extends Q_00003_Solution {
    public Q_00003_V3() {
        version = 3;
        name = "Sliding Window";
        description = String.join("\n",
                                  "|----|: The sliding window containing non-repeating chars",
                                  "c: the duplicated char after the sliding window",
                                  "",
                                  "  start   dup char      end       ",
                                  "----|--------c-----------|c-------",
                                  "--------------|-----------|-------",
                                  "           new start   new end    "
                                  );
        comment = "It is very good to use the char as the index for the array to get the corresponding position inside the sliding window, which is faster than the normal HashMap solution and avoid integer boxing / unboxing.";
    }

    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null | s.length() == 0) {
            return 0;
        }

        int length = s.length();

        // the position of chars of the non-repeating window
        int[] posArray = new int[128];
        Arrays.fill(posArray, -1);

        // the result start
        int resStart = 0;
        // the result end
        int resEnd = 0;
        // the result length
        int res = 1;

        // the start of the sliding window
        int start = 0;
        // the end of the sliding window
        int end = resEnd;

        // position for the first char
        posArray[s.charAt(0)] = 0;

        // moving right to the end of the string
        while (end < length - 1) {
            log.debug("=================");
            // next char
            end ++;
            char nextChar = s.charAt(end);

            // position of the same char in the sliding window
            int charPos = posArray[nextChar];

            log.debug("==== [ {}, {} ], Index: {}, char: {}, Last Index: {}",
                     start, end - 1, end, nextChar, charPos);

            // got a dup inside the sliding window, the current sliding window is ended
            if (charPos >= 0 && charPos >= start) {
                // the last sliding window is larger
                if ((end - start) > res) {
                    resStart = start;
                    resEnd = end - 1;
                    res = end - start;

                    log.debug("==== New Result Window: [ {}, {} ] : {}", resStart, resEnd, res);
                }

                // start a new sliding window
                // starting from the char next to the repeating char position in the sliding window,
                // ending at current char

                start = charPos + 1;
            }

            // update the next char position
            posArray[nextChar] = end;

            log.debug("==== New Window: [ {}, {} ]: {}", start, end, end - start + 1);

            // the sliding window extends one more
        }

        // check the last sliding window
        if (end - start + 1 > res) {
            resStart = start;
            resEnd = end;
            res = end - start + 1;
        }

        log.debug("==== Result: [ {}, {} ]: {}", resStart, resEnd, res);
        return res;
    }
}
