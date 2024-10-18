package more.math.factorial

import more.math.MoreMath
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class FactorialTest {

    @Test
    fun testFactorial() {
        assertEquals(expected = 6L, actual = MoreMath.factorial(n = 3))
        assertEquals(expected = 1L, actual = MoreMath.factorial(n = 0))
        assertEquals(expected = 1L, actual = MoreMath.factorial(n = 1))
    }

    @Test
    fun testFactorialFails() {
        assertFails {
            MoreMath.factorial(n = -3)
        }
    }
}