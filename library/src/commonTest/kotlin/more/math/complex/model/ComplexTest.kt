package more.math.complex.model

import more.math.complex
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ComplexTest {

    @Test
    fun creationOfComplexNumber() {
        val complex: Complex = complex(3, -4.0)
        assertEquals(3.0, complex.realPart.toDouble())
        assertEquals(-2.0, complex.imaginaryPart)

        val complex2 = complex( -4.0)
        assertEquals(-2.0, complex2.imaginaryPart)
    }

    @Test
    fun sumOfComplexNumbers() {
        val complex1 = complex(2, 9.0)
        val complex2 = complex(1, 16.0)
        val result = complex1 + complex2
        assertEquals(3.0, result.realPart.toDouble())
        assertEquals(7.0, result.imaginaryPart)
    }

    @Test
    fun minusOfComplexNumbers() {
        val complex1 = complex(5, 9.0)
        val complex2 = complex(2, 1.0)
        val result = complex1 - complex2
        assertEquals(3.0, result.realPart.toDouble())
        assertEquals(2.0, result.imaginaryPart)
    }

    @Test
    fun timeOfComplexNumbers() {
        val complex1 = complex(1, 4.0)
        val complex2 = complex(3, 16.0)
        val result = complex1 * complex2
        assertEquals(-5.0, result.realPart.toDouble())
        assertEquals(10.0, result.imaginaryPart)
    }

    @Test
    fun divisionOfComplexNumbers() {
        val complex1 = complex(1, 4.0)
        val complex2 = complex(3, 16.0)
        val result = complex1 / complex2
        assertEquals(0.44, result.realPart.toDouble(), 0.01)
        assertEquals(0.08, result.imaginaryPart, 0.01)
    }

    @Test
    fun testEquals() {
        val complex1 = complex(2, -4.0)
        val complex2 = complex(2, -4.0)
        assertTrue {
            complex1 == complex2
        }
    }

    @Test
    fun testAlgebraicForm() {
        assertEquals("2 - 3.0i", complex(2, -9.0).toAlgebraic())
        assertEquals("2 + 3.0i", complex(2, 9.0).toAlgebraic())
    }

    @Test
    fun testGeometricForm() {
        val complex = complex(3, 16.0)
        assertEquals("5.0 * (cos(0.9272952180016122) + i * sin(0.9272952180016122))", complex.toGeometric())
    }
}