package more.math.combinatorics

import more.math.MoreMath
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class CombinatoricsTest {

    @Test
    fun testCombinations() {
        assertEquals(1, MoreMath.combinations(0, 0))
        assertEquals(1, MoreMath.combinations(5, 0))
        assertEquals(10, MoreMath.combinations(5, 2))
        assertEquals(1, MoreMath.combinations(5, 5))
        assertEquals(1, MoreMath.combinations(5, 5))
    }

    @Test
    fun testPermutations() {
        assertEquals(1, MoreMath.permutations(0, 0))
        assertEquals(5, MoreMath.permutations(5, 1))
        assertEquals(20, MoreMath.permutations(5, 2))
        assertEquals(120, MoreMath.permutations(5, 5))
    }

    @Test
    fun testBinomialCoefficient() {
        assertEquals(1, MoreMath.binomialCoefficient(0, 0))
        assertEquals(1, MoreMath.binomialCoefficient(5, 0))
        assertEquals(10, MoreMath.binomialCoefficient(5, 2))
        assertEquals(1, MoreMath.binomialCoefficient(5, 5))
    }

    @Test
    fun testInvalidInputs() {
        assertFails {
            MoreMath.combinations(5, 6)
        }
        assertFails {
            MoreMath.permutations(5, 6)
        }
        assertFails {
            MoreMath.binomialCoefficient(5, 6)
        }
    }
}