package more.math.native.model

import more.math.MoreMath
import kotlin.math.pow

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual class NativeProvider actual constructor() {

    actual fun nativeFactorial(number: Int): Long {
        return if (number == 0) 1L else number * nativeFactorial(number - 1)
    }

    actual fun nativeFactorial(number: Long): Long {
        return if (number == 0L) 1L else number * nativeFactorial(number - 1)
    }

    actual fun nativeAverage(vararg numbers: Int): Double {
        return numbers.average()
    }

    actual fun standardDeviation(vararg numbers: Double) : Double {
        val avg = numbers.average()
        val sumOfSquares = numbers.sumOf { (it - avg) * (it - avg) }
        return kotlin.math.sqrt(sumOfSquares / (numbers.size - 1))
    }

    actual fun tetraction(number: Double, other: Int) : Double {
        return if (other == 0) {
            1.0
        } else {
            number.pow(tetraction(number, other - 1))
        }
    }

    actual fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else MoreMath.gcd(b, a % b)
    }
}