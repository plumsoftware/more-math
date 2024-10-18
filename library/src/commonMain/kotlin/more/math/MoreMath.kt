package more.math

import more.math.combinatorics.CombinatoricsParent
import more.math.factorial.FactorialParent
import more.math.tetraction.TetractionParent
import kotlin.math.pow

object MoreMath {

    private val factorialParent = FactorialParent()
    private val tetractionParent = TetractionParent()
    private val combinatoricsParent = CombinatoricsParent()

    fun factorial(n: Int): Long {
        factorialParent.verifyFactorial(n)
        return if (n == 0) 1L else n * factorial(n - 1)
    }

    fun factorial(n: Long): Long {
        factorialParent.verifyFactorial(n)
        return if (n == 0L) 1L else n * factorial(n - 1L)
    }

    fun tetraction(number: Double, other: Int): Double {
        tetractionParent.verify(number, other)
        return if (other == 0) {
            1.0
        } else {
            number.pow(tetraction(number, other - 1))
        }
    }

    fun average(vararg numbers: Int) : Double{
        return numbers.average()
    }

    fun combinations(n: Int, k: Int): Long {
        combinatoricsParent.verify(n, k)
        return factorial(n) / (factorial(k) * factorial(n - k))
    }

    fun permutations(n: Int, k: Int): Long {
        combinatoricsParent.verify(n, k)
        return factorial(n) / factorial(n - k)
    }

    fun binomialCoefficient(n: Int, k: Int) : Long {
        combinatoricsParent.verify(n, k)
        return factorial(n) / (factorial(k) * factorial(n - k))
    }

    fun standardDeviation(vararg numbers: Double): Double {
        val avg = numbers.average()
        val sumOfSquares = numbers.sumOf { (it - avg) * (it - avg) }
        return kotlin.math.sqrt(sumOfSquares / (numbers.size - 1))
    }
}