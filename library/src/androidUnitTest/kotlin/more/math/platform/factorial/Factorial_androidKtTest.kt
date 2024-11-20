package more.math.platform.factorial

import more.math.MoreMath

import org.junit.Test
import java.math.BigInteger

class Factorial_androidKtTest {

    @Test
    fun bigFactorial() {
        val n = 22L
        val result = MoreMath.bigFactorial(n)
        kotlin.test.assertEquals(
            expected = BigInteger("1124000727777607680000").toString(),
            actual = result.toString()
        )
    }
}