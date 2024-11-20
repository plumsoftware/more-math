package more.math.platform

import more.math.MoreMath
import more.math.platform.factorial.BigNum
import kotlin.test.Test
import kotlin.test.assertEquals

class MoreMathPlatformSpecificTest {

    @Test
    fun bigFactorial() {
        val n = 22L
        val result = MoreMath.bigFactorial(n)
        assertEquals(expected = BigNum("1124000727777607680000").toString(), actual = result.toString())
    }
}