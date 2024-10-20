package more.math

import more.math.matrix.model.Matrix
import more.math.matrix.model.determinant
import more.math.matrix.model.transpose
import more.math.vector.model.Vector2
import kotlin.test.Test
import kotlin.test.assertEquals

class MoreMathTest {

    @Test
    fun test() {
        val matrix = matrixOf<Int>(
            listOf(1,2),
            listOf(3,4),
        )
        val vector1 = vector2Of(1, 2)
        val vector2 = vector2Of(3, 4)

        assertEquals(expected = -2.0, actual = matrix.determinant())
        assertEquals(expected = 6, MoreMath.factorial(3))
        assertEquals(expected = 2.0, MoreMath.average(1, 2, 3))
        assertEquals(expected = Matrix(listOf(1, 3), listOf(2, 4)), matrix.transpose())
        assertEquals(expected = 16.0, MoreMath.tetraction(2.0, 3))
        assertEquals(expected = Vector2(x = 4, y = 6), actual = (vector1 + vector2))
    }
}