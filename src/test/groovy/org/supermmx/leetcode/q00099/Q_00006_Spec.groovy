package org.supermmx.leetcode.q00099

import org.supermmx.leetcode.common.Solution

import groovy.util.logging.Slf4j

import java.util.List;

import spock.lang.*

@Slf4j
class Q_00006_Spec extends Specification {
    @Shared
    List<Solution> solutions = Q_00006.getVersions()
        //.find { it == Q_00006_V2 }
        .collect { cls -> cls.newInstance() }

    def 'Example 1'() {
        when:
        def res = solution.solve("PAYPALISHIRING", 3)

        then:
        res == "PAHNAPLSIIGYIR"

        where:
        solution << solutions
    }

    def 'Example 2'() {
        when:
        def res = solution.solve("PAYPALISHIRING", 4)

        then:
        res == "PINALSIGYAHRPI"

        where:
        solution << solutions
    }

    def 'Example 3'() {
        when:
        def res = solution.solve("A", 1)

        then:
        res == "A"

        where:
        solution << solutions
    }

    def 'one row'() {
        when:
        def res = solution.solve("abcabc", 1)

        then:
        res == "abcabc"

        where:
        solution << solutions
    }

    def 'two rows'() {
        when:
        def res = solution.solve("abcabc", 2)

        then:
        res == "acbbac"

        where:
        solution << solutions
    }

    def 'equal rows'() {
        when:
        def res = solution.solve("abcabc", 6)

        then:
        res == "abcabc"

        where:
        solution << solutions
    }

    def 'more rows'() {
        when:
        def res = solution.solve("abcabc", 8)

        then:
        res == "abcabc"

        where:
        solution << solutions
    }

    def 'less than one segment'() {
        when:
        def res = solution.solve("abcdefghij", 7)

        then:
        res == "abcdjeifhg"

        where:
        solution << solutions
    }

    def 'random'() {
        given:
        def r = new Random()

        10.times {
            def size = r.nextInt(1001)
            def s = genRandom(r, size)
            def numRows = r.nextInt(1001);
            log.info '==== Input : {}, {}', s, numRows

            when:
            def results = solutions.collectEntries { solution ->
                def startTS = System.currentTimeMillis()
                def res = solution.solve(s, numRows)
                log.info '==== {}: {}ms', solution, (System.currentTimeMillis() - startTS)
                return [ (solution.version): res ]
            }
            log.info '==== Results: {}', results

            then:
            // all the result should be the same
            results.values().unique(false).size() == 1
        }
    }

    def genRandom(Random r, int size) {
        def sb = new StringBuilder()
        size.times {
            sb.append((char)(r.nextInt(52 + 6) + 65))
        }

        //log.info '{}', sb
        return sb.toString()
    }
}
