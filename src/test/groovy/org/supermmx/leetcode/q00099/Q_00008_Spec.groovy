package org.supermmx.leetcode.q00099

import org.supermmx.leetcode.common.Solution

import groovy.util.logging.Slf4j

import java.util.List;

import spock.lang.*

@Slf4j
class Q_00008_Spec extends Specification {
    @Shared
    List<Solution> solutions = Q_00008.getVersions()
        //.find { it == Q_00008_V2 }
        .collect { cls -> cls.newInstance() }

    def 'Example 1'() {
        when:
        def res = solution.solve("42")

        then:
        res == 42

        where:
        solution << solutions
    }

    def 'Example 2'() {
        when:
        def res = solution.solve("   -42")

        then:
        res == -42

        where:
        solution << solutions
    }

    def 'Example 3'() {
        when:
        def res = solution.solve("4193 with words")

        then:
        res == 4193

        where:
        solution << solutions
    }

    def 'blank'() {
        when:
        def res = solution.solve("")

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'leading zeros'() {
        when:
        def res = solution.solve("0032")

        then:
        res == 32

        where:
        solution << solutions
    }

    def '000'() {
        when:
        def res = solution.solve("000")

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'positive zero'() {
        when:
        def res = solution.solve("  +0")

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'negative zero'() {
        when:
        def res = solution.solve("  -0")

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'max'() {
        when:
        def res = solution.solve(String.valueOf(Integer.MAX_VALUE))

        then:
        res == Integer.MAX_VALUE

        where:
        solution << solutions
    }

    def 'over max 1'() {
        when:
        def res = solution.solve("21474836480")

        then:
        res == Integer.MAX_VALUE

        where:
        solution << solutions
    }

    def 'over max 2'() {
        when:
        def res = solution.solve("2147484647")

        then:
        res == Integer.MAX_VALUE

        where:
        solution << solutions
    }

    def 'over max 3'() {
        when:
        def res = solution.solve("3147483647")

        then:
        res == Integer.MAX_VALUE

        where:
        solution << solutions
    }

    def 'min'() {
        when:
        def res = solution.solve(String.valueOf(Integer.MIN_VALUE))

        then:
        res == Integer.MIN_VALUE

        where:
        solution << solutions
    }

    def 'over min 1'() {
        when:
        def res = solution.solve("-21474836490")

        then:
        res == Integer.MIN_VALUE

        where:
        solution << solutions
    }

    def 'over min 2'() {
        when:
        def res = solution.solve("-2147484648")

        then:
        res == Integer.MIN_VALUE

        where:
        solution << solutions
    }

    def 'over min 3'() {
        when:
        def res = solution.solve("-3147483648")

        then:
        res == Integer.MIN_VALUE

        where:
        solution << solutions
    }

    def 'non-digits'() {
        when:
        def res = solution.solve("abc")

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'positive sign'() {
        when:
        def res = solution.solve("+12345")

        then:
        res == 12345

        where:
        solution << solutions
    }

    def 'positive sign with non-digits'() {
        when:
        def res = solution.solve("+abc")

        then:
        res == 0

        where:
        solution << solutions
    }

    def 'negative sign'() {
        when:
        def res = solution.solve("-12345")

        then:
        res == -12345

        where:
        solution << solutions
    }

    def 'negative sign with non-digits'() {
        when:
        def res = solution.solve("-abc")

        then:
        res == 0

        where:
        solution << solutions
    }

}
