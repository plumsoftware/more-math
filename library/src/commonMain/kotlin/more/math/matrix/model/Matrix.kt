package more.math.matrix.model

import more.math.matrix.parent.MatrixParent

public class Matrix<R>(vararg val rows: List<R>) : MatrixParent() {

    fun column(columnIndex: Int): List<R> {
        verifyColumn(this, columnIndex)
        val column: List<R> = rows.map { it[columnIndex] }
        return column
    }

    operator fun get(rowIndex: Int, columnIndex: Int): R {
        verify(rows = rows, rowIndex = rowIndex, columnIndex = columnIndex)
        return rows[rowIndex][columnIndex]
    }

    @Suppress("UNCHECKED_CAST")
    operator fun plus(other: Matrix<R>): Matrix<R> {
        verifySize(rows = rows, other = other)
        val resultRows = Array(rows.size) { rowIndex ->
            List(rows[rowIndex].size) { columnIndex ->

                val unknownValueThis = this.rows[rowIndex][columnIndex]
                val thisValue = if (unknownValueThis is Int) {
                    unknownValueThis
                } else {
                    unknownValueThis as Double
                }

                val unknownValueOther = other.rows[rowIndex][columnIndex]
                val otherValue = if (unknownValueOther is Int) {
                    unknownValueOther
                } else {
                    unknownValueOther as Double
                }

                if (thisValue is Int && otherValue is Int) {
                    (thisValue + otherValue) as R
                } else if (thisValue is Double && otherValue is Int) {
                    (thisValue + otherValue) as R
                } else if (thisValue is Int && otherValue is Double) {
                    (thisValue + otherValue) as R
                } else {
                    thisValue as Double
                    otherValue as Double
                    (thisValue + otherValue) as R
                }
            }
        }

        return Matrix(*resultRows)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun minus(other: Matrix<R>): Matrix<R> {
        verifySize(rows = rows, other = other)
        val resultRows = Array(rows.size) { rowIndex ->
            List(rows[rowIndex].size) { columnIndex ->

                val unknownValueThis = this.rows[rowIndex][columnIndex]
                val thisValue = if (unknownValueThis is Int) {
                    unknownValueThis
                } else {
                    unknownValueThis as Double
                }

                val unknownValueOther = other.rows[rowIndex][columnIndex]
                val otherValue = if (unknownValueOther is Int) {
                    unknownValueOther
                } else {
                    unknownValueOther as Double
                }

                if (thisValue is Int && otherValue is Int) {
                    (thisValue - otherValue) as R
                } else if (thisValue is Double && otherValue is Int) {
                    (thisValue - otherValue) as R
                } else if (thisValue is Int && otherValue is Double) {
                    (thisValue - otherValue) as R
                } else {
                    thisValue as Double
                    otherValue as Double
                    (thisValue - otherValue) as R
                }
            }
        }

        return Matrix(*resultRows)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun times(other: Matrix<R>): Matrix<R> {
        verifyRows(rows = this.rows, other = other)

        val resultRows = Array(rows.size) { rowIndex ->
            List(other.rows[0].size) { columnIndex ->
                var sum = 0.0
                for (k in 0 until rows[0].size) {

                    val unknownValueThis = this.rows[rowIndex][k]
                    val thisValue = if (unknownValueThis is Int) {
                        unknownValueThis
                    } else {
                        unknownValueThis as Double
                    }

                    val unknownValueOther = other.rows[k][columnIndex]
                    val otherValue = if (unknownValueOther is Int) {
                        unknownValueOther
                    } else {
                        unknownValueOther as Double
                    }

                    if (thisValue is Int && otherValue is Int) {
                        sum += thisValue * otherValue
                    } else if (thisValue is Double && otherValue is Int) {
                        sum += thisValue * otherValue
                    } else if (thisValue is Int && otherValue is Double) {
                        sum += thisValue * otherValue
                    } else {
                        thisValue as Double
                        otherValue as Double
                        sum += thisValue * otherValue
                    }
                }
                sum as R
            }
        }
        return Matrix(*resultRows)
    }

    override fun toString(): String {
        return rows.joinToString("\n") { it.joinToString(" ") }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Matrix<*>) return false

        if (rows.size != other.rows.size || rows[0].size != other.rows[0].size) return false

        for (i in rows.indices) {
            if (rows[i] != other.rows[i]) return false
        }
        return true
    }

    override fun hashCode(): Int {
        var result = 1
        for (row in rows) {
            result = 31 * result + row.hashCode()
        }
        return result
    }
}