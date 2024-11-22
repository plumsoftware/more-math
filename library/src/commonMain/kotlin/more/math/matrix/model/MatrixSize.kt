package more.math.matrix.model

data class MatrixSize(
    val row: Int,
    val column: Int
) {
    operator fun compareTo(other: MatrixSize): Int {
        return (this.row * this.column).compareTo(other.row * other.column)
    }

    operator fun plus(other: MatrixSize): MatrixSize {
        return MatrixSize(row = this.row + other.row, column = this.column + other.column)
    }

    operator fun minus(other: MatrixSize): MatrixSize {
        return MatrixSize(row = this.row - other.row, column = this.column - other.column)
    }

    operator fun times(other: MatrixSize): MatrixSize {
        return MatrixSize(row = this.row * other.row, column = this.column * other.column)
    }
}
