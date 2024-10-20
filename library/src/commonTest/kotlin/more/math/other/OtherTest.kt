package more.math.other

import more.math.MoreMath
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class OtherTest {
    @Test
    fun testGCD() {
        assertEquals(6, MoreMath.gcd(48, 18))
        assertEquals(1, MoreMath.gcd(13, 17))
        assertEquals(12, MoreMath.gcd(36, 60))
        assertEquals(0, MoreMath.gcd(0, 0))
    }

    @Test
    fun testGCDNegativeInputs() {
        assertFails {
            MoreMath.gcd(-10, 5)
        }
        assertFails {
            MoreMath.gcd(10, -5)
        }
    }
}