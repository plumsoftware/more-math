package more.math.matrix.model

import kotlin.math.pow

fun <R : Number> Matrix<R>.determinant(): Double {
    isSquare(matrix = this)

    if (rows.size == 1) {
        return this[0, 0].toDouble()
    }

    if (rows.size == 2) {
        return (this[0, 0].toDouble() * this[1, 1].toDouble() -
                this[0, 1].toDouble() * this[1, 0].toDouble())
    }

    var det = 0.0

    for (j in 0 until rows[0].size) {
        // Создание подматрицы (минор)
        val minor = Matrix(*(rows.indices.filter { it != 0 }.map { rowIndex ->
            rows[rowIndex].indices.filter { it != j }.map { colIndex ->
                this[rowIndex, colIndex]
            }
        }.toTypedArray()))

        det += (-1.0).pow(j) * this[0, j].toDouble() * minor.determinant()
    }

    return det
}

fun <R : Number> Matrix<R>.transpose(): Matrix<R> {
    val transposedRows = Array(rows[0].size) { rowIndex ->
        List(rows.size) { colIndex ->
            this[colIndex, rowIndex]
        }
    }
    return Matrix(*transposedRows)
}
