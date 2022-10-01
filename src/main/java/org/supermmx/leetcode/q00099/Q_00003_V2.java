package org.supermmx.leetcode.q00099;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.supermmx.leetcode.q00099.Q_00003.Q_00003_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00003_V2 extends Q_00003_Solution {
    public Q_00003_V2() {
        version = 2;
        name = "Non-recursive Dynamic Programming";
        description = String.join("\n",
                                  "# Create windows from minimum two chars",
                                  "# Extends each window to the right",
                                  "# If the next char is a repeating one, add the window to the new windows",
                                  "# Repeat until there are no windows anymore",
                                  "# The result is the last window size"
                                  );
        comment = "Memory usage is high, and performance is worse in some bad cases";
    }

    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null | s.length() == 0) {
            return 0;
        }

        long startTime = System.currentTimeMillis();

        HashSet<Character> chars = new HashSet<>();
        int length = s.length();

        for (int i = 0; i < length; i ++) {
            char c = s.charAt(i);
            chars.add(c);
        }

        int uniqueChars = chars.size();

        // only one unique char: the result is 1
        // only two unique char: the result is 2
        // no dups in the whole string: the result is the length
        if (uniqueChars <= 2
            || uniqueChars == length) {
            log.info("==== V2 Result: {}, Running {}ms", uniqueChars, (System.currentTimeMillis() - startTime));
            return uniqueChars;
        }

        List<Window_V2> windows = new ArrayList<>(length);
        for (int i = 0; i < length - 1; i ++) {
            char c = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (c != c2) {
                Window_V2 win = new Window_V2(c, i);
                win.chars.add(c2);
                win.end = i + 1;
                windows.add(win);
            }
        }
        log.info("==== Initializing {}ms", (System.currentTimeMillis() - startTime));

        // keep one
        Window_V2 window = windows.get(0);

        int windowSize = 2;
        while (windowSize < length
               && windows.size() > 0) {
            windowSize ++;

            // keep one
            window = windows.get(0);

            List<Window_V2> nextWindows = new ArrayList<>();

            for (Window_V2 win: windows) {
                // to the end
                if (win.end + 1 >= length) {
                    continue;
                }

                // next char
                char c = s.charAt(win.end + 1);
                if (!win.chars.contains(c)) {
                    // no dups
                    win.chars.add(c);
                    win.end ++;

                    nextWindows.add(win);
                }
            }

            windows = nextWindows;
        }

        log.info("==== V2 Result: {}, [ {}, {} ], Running {}ms",
                 windowSize - 1, window.start, window.end, (System.currentTimeMillis() - startTime));

        return windowSize - 1;
    }

    public static class Window_V2 {
        public HashSet<Character> chars = new HashSet<>();
        public int start;
        public int end;

        public Window_V2(char c, int start) {
            chars.add(c);
            this.start = start;
            this.end = start;
        }
    }
}
