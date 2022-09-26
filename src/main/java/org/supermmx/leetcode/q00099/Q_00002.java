package org.supermmx.leetcode.q00099;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * No.2 Add Two Numbers: https://leetcode.com/problems/add-two-numbers/
 *
 * @difficulty medium
 * @tags linked-list, math, recursion
 */
@Slf4j
public class Q_00002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        log.debug("==== L1: {}", l1);
        log.debug("==== L2: {}", l2);

        if (l1 == null) {
            log.debug("==== Result: {}", l2);
            return l2;
        }

        if (l2 == null) {
            log.debug("==== Result: {}", l1);
            return l1;
        }

        // result header to return
        ListNode rh = null;
        // previous node to link the next one
        ListNode prev = null;

        // l1 pointer
        ListNode l1p = l1;
        // l2 pointer
        ListNode l2p = l2;

        int carry = 0;

        // loop when there are numbers to add, including the carry
        while (l1p != null || l2p != null || carry != 0) {
            // get the values for l1 and l2
            int v1 = 0;
            if (l1p != null) {
                v1 = l1p.val;
            }

            int v2 = 0;
            if (l2p != null) {
                v2 = l2p.val;
            }

            // calculate
            int value = v1 + v2 + carry;
            if (value >= 10) {
                carry = 1;
                value -= 10;
            } else {
                carry = 0;
            }

            // construct the current result node
            ListNode node = new ListNode(value);
            if (prev == null) {
                rh = node;
            } else {
                prev.next = node;
            }

            // advance one step
            if (l1p != null) {
                l1p = l1p.next;
            }
            if (l2p != null) {
                l2p = l2p.next;
            }

            prev = node;
        }

        log.debug("==== Result: {}", rh);
        return rh;
    }

    @EqualsAndHashCode
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            List<Integer> list = new ArrayList<>();
            ListNode node = this;
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }

            return list.toString();
        }
    }
}
