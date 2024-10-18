package more.math.matrix.model

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MatrixExtensionKtTest {

    private lateinit var matrix: Matrix<Number>

    @BeforeTest
    fun setUp() {
        matrix = matrixOf(
            listOf(1, 2.5, 3),
            listOf(4.0, 5, 6)
        )
    }

    @Test
    fun testMatrixFunctions() {
        val number: Number = matrix[0, 0]
        assertEquals(expected = 1, actual = number)
    }

    @Test
    fun sumMatrix() {
        val matrix1 = matrixOf<Int>(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        )

        val matrix2 = Matrix(
            listOf(7, 8, 9),
            listOf(10, 11, 12)
        )

        val sumMatrix = matrix1 + matrix2

        val expectedMatrix = matrixOf<Int>(
            listOf(8, 10, 12),
            listOf(14, 16, 18)
        )

        assertEquals(expected = expectedMatrix, actual = sumMatrix)
    }

    @Test
    fun minusTest() {
        val matrix1 = matrixOf<Int>(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        )

        val matrix2 = Matrix(
            listOf(7, 8, 9),
            listOf(10, 11, 12)
        )

        val minusMatrix = matrix1 - matrix2

        val expectedMatrix = matrixOf<Int>(
            listOf(-6, -6, -6),
            listOf(-6, -6, -6)
        )

        assertEquals(expected = expectedMatrix, actual = minusMatrix)
    }

    @Test
    fun timesTest() {
        val matrix1 = matrixOf<Double>(
            listOf(1.0, 2.0, 3.0),
            listOf(4.0, 5.0, 6.0)
        )

        val matrix2 = Matrix(
            listOf(7.0, 8.0),
            listOf(9.0, 10.0),
            listOf(11.0, 12.0)
        )

        val timesMatrix = matrix1 * matrix2

        val expectedMatrix = matrixOf<Double>(
            listOf(58.0, 64.0),
            listOf(139.0, 154.0)
        )

        assertEquals(expected = expectedMatrix, actual = timesMatrix)
    }
}