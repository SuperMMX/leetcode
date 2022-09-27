package org.supermmx.leetcode.q00099

import groovy.util.logging.Slf4j

import spock.lang.*

import org.supermmx.leetcode.q00099.Q_00002.ListNode

@Slf4j
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
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'Example 2'() {
        given:
        ListNode l1 = gen(0)
        ListNode l2 = gen(0)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(0)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'Example 3'() {
        given:
        ListNode l1 = gen(9, 9, 9, 9, 9, 9, 9)
        ListNode l2 = gen(9, 9, 9, 9)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(8, 9, 9, 9, 0, 0, 0, 1)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'both null'() {
        given:
        ListNode l1 = gen()
        ListNode l2 = gen()

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == null
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'null l1'() {
        given:
        ListNode l1 = gen()
        ListNode l2 = gen(1, 2, 3)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == l2
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'null l2'() {
        given:
        ListNode l1 = gen(4, 5, 6)
        ListNode l2 = gen()

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == l1
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'l1 is shorter'() {
        given:
        ListNode l1 = gen(1)
        ListNode l2 = gen(1, 2, 3)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(2, 2, 3)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'l2 is shorter'() {
        given:
        ListNode l1 = gen(7, 8, 9)
        ListNode l2 = gen(8, 7)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(5, 6, 0, 1)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'carry in the beginning'() {
        given:
        ListNode l1 = gen(7, 0, 1)
        ListNode l2 = gen(3)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(0, 1, 1)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'carry in the middle'() {
        given:
        ListNode l1 = gen(5, 5, 5)
        ListNode l2 = gen(1, 8)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(6, 3, 6)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'carry in the end'() {
        given:
        ListNode l1 = gen(5, 3, 5)
        ListNode l2 = gen(1, 5, 8)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(6, 8, 3, 1)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'consecutive carrying'() {
        given:
        ListNode l1 = gen(5, 6, 7, 8)
        ListNode l2 = gen(8, 7, 6, 5)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)

        then:
        res == gen(3, 4, 4, 4, 1)
        toNumber(res) == toNumber(l1) + toNumber(l2)
    }

    def 'random'() {
        given:
        ListNode l1 = genRandom()
        BigInteger v1 = toNumber(l1)

        ListNode l2 = genRandom()
        BigInteger v2 = toNumber(l2)

        when:
        ListNode res = solution.addTwoNumbers(l1, l2)
        BigInteger vRes = toNumber(res)

        then:
        vRes == v1 + v2
    }

    ListNode genRandom() {
        def r = new Random()
        // 0-100
        def size = r.nextInt(101)

        def header = null
        def prev = null

        size.times {
            def node = new ListNode()
            node.val = r.nextInt(10)
            if (prev == null) {
                header = node
                prev = node
            }

            prev.next = node
            prev = node
        }

        return header
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

    BigInteger toNumber(ListNode l) {
        BigInteger r = 0
        BigInteger scale = 1

        def p = l
        while (p != null) {
            r += scale * p.val
            scale *= 10

            p = p.next
        }

        return r
    }
}
