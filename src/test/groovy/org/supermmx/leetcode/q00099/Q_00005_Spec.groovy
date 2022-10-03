package org.supermmx.leetcode.q00099

import org.supermmx.leetcode.common.Solution

import groovy.util.logging.Slf4j

import java.util.List;

import spock.lang.*

@Slf4j
class Q_00005_Spec extends Specification {
    @Shared
    List<Solution> solutions = Q_00005.getVersions()
        //.find { it == Q_00005_V2 }
        .collect { cls -> cls.newInstance() }

    def 'Example 1'() {
        when:
        def res = solution.solve("babad")

        then:
        res == "bab"

        where:
        solution << solutions
    }

    def 'Example 2'() {
        when:
        def res = solution.solve("cbbd")

        then:
        res == "bb"

        where:
        solution << solutions
    }

    def 'single center in the latter half'() {
        when:
        def res = solution.solve("caba")

        then:
        res == "aba"

        where:
        solution << solutions
    }

    def 'double center in the latter half'() {
        when:
        def res = solution.solve("cdabba")

        then:
        res == "abba"

        where:
        solution << solutions
    }

    def 'one'() {
        when:
        def res = solution.solve("a")

        then:
        res == "a"

        where:
        solution << solutions
    }

    def 'two'() {
        when:
        def res = solution.solve("aa")

        then:
        res == "aa"

        where:
        solution << solutions
    }

    def 'same single'() {
        when:
        def res = solution.solve("aaaaa")

        then:
        res == "aaaaa"

        where:
        solution << solutions
    }

    def 'same double'() {
        when:
        def res = solution.solve("aaaaaa")

        then:
        res == "aaaaaa"

        where:
        solution << solutions
    }

    def 'random'() {
        given:
        def r = new Random()

        10.times {
            def size = r.nextInt(1001)
            def s = genRandom(r, size)
            log.info '==== Input  : {}', s

            when:
            def results = solutions.collectEntries { solution ->
                def startTS = System.currentTimeMillis()
                def res = solution.solve(s)
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
        // 48-57 65-90
        def sb = new StringBuilder()
        size.times {
            sb.append((char)(r.nextInt(10) + 65))
        }

        //log.info '{}', sb
        return sb.toString()
    }
}
