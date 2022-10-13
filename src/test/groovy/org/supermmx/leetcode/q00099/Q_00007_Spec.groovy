package org.supermmx.leetcode.q00099

import org.supermmx.leetcode.common.Solution

import groovy.util.logging.Slf4j

import java.util.List;

import spock.lang.*

@Slf4j
class Q_00007_Spec extends Specification {
    @Shared
    List<Solution> solutions = Q_00007.getVersions()
        //.find { it == Q_00007_V2 }
        .collect { cls -> cls.newInstance() }

    def 'Example 1'() {
        when:
        def res = solution.solve(123)

        then:
        res == 321

        where:
        solution << solutions
    }

    def 'Example 2'() {
        when:
        def res = solution.solve(-123)

        then:
        res == -321

        where:
        solution << solutions
    }

    def 'Example 3'() {
        when:
        def res = solution.solve(120)

        then:
        res == 21

        where:
        solution << solutions
    }

    def '0'() {
        when:
        def res = solution.solve(0)

        then:
        res == 0

        where:
        solution << solutions
    }

    def '2500'() {
        when:
        def res = solution.solve(2500)

        then:
        res == 52

        where:
        solution << solutions
    }

    def 'positive out of range 1'() {
        when:
        def res = solution.solve(Integer.MAX_VALUE)

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'positive out of range 2'() {
        when:
        def res = solution.solve(2073847412)

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'positive out of range 3'() {
        when:
        def res = solution.solve(1111111113)

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'positive good 1'() {
        when:
        def res = solution.solve(1111111112)

        then:
        res == 2111111111

        where:
        solution << solutions
    }

    def 'positive good 2'() {
        when:
        def res = solution.solve(2147447412)

        then:
        res == 2147447412

        where:
        solution << solutions
    }

    def 'positive good 3'() {
        when:
        def res = solution.solve(1463847412)

        then:
        res == 2147483641

        where:
        solution << solutions
    }

    def 'negative out of range 1'() {
        when:
        def res = solution.solve(Integer.MIN_VALUE)

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'negative out of range 2'() {
        when:
        def res = solution.solve(-2073847412)

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'negative out of range 3'() {
        when:
        def res = solution.solve(-1111111113)

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'negative good 1'() {
        when:
        def res = solution.solve(-1111111112)

        then:
        res == -2111111111

        where:
        solution << solutions
    }

    def 'negative good 2'() {
        when:
        def res = solution.solve(-2147447412)

        then:
        res == -2147447412

        where:
        solution << solutions
    }

    def 'negagive good 3'() {
        when:
        def res = solution.solve(-1463847412)

        then:
        res == -2147483641

        where:
        solution << solutions
    }
}
