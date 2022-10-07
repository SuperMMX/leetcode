package org.supermmx.leetcode.q00099;

import java.util.Arrays;

import org.supermmx.leetcode.q00099.Q_00006.Q_00006_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00006_V1 extends Q_00006_Solution {
    public Q_00006_V1() {
        version = 1;
        name = "Fill rows in Zigzag order";
        description = "Create array of chars for each row, fill each char to rows by zigzag order";
        comment = "";
    }

    @Override
    public String convert(String s, int numRows) {
        if (s == null
            || s.length() == 0
            || numRows <= 1
            || numRows >= s.length()) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int n = charArray.length;

        // numRows * 2 - 2
        int segSize = (numRows - 1) << 1;
        // how many full segments
        int segCount = n / segSize;

        log.debug("Length: {}, segSize = {}, SegCount = {}", n, segSize, segCount);

        // result array in rows
        char[][] resArray = new char[numRows][];
        int[] rowCharCount = new int[numRows];

        // calculate the maximum size of each row
        resArray[0] = new char[segCount + 1];
        resArray[numRows - 1] = new char[segCount + 1];

        for (int rowIndex = 1; rowIndex < numRows - 1; rowIndex ++) {
            resArray[rowIndex] = new char[(segCount + 1) << 1];
        }

        // index inside the current segment
        int inSegIndex = 0;

        for (int charIndex = 0; charIndex < n; charIndex ++) {
            char c = charArray[charIndex];

            // calculate the row index
            int rowIndex = inSegIndex;
            if (rowIndex >= numRows) {
                rowIndex = segSize - inSegIndex;
            }

            int inRowCount = rowCharCount[rowIndex];

            log.debug("Char Index: {}, Char: {}, inSegIndex = {}, rowIndex = {}, InRowCount: {}",
                      charIndex, c, inSegIndex, rowIndex, inRowCount);

            resArray[rowIndex][inRowCount] = c;
            rowCharCount[rowIndex] = inRowCount + 1;

            inSegIndex ++;
            if (inSegIndex == segSize) {
                inSegIndex = 0;
            }
        }

        // combine the result
        char[] singleArray = new char[n];
        int index = 0;
        for (int rowIndex = 0; rowIndex < numRows; rowIndex ++) {
            if (log.isDebugEnabled()) {
                log.debug("resArray[{}] = {}", rowIndex, Arrays.toString(resArray[rowIndex]));
            }

            int count = rowCharCount[rowIndex];
            System.arraycopy(resArray[rowIndex], 0, singleArray, index, count);
            index += count;
        }

        String res = new String(singleArray);
        return res;
    }
}
