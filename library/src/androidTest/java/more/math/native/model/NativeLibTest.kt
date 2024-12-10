package more.math.native.model

import androidx.test.ext.junit.runners.AndroidJUnit4
import more.math.MoreMath
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class NativeLibTest {

    @Test
    fun nativeFactorial() {
        val actual = MoreMath.factorial(n = 3)
        val expected = 6L
        assertEquals(expected, actual)

        val actual1 = MoreMath.factorial(n = 3L)
        val expected1 = 6L
        assertEquals(expected1, actual1)
    }

    @Test
    fun average() {
        val exp: Double = 2.0
        val act: Double = MoreMath.average(1, 2, 3)
        assertEquals(exp.toString(), act.toString())
    }

    @Test
    fun tetraction() {
        val result = MoreMath.tetraction(number = 2.0, other = 3)
        assertEquals(16.0.toString(), result.toString())
    }

    @Test
    fun stdDev() {
        val exp: Double = 1.0
        val act: Double = MoreMath.standardDeviation(1.0, 2.0, 3.0)
        assertEquals(exp.toString(), act.toString())
    }

    @Test
    fun gcd() {
        val exp: Int = 5
        val act: Int = MoreMath.gcd(10, 15)
        assertEquals(exp, act)
    }
}