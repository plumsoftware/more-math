package more.math.factorial

import more.math.Math
import kotlin.test.Test
import kotlin.test.assertEquals

class FactorialTest {

    @Test
    fun testFactorial() {
        val result: Long = Math.factorial(n = 3)
        assertEquals(expected = 6L, actual = result)
    }
}