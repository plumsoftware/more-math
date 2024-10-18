package more.math

import more.math.factorial.FactorialParent
import kotlin.math.pow

object MoreMath : FactorialParent() {
    fun factorial(n: Int) : Long {
        verifyFactorial(n)
        return if (n == 0) 1L else n * factorial(n - 1)
    }

    fun factorial(n: Long) : Long {
        verifyFactorial(n)
        return if (n == 0L) 1L else n * factorial(n - 1L)
    }

    fun tetraction(number: Double, other: Int) : Double {
        require(number >= 0 && other >= 0) {
            "Both arguments must be more than zero"
        }
        return if (other == 0) {
            1.0
        } else {
            number.pow(tetraction(number, other - 1))
        }
    }
}