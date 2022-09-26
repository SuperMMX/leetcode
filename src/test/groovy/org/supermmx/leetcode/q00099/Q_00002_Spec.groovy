package org.supermmx.leetcode.q00099

import spock.lang.*

import org.supermmx.leetcode.q00099.Q_00002.ListNode

class Q_00002_Spec extends Specification {
    @Shared
    Q_00002 solution = new Q_00002()

    def 'Example 1'() {
        given:
        ListNode l1 = gen(2, 4, 3)
        ListNode l2 = gen(5, 6, 4)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(7, 0, 8)
    }

    def 'Example 2'() {
        given:
        ListNode l1 = gen(0)
        ListNode l2 = gen(0)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(0)
    }

    def 'Example 3'() {
        given:
        ListNode l1 = gen(9, 9, 9, 9, 9, 9, 9)
        ListNode l2 = gen(9, 9, 9, 9)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(8, 9, 9, 9, 0, 0, 0, 1)
    }

    def 'both null'() {
        given:
        ListNode l1 = gen()
        ListNode l2 = gen()

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == null
    }

    def 'null l1'() {
        given:
        ListNode l1 = gen()
        ListNode l2 = gen(1, 2, 3)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == l2
    }

    def 'null l2'() {
        given:
        ListNode l1 = gen(4, 5, 6)
        ListNode l2 = gen()

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == l1
    }

    def 'l1 is shorter'() {
    }

    def 'l2 is shorter'() {
    }

    def 'carry in the beginning'() {
    }

    def 'carry in the middle'() {
    }

    def 'carry in the end'() {
    }

    def 'consecutive carrying'() {
    }

    ListNode genRandom(int size) {
        if (size <= 0) {
            return null
        }

        return null
    }

    ListNode gen(int... values) {
        if (values == null || values.length == 0) {
            return null
        }

        def header = null
        def last = null
        for (int value: values) {
            def node = new ListNode(value)
            if (header == null) {
                header = node
            } else {
                last.next = node
            }
            last = node
        }

        return header
    }
}
