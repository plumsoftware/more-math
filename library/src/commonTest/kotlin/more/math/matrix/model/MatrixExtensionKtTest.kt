package more.math.matrix.model

import more.math.complex
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
            mutableListOf(1, 2.5, 3),
            mutableListOf(4.0, 5, 6)
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
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6)
        )

        val matrix2 = Matrix(
            mutableListOf(7, 8, 9),
            mutableListOf(10, 11, 12)
        )

        val sumMatrix = matrix1 + matrix2

        val expectedMatrix = matrixOf<Int>(
            mutableListOf(8, 10, 12),
            mutableListOf(14, 16, 18)
        )

        assertEquals(expected = expectedMatrix, actual = sumMatrix)
    }

    @Test
    fun minusTest() {
        val matrix1 = matrixOf<Int>(
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6)
        )

        val matrix2 = Matrix(
            mutableListOf(7, 8, 9),
            mutableListOf(10, 11, 12)
        )

        val minusMatrix = matrix1 - matrix2

        val expectedMatrix = matrixOf<Int>(
            mutableListOf(-6, -6, -6),
            mutableListOf(-6, -6, -6)
        )

        assertEquals(expected = expectedMatrix, actual = minusMatrix)
    }

    @Test
    fun timesTest() {
        val matrix1 = matrixOf<Double>(
            mutableListOf(1.0, 2.0, 3.0),
            mutableListOf(4.0, 5.0, 6.0)
        )

        val matrix2 = Matrix(
            mutableListOf(7.0, 8.0),
            mutableListOf(9.0, 10.0),
            mutableListOf(11.0, 12.0)
        )

        val timesMatrix = matrix1 * matrix2

        val expectedMatrix = matrixOf<Double>(
            mutableListOf(58.0, 64.0),
            mutableListOf(139.0, 154.0)
        )

        assertEquals(expected = expectedMatrix, actual = timesMatrix)
    }

    @Test
    fun squareDeterminant() {
        val matrix = matrixOf<Double>(
            mutableListOf(1.0, 2.0),
            mutableListOf(3.0, 4.0)
        )

        val determinant = matrix.determinant()

        assertEquals(expected = -2.0, actual = determinant)
    }

    @Test
    fun squareBigDeterminant() {
        val matrix = matrixOf<Double>(
            mutableListOf(1.0, 2.0, 3.0, 4.0),
            mutableListOf(5.0, 6.0, 7.0, 8.0),
            mutableListOf(9.0, 10.0, 11.0, 12.0),
            mutableListOf(13.0, 14.0, 15.0, 16.0),
        )

        val determinant = matrix.determinant()

        assertEquals(expected = 0.0, actual = determinant)
    }

    @Test
    fun transposeTest() {
        val matrix1 = matrixOf<Int>(
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6)
        ).transpose()

        val expected = matrixOf<Int>(
            mutableListOf(1, 4),
            mutableListOf(2, 5),
            mutableListOf(3, 6)
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
                mutableListOf(1, 2, 3),
                mutableListOf(4, 5, 6)
            )
            val matrix2 = matrixOf<Int>(
                mutableListOf(1, 4),
                mutableListOf(2, 5),
                mutableListOf(3, 6)
            )
            matrix1 + matrix2
        }
        assertFails {
            val matrix1 = matrixOf<Int>(
                mutableListOf(1, 2, 3),
                mutableListOf(4, 5, 6)
            )
            val matrix2 = matrixOf<Int>(
                mutableListOf(1, 4),
                mutableListOf(2, 5),
                mutableListOf(3, 6)
            )
            matrix1 - matrix2
        }

        assertFails {
            val matrix1 = matrixOf<Int>(
                mutableListOf(1, 2),
                mutableListOf(3, 4),
                mutableListOf(5, 6),
                mutableListOf(7, 8)
            )
            val matrix2 = matrixOf<Int>(
                mutableListOf(1, 4),
                mutableListOf(2, 5),
                mutableListOf(3, 6)
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
            mutableListOf(1, 2),
            mutableListOf(3, 4)
        )
        val matrixDouble = Matrix(
            mutableListOf(1.0, 2.0),
            mutableListOf(3.0, 4.0)
        )

        val resMatrix1 = Matrix(
            mutableListOf(2, 4),
            mutableListOf(6, 8)
        )
        val resMatrix2 = Matrix(
            mutableListOf(2.0, 4.0),
            mutableListOf(6.0, 8.0)
        )

        assertEquals(expected = matrixInt.times(2), actual = resMatrix1)
        assertEquals(expected = matrixDouble.times(2.0), actual = resMatrix2)
    }

    @Test
    fun columnTest() {
        val matrixInt = Matrix(
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6),
            mutableListOf(7, 8, 9)
        )
        assertEquals(mutableListOf(1, 4, 7), matrixInt.column(0))
        assertEquals(mutableListOf(2, 5, 8), matrixInt.column(1))
        assertEquals(mutableListOf(3, 6, 9), matrixInt.column(2))
        assertFails {
            matrixInt.column(4)
            matrixInt.column(-4)
        }
    }

    @Test
    fun testPowMatrix() {
        val matrixDouble = Matrix(
            mutableListOf(1.0, 2.0),
            mutableListOf(3.0, 4.0)
        )
        val matrixDoubleRes = Matrix(
            mutableListOf(7.0, 10.0),
            mutableListOf(15.0, 22.0)
        )

        assertEquals(expected = matrixDoubleRes, actual = matrixDouble.pow(2))
    }

    @Test
    fun minItemInMatrix() {
        val matrix1 = matrixOf<Int>(
            mutableListOf(1, 2),
            mutableListOf(3, 4),
            mutableListOf(-1, -2),
        )

        val min1 = matrix1.minInMatrix()
        assertEquals(expected = -2, actual = min1)

        val matrix2 = matrixOf<Float>(
            mutableListOf(1f, 2f),
            mutableListOf(3f, 4f),
            mutableListOf(-1f, -2f),
        )

        val min2 = matrix2.minInMatrix()
        assertEquals(expected = -2f, actual = min2)

        val matrix3 = matrixOf<Long>(
            mutableListOf(1L, 2L),
            mutableListOf(3L, 4L),
            mutableListOf(-1L, -2L),
        )

        val min3 = matrix3.minInMatrix()
        assertEquals(expected = -2L, actual = min3)

        val matrix4 = matrixOf<Double>(
            mutableListOf(1.0, 2.0),
            mutableListOf(3.0, 4.0),
            mutableListOf(-1.0, -2.0),
        )

        val min4 = matrix4.minInMatrix()
        assertEquals(expected = -2.0, actual = min4)

        val matrix5 = matrixOf<Complex>(
            mutableListOf(complex(3, -16.0), complex(3, -4.0)),
            mutableListOf(complex(3, 25.0), complex(3, -36.0)),
            mutableListOf(complex(3, -49.0), complex(3, 36.0)),
        )

        assertEquals(expected = -7.0, actual = matrix5.minInMatrixBy { it.imaginaryPart })
    }

    @Test
    fun maxItemInMatrix() {
        val matrix5 = matrixOf<Complex>(
            mutableListOf(complex(3, -16.0), complex(3, -4.0)),
            mutableListOf(complex(3, 25.0), complex(3, -36.0)),
            mutableListOf(complex(3, -49.0), complex(3, 36.0)),
        )
        assertEquals(expected = 6.0, actual = matrix5.maxInMatrixBy { it.imaginaryPart })
    }

    @Test
    fun strMatrix() {
        val matrix = matrixOf<String>(
            mutableListOf("a", "b"),
            mutableListOf("c", "d")
        )
        assertEquals(expected = "a", actual = matrix[0, 0])

        val matrix2 = matrixOf(
            mutableListOf(
                Complex(realPart = 1, imaginaryPart = -16.0),
                Complex(realPart = 2, imaginaryPart = -16.0)
            ),
            mutableListOf(
                Complex(realPart = 3, imaginaryPart = -16.0),
                Complex(realPart = 4, imaginaryPart = -16.0)
            )
        )
        assertEquals(
            expected = Complex(realPart = 1, imaginaryPart = -16.0),
            actual = matrix2[0, 0]
        )

        assertFails {
            val sum = matrix + matrix
            val sum2 = matrix2 + matrix2
        }
    }

    @Test
    fun set() {
        val matrix1 = matrixOf<Int>(
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6)
        )
        val matrix2 = matrixOf<Int>(
            mutableListOf(1, 2, 3),
            mutableListOf(4, -1, 6)
        )
        matrix1[1, 1] = -1
        assertEquals(matrix1, matrix2)
    }

    @Test
    fun matrixSize() {
        val matrix = matrixOf<Int>(
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6)
        )

        val size = matrix.size

        assertEquals(MatrixSize(2, 3), size)
    }

    @Test
    fun verifyContent() {
        assertFails {
            matrixOf(
                mutableListOf(1, 2, 3),
                mutableListOf(4, 5, 6),
                mutableListOf(7, 8, 9, 10, 11)
            )

            matrixOf(
                mutableListOf(7, 8, 9, 10, 11),
                mutableListOf(1, 2, 3),
                mutableListOf(4, 5, 6)
            )

            matrixOf(
                mutableListOf("1", "1", "1", "1"),
                mutableListOf(4, 5, 6)
            )
        }
    }

    @Test
    fun matrixSizeWithConstructor() {
        val matrix1 = Matrix<Int>(size = MatrixSize(row = 3, column = 4))
        val matrix2 = Matrix<Int>(size = MatrixSize(row = 1, column = 1))

        assertEquals(expected = matrix1.size, actual = MatrixSize(3, 4))
        assertFails { matrix1[1, 1] as Int}
        assertEquals(expected = matrix2.rows.size, 1)
        assertFails {
            Matrix<Int>(size = MatrixSize(row = -3, column = -4))
        }
    }
}