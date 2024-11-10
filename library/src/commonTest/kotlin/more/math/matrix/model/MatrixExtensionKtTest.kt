package more.math.matrix.model

import more.math.complex.model.Complex
import more.math.matrixOf
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

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

    @Test
    fun squareDeterminant() {
        val matrix = matrixOf<Double>(
            listOf(1.0, 2.0),
            listOf(3.0, 4.0)
        )

        val determinant = matrix.determinant()

        assertEquals(expected = -2.0, actual = determinant)
    }

    @Test
    fun squareBigDeterminant() {
        val matrix = matrixOf<Double>(
            listOf(1.0, 2.0, 3.0, 4.0),
            listOf(5.0, 6.0, 7.0, 8.0),
            listOf(9.0, 10.0, 11.0, 12.0),
            listOf(13.0, 14.0, 15.0, 16.0),
        )

        val determinant = matrix.determinant()

        assertEquals(expected = 0.0, actual = determinant)
    }

    @Test
    fun transposeTest() {
        val matrix1 = matrixOf<Int>(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        ).transpose()

        val expected = matrixOf<Int>(
            listOf(1, 4),
            listOf(2, 5),
            listOf(3, 6)
        )

        assertEquals(expected = expected, actual = matrix1)
    }

    @Test
    fun testFails() {
        assertFails {
            matrix[99, 1]
        }
        assertFails {
            matrix[1, 99]
        }
        assertFails {
            val matrix1 = matrixOf<Int>(
                listOf(1, 2, 3),
                listOf(4, 5, 6)
            )
            val matrix2 = matrixOf<Int>(
                listOf(1, 4),
                listOf(2, 5),
                listOf(3, 6)
            )
            matrix1 + matrix2
        }
        assertFails {
            val matrix1 = matrixOf<Int>(
                listOf(1, 2, 3),
                listOf(4, 5, 6)
            )
            val matrix2 = matrixOf<Int>(
                listOf(1, 4),
                listOf(2, 5),
                listOf(3, 6)
            )
            matrix1 - matrix2
        }

        assertFails {
            val matrix1 = matrixOf<Int>(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6),
                listOf(7, 8)
            )
            val matrix2 = matrixOf<Int>(
                listOf(1, 4),
                listOf(2, 5),
                listOf(3, 6)
            )
            matrix1 * matrix2
        }
        assertFails {
            matrix.determinant()
        }
    }

    @Test
    fun timesByNumber() {
        val matrixInt = Matrix(
            listOf(1, 2),
            listOf(3, 4)
        )
        val matrixDouble = Matrix(
            listOf(1.0, 2.0),
            listOf(3.0, 4.0)
        )

        val resMatrix1 = Matrix(
            listOf(2, 4),
            listOf(6, 8)
        )
        val resMatrix2 = Matrix(
            listOf(2.0, 4.0),
            listOf(6.0, 8.0)
        )

        assertEquals(expected = matrixInt.times(2), actual = resMatrix1)
        assertEquals(expected = matrixDouble.times(2.0), actual = resMatrix2)
    }

    @Test
    fun columnTest() {
        val matrixInt = Matrix(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )
        assertEquals(listOf(1, 4, 7), matrixInt.column(0))
        assertEquals(listOf(2, 5, 8), matrixInt.column(1))
        assertEquals(listOf(3, 6, 9), matrixInt.column(2))
        assertFails {
            matrixInt.column(4)
            matrixInt.column(-4)
        }
    }

    @Test
    fun testPowMatrix() {
        val matrixDouble = Matrix(
            listOf(1.0, 2.0),
            listOf(3.0, 4.0)
        )
        val matrixDoubleRes = Matrix(
            listOf(7.0, 10.0),
            listOf(15.0, 22.0)
        )

        assertEquals(expected = matrixDoubleRes, actual = matrixDouble.pow(2))
    }

    @Test
    fun minItemInMatrix() {
        val matrix1 = matrixOf<Int>(
            listOf(1, 2),
            listOf(3, 4),
            listOf(-1, -2),
        )

        val min1 = matrix1.minInMatrix()
        assertEquals(expected = -2, actual = min1)

        val matrix2 = matrixOf<Float>(
            listOf(1f, 2f),
            listOf(3f, 4f),
            listOf(-1f, -2f),
        )

        val min2 = matrix2.minInMatrix()
        assertEquals(expected = -2f, actual = min2)

        val matrix3 = matrixOf<Long>(
            listOf(1L, 2L),
            listOf(3L, 4L),
            listOf(-1L, -2L),
        )

        val min3 = matrix3.minInMatrix()
        assertEquals(expected = -2L, actual = min3)

        val matrix4 = matrixOf<Double>(
            listOf(1.0, 2.0),
            listOf(3.0, 4.0),
            listOf(-1.0, -2.0),
        )

        val min4 = matrix4.minInMatrix()
        assertEquals(expected = -2.0, actual = min4)
    }

    @Test
    fun strMatrix() {
        val matrix = matrixOf<String>(
            listOf("a", "b"),
            listOf("c", "d")
        )
        assertEquals(expected = "a", actual = matrix[0, 0])

        val matrix2 = matrixOf(
            listOf(Complex(realPart = 1, imaginaryPart = -16.0), Complex(realPart = 2, imaginaryPart = -16.0)),
            listOf(Complex(realPart = 3, imaginaryPart = -16.0), Complex(realPart = 4, imaginaryPart = -16.0))
        )
        assertEquals(expected = Complex(realPart = 1, imaginaryPart = -16.0), actual = matrix2[0, 0])

        assertFails {
            val sum = matrix + matrix
            val sum2 = matrix2 + matrix2
        }
    }
}