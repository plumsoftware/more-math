package more.math

import more.math.matrix.model.Matrix
import more.math.vector.model.Vector2

inline fun <reified R> matrixOf(vararg row: List<Any>): Matrix<R> {
    return Matrix(*row.map { it.map { elem -> elem as R } }.toTypedArray())
}

inline fun <reified T : Number> vector2Of(x: T, y: T): Vector2<T> {
    return Vector2(x, y)
}