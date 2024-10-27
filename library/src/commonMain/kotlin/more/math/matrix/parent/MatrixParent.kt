package more.math.matrix.parent

import more.math.matrix.model.Matrix

abstract class MatrixParent {
    fun <R> verify(rows: Array<out List<R>>, rowIndex: Int, columnIndex: Int) {
        require(rowIndex in rows.indices) { "Row index out of bounds." }
        require(columnIndex in rows[rowIndex].indices) { "Column index out of bounds." }
    }

    fun <R> verifySize(rows: Array<out List<R>>, other: Matrix<R>) {
        require(rows.size == other.rows.size && rows[0].size == other.rows[0].size) {
            "Matrices must have the same dimensions for addition."
        }
    }

    fun <R> verifyRows(rows: Array<out List<R>>, other: Matrix<R>) {
        require(rows.size == other.rows[0].size) {
            "Number of columns of the first matrix must be equal to the number of rows of the second matrix."
        }
    }

    fun <R> isSquare(matrix: Matrix<R>) {
        require(matrix.rows.size == matrix.rows[0].size) {
            "Number of rows must be equals number of columns."
        }
    }

    fun <R> verifyColumn(matrix: Matrix<R>, columnIndex: Int) {
        require(columnIndex in matrix.rows.indices) {
            "Column index is out of matrix size."
        }
    }

    fun verifyMatrixPower(power: Int) {
        require(power > 1) {
            "Power must be more than 1."
        }
    }
}