package math.fibonacci


import spock.lang.Specification

class FibonacciTest extends Specification {

    private final def fibonacci = new Fibonacci()

    def "given negative number exception is thrown"() {
        when:
        fibonacci.iterative(-1)

        then:
        thrown(IllegalArgumentException)
    }

    def "given n element of fibonacci sequence should be correct"() {
        expect:
        fibonacci.iterative(n) == result

        where:
        n  | result
        0  | 0
        1  | 1
        2  | 1
        3  | 2
        4  | 3
        5  | 5
        6  | 8
        7  | 13
        8  | 21
        9  | 34
        10 | 55
        11 | 89
        12 | 144
        13 | 233
        14 | 377
        15 | 610
        16 | 987
        17 | 1597
    }

}
