package more.math.tetraction

import more.math.MoreMath
import kotlin.test.Test
import kotlin.test.assertEquals

class TetractionTest {
    @Test
    fun tetractionTest() {
        val result = MoreMath.tetraction(number = 2.0, other = 3)
        assertEquals(expected = 16.0, actual = result)
    }
}