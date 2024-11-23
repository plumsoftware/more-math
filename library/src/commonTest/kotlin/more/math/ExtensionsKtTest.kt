package more.math

import kotlin.test.Test
import kotlin.test.assertTrue

class ExtensionsKtTest {

    @Test
    fun isPositiveOrNegative() {
        assertTrue(2.isPositive)
        assertTrue(2.0.isPositive)
        assertTrue(2.0f.isPositive)
        assertTrue(2L.isPositive)

        assertTrue((-2).isNegative)
        assertTrue((-2.0).isNegative)
        assertTrue((-2.0f).isNegative)
        assertTrue((-2L).isNegative)
    }
}