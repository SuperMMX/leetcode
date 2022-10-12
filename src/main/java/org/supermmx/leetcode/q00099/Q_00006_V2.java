package org.supermmx.leetcode.q00099;

import java.util.Arrays;

import org.supermmx.leetcode.q00099.Q_00006.Q_00006_Solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q_00006_V2 extends Q_00006_Solution {
    public Q_00006_V2() {
        version = 2;
        name = "Fill rows first";
        description = "Fill rows one by one by calcuating each char's index";
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

        // TODO: optimize

        // numRows * 2 - 2
        int segSize = (numRows - 1) << 1;
        // how many full segments
        int segCount = n / segSize;
        // remainder
        int remainder = n % segSize;

        log.debug("Length: {}, segSize = {}, SegCount = {}, remainder = {}",
                  n, segSize, segCount, remainder);

        int[] extraCount = new int[numRows];
        if (remainder > 0) {
            extraCount[0] = 1;
            extraCount[numRows - 1] = (remainder >= numRows) ? 1 : 0;
            for (int rowIndex = 1; rowIndex < numRows - 1; rowIndex ++ ) {
                extraCount[rowIndex] =
                    (remainder <= rowIndex) ? 0 :
                    (remainder > segSize - rowIndex) ? 2 : 1;
            }
        }

        // calculate the length of each row
        int[] rowCount = new int[numRows];
        rowCount[0] = segCount + extraCount[0];
        for (int rowIndex = 1; rowIndex < numRows - 1; rowIndex ++) {
            rowCount[rowIndex] = (segCount << 1) + extraCount[rowIndex];
        }
        rowCount[numRows - 1] = segCount + extraCount[numRows - 1];

        int[] rowStartIndex = new int[numRows];

        int countSum = 0;
        rowStartIndex[0] = 0;
        for (int rowIndex = 1; rowIndex < numRows; rowIndex ++) {
            countSum += rowCount[rowIndex - 1];
            rowStartIndex[rowIndex] = countSum;
        }

        if (log.isDebugEnabled()) {
            log.debug("Extra Count: {}", Arrays.toString(extraCount));
            log.debug("Row Count: {}", Arrays.toString(rowCount));
            log.debug("Row Start Index: {}", Arrays.toString(rowStartIndex));
        }

        char[] resArray = new char[n];

        int segIndex = 0;
        // index inside the current segment
        int inSegIndex = 0;

        for (int i = 0; i < n; i ++) {
            char c = charArray[i];

            // calculate the row index
            int rowIndex = inSegIndex;
            if (rowIndex >= numRows) {
                rowIndex = segSize - inSegIndex;
            }

            int newIndex = -1;
            if (rowIndex == 0 || rowIndex == numRows - 1) {
                newIndex = segIndex;
            } else {
                newIndex = segIndex << 1;
                if (inSegIndex >= numRows) {
                    newIndex ++;
                }
            }

            newIndex += rowStartIndex[rowIndex];

            log.debug("s[{}] = {}, segIndex = {}, inSegIndex = {}, rowIndex = {}, newIndex = {}",
                      i, c, segIndex, inSegIndex, rowIndex, newIndex);

            resArray[newIndex] = c;

            inSegIndex ++;
            if (inSegIndex == segSize) {
                inSegIndex = 0;
                segIndex ++;
            }
        }

        String res = new String(resArray);

        return res;
    }
}
