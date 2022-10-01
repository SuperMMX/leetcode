package org.supermmx.leetcode.q00099

import org.supermmx.leetcode.common.Solution

import groovy.util.logging.Slf4j

import java.util.List;

import spock.lang.*

@Slf4j
class Q_00003_Spec extends Specification {
    @Shared
    List<Solution> solutions = Q_00003.getVersions()
        //.find { it == Q_00003_V3 }
        .collect { cls -> cls.newInstance() }

    def 'Example 1'() {
        when:
        int res = solution.solve("abcabcbb")

        then:
        res == 3

        where:
        solution << solutions
    }

    def 'Example 2'() {
        when:
        int res = solution.solve("bbbbb")

        then:
        res == 1

        where:
        solution << solutions
    }

    def 'Example 3'() {
        when:
        int res = solution.solve("pwwkew")

        then:
        res == 3

        where:
        solution << solutions
    }

    def 'Continously repeating'() {
        when:
        int res = solution.solve("aaabbbccc")

        then:
        res == 2

        where:
        solution << solutions
    }

    def 'Back to back'() {
        when:
        int res = solution.solve("aabbccdd")

        then:
        res == 2

        where:
        solution << solutions
    }

    def 'Interval'() {
        when:
        int res = solution.solve("abacadae")

        then:
        res == 3

        where:
        solution << solutions
    }

    def 'Unique'() {
        when:
        int res = solution.solve("abcdef")

        then:
        res == 6

        where:
        solution << solutions
    }

    def 'full unique'() {
        given:
        def sb = new StringBuilder()
        for (int i = 32; i <= 126; i ++) {
            sb.append((char)i)
        }

        def s = sb.toString()
        100.times {
            sb.append(s)
        }
        s = sb.toString()

        when:
        def results = solutions.collectEntries { solution ->
            def startTS = System.currentTimeMillis()
            def res = solution.solve(s)
            log.info '==== {}: {}ms', solution, (System.currentTimeMillis() - startTS)
            return [ (solution.version): res ]
        }
        log.info '==== results: {}', results

        then:
        // all the result should be the same
        results.values().unique(false).size() == 1
    }

    def 'random'() {
        given:
        def r = new Random()

        10.times {
            def size = r.nextInt(50001)
            def s = genRandom(r, size)

            when:
            def results = solutions.collectEntries { solution ->
                def startTS = System.currentTimeMillis()
                def res = solution.solve(s)
                log.info '==== {}: {}ms', solution, (System.currentTimeMillis() - startTS)
                return [ (solution.version): res ]
            }
            log.info '==== results: {}', results

            then:
            // all the result should be the same
            results.values().unique(false).size() == 1
        }
    }

    def genRandom(Random r, int size) {
        // 32 - 126
        def sb = new StringBuilder()
        size.times {
            sb.append((char)(r.nextInt(94) + 32))
        }

        //log.info '{}', sb
        return sb.toString()
    }
}
