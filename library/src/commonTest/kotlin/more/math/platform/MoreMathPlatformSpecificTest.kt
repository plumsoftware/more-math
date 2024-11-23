package more.math.platform

import more.math.MoreMath
import more.math.platform.model.BigFloat
import more.math.platform.model.BigInt
import kotlin.test.Test
import kotlin.test.assertEquals

class MoreMathPlatformSpecificTest {

    @Test
    fun bigFactorial() {
        val n = 22L
        val result = MoreMath.bigFactorial(n)
        assertEquals(
            expected = BigInt("1124000727777607680000").toString(),
            actual = result.toString()
        )
    }

    @Test
    fun bigTetractionTest() {
        val result = MoreMath.bigTetraction(number = 2.0, other = 3)
        assertEquals(expected = BigFloat("16.0").toString(), actual = result.toString())
    }
}