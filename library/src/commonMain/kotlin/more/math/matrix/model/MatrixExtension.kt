package more.math.matrix.model

import kotlin.math.pow

//region::Other
public fun <R : Number> Matrix<R>.determinant(): Double {
    isSquare(matrix = this)

    if (rows.size == 1) {
        return this[0, 0].toDouble()
    }
    if (rows.size == 2) {
        return (this[0, 0].toDouble() * this[1, 1].toDouble() - this[0, 1].toDouble() * this[1, 0].toDouble())
    }

    var det = 0.0
    for (j in 0 until rows[0].size) {
        val minor = Matrix(*rows.indices.filter { it != 0 }.map { rowIndex ->
            rows[rowIndex].indices.filter { it != j }.map { colIndex ->
                this[rowIndex, colIndex]
            }.toMutableList()
        }.toTypedArray())

        det += (-1.0).pow(j) * this[0, j].toDouble() * minor.determinant()
    }
    return det
}

public fun <R : Number> Matrix<R>.transpose(): Matrix<R> {
    val transposedRows = Array(rows[0].size) { rowIndex ->
        List(rows.size) { colIndex ->
            this[colIndex, rowIndex]
        }
    }
    return Matrix(*transposedRows.map { it.toMutableList() }.toTypedArray())
}

public fun <R : Number> Matrix<R>.pow(value: Int): Matrix<R> {
    this.verifyMatrixPower(value)
    var resMatrix = this
    var power = value
    while (power > 1) {
        resMatrix *= resMatrix
        power -= 1
    }
    return resMatrix
}
//endregion

//region::Times
public fun <R : Number> Matrix<R>.times(value: Int): Matrix<Int> {
    val map: List<List<Int>> = this.rows.map { rs ->
        val newRow = rs.map { item ->
            item.toInt() * value
        }
        newRow
    }
    return Matrix(*map.map { it.toMutableList() }.toTypedArray())
}

public fun <R : Number> Matrix<R>.times(value: Double): Matrix<Double> {
    val map: List<List<Double>> = this.rows.map { rs ->
        val newRow = rs.map { item ->
            item.toDouble() * value
        }
        newRow
    }
    return Matrix(*map.map { it.toMutableList() }.toTypedArray())
}

public fun <R : Number> Matrix<R>.times(value: Float): Matrix<Float> {
    val map: List<List<Float>> = this.rows.map { rs ->
        val newRow = rs.map { item ->
            item.toFloat() * value
        }
        newRow
    }
    return Matrix(*map.map { it.toMutableList() }.toTypedArray())
}

public fun <R : Number> Matrix<R>.times(value: Long): Matrix<Long> {
    val map: List<List<Long>> = this.rows.map { rs ->
        val newRow = rs.map { item ->
            item.toLong() * value
        }
        newRow
    }
    return Matrix(*map.map { it.toMutableList() }.toTypedArray())
}
//endregion

//region::Min in matrix
public inline fun Matrix<Int>.minInMatrix(): Int {
    var globalMin: Int = Int.MAX_VALUE
    var min = 0
    this.rows.forEachIndexed { _, rs ->
        min = rs.minBy { it }
        if (min < globalMin) {
            globalMin = min
        }
    }
    return globalMin
}

public inline fun Matrix<Double>.minInMatrix(): Double {
    var globalMin: Double = Double.MAX_VALUE
    var min = 0.0
    this.rows.forEachIndexed { _, rs ->
        min = rs.minBy { it }
        if (min < globalMin) {
            globalMin = min
        }
    }
    return globalMin
}

public inline fun Matrix<Float>.minInMatrix(): Float {
    var globalMin: Float = Float.MAX_VALUE
    var min = 0.0f
    this.rows.forEachIndexed { _, rs ->
        min = rs.minBy { it }
        if (min < globalMin) {
            globalMin = min
        }
    }
    return globalMin
}

public inline fun Matrix<Long>.minInMatrix(): Long {
    var globalMin: Long = Long.MAX_VALUE
    var min = 0L
    this.rows.forEachIndexed { _, rs ->
        min = rs.minBy { it }
        if (min < globalMin) {
            globalMin = min
        }
    }
    return globalMin
}

public inline fun <reified R, reified T : Comparable<T>> Matrix<R>.minInMatrixBy(block: (R) -> T): T {
    this.isEmpty(this)

    var minValue: T? = null

    for (row in rows) {
        for (element in row) {
            val transformedValue = block(element)

            if (minValue == null || transformedValue < minValue) {
                minValue = transformedValue
            }
        }
    }

    return minValue ?: throw IllegalStateException("Unable to find minimum value in the matrix.")
}
//endregion

//region::Max in matrix
public inline fun Matrix<Int>.maxInMatrix(): Int {
    var globalMax: Int = Int.MIN_VALUE
    var max = 0
    this.rows.forEachIndexed { _, rs ->
        max = rs.maxBy { it }
        if (max > globalMax) {
            globalMax = max
        }
    }
    return globalMax
}

public inline fun Matrix<Double>.maxInMatrix(): Double {
    var globalMax: Double = Double.MIN_VALUE
    var max = 0.0
    this.rows.forEachIndexed { _, rs ->
        max = rs.maxBy { it }
        if (max > globalMax) {
            globalMax = max
        }
    }
    return globalMax
}

public inline fun Matrix<Float>.maxInMatrix(): Float {
    var globalMax: Float = Float.MIN_VALUE
    var max = 0.0f
    this.rows.forEachIndexed { _, rs ->
        max = rs.maxBy { it }
        if (max > globalMax) {
            globalMax = max
        }
    }
    return globalMax
}

public inline fun Matrix<Long>.maxInMatrix(): Long {
    var globalMax: Long = Long.MIN_VALUE
    var max = 0L
    this.rows.forEachIndexed { _, rs ->
        max = rs.maxBy { it }
        if (max > globalMax) {
            globalMax = max
        }
    }
    return globalMax
}

public inline fun <reified R, reified T : Comparable<T>> Matrix<R>.maxInMatrixBy(block: (R) -> T): T {
    this.isEmpty(this)

    var maxValue: T? = null

    for (row in rows) {
        for (element in row) {
            val transformedValue = block(element)

            if (maxValue == null || transformedValue > maxValue) {
                maxValue = transformedValue
            }
        }
    }

    return maxValue ?: throw IllegalStateException("Unable to find maximum value in the matrix.")
}
//endregion