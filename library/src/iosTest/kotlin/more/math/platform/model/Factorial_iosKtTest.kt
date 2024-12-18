package more.math.platform.model

import more.math.MoreMath
import kotlin.test.Test
import kotlin.test.assertEquals

class Factorial_iosKtTest {

    @Test
    fun bigFactorial() {
        val n = 22L
        val result = MoreMath.bigFactorial(n)
        assertEquals(
            expected = BigInt("1124000727777607680000").toString(),
            actual = result.toString()
        )
    }
}