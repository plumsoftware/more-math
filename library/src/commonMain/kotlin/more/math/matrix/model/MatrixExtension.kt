package more.math.matrix.model

inline fun <reified R> matrixOf(vararg row: List<Any>): Matrix<R> {
    return Matrix(*row.map { it.map { elem -> elem as R } }.toTypedArray())
}