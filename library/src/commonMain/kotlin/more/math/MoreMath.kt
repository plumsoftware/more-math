package more.math

import more.math.factorial.FactorialParent
import more.math.tetraction.TetractionParent
import kotlin.math.pow

object MoreMath {

    private val factorialParent = FactorialParent()
    private val tetractionParent = TetractionParent()

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
}