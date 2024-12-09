package more.math

import more.math.combinatorics.CombinatoricsParent
import more.math.factorial.FactorialParent
import more.math.platform.model.BigFloat
import more.math.platform.model.BigInt
import more.math.native.model.NativeProvider
import more.math.platform.model.BigFloat
import more.math.platform.model.BigInt
import more.math.tetraction.TetractionParent
import kotlin.math.pow

public object MoreMath {

    private val factorialParent = FactorialParent()
    private val tetractionParent = TetractionParent()
    private val combinatoricsParent = CombinatoricsParent()
    private val nativeProvider = NativeProvider()

    //region::Algebra
    public fun factorial(n: Int): Long {
        factorialParent.verifyFactorial(n)
        return nativeProvider.nativeFactorial(number = n)
    }

    public fun factorial(n: Long): Long {
        factorialParent.verifyFactorial(n)
        return if (n == 0L) 1L else n * factorial(n - 1L)
    }

    public fun bigFactorial(n: Long): BigInt {
        factorialParent.verifyPositive(n)
        if (n == 0L || n == 1L) {
            return BigInt(BigInt.ONE.toString())
        }

        val number = BigInt(n.toString())
        val result = number.multiply(bigFactorial(n - 1L))

        return BigInt(result.toString())
    }

    public fun tetraction(number: Double, other: Int): Double {
        tetractionParent.verify(number, other)
        return if (other == 0) {
            1.0
        } else {
            number.pow(tetraction(number, other - 1))
        }
    }

    public fun bigTetraction(number: Double, other: Int): BigFloat {
        tetractionParent.verify(number, other)
        return if (other == 0) {
            BigFloat(1.0.toString())
        } else {
            BigFloat(number.pow(tetraction(number, other - 1)).toString())
        }
    }

    public fun average(vararg numbers: Int): Double {
        return numbers.average()
    }

    public fun standardDeviation(vararg numbers: Double): Double {
        val avg = numbers.average()
        val sumOfSquares = numbers.sumOf { (it - avg) * (it - avg) }
        return kotlin.math.sqrt(sumOfSquares / (numbers.size - 1))
    }

    //Нок
    public fun gcd(a: Int, b: Int): Int {
        require(a >= 0 && b >= 0) { "Both numbers must be non-negative" }
        return if (b == 0) a else gcd(b, a % b)
    }
    //endregion

    //region::Combinatorics
    public fun combinations(n: Int, k: Int): Long {
        combinatoricsParent.verify(n, k)
        return factorial(n) / (factorial(k) * factorial(n - k))
    }

    public fun placements(n: Int, k: Int): Long {
        combinatoricsParent.verify(n, k)
        return factorial(n) / factorial(n - k)
    }

    public fun binomialCoefficient(n: Int, k: Int) : Long {
        combinatoricsParent.verify(n, k)
        return factorial(n) / (factorial(k) * factorial(n - k))
    }
    //endregion
}