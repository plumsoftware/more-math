package more.math

import more.math.matrix.model.Matrix

inline fun <reified R> matrixOf(vararg row: List<Any>): Matrix<R> {
    return Matrix(*row.map { it.map { elem -> elem as R } }.toTypedArray())
}