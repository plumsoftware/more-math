package more.math

import more.math.matrix.model.Matrix
import more.math.vector.model.Vector2

public inline fun <reified R> matrixOf(vararg row: List<R>): Matrix<R> {
    return Matrix(*row.map { it.map { elem -> elem } }.toTypedArray())
}

public inline fun <reified T : Number> vector2Of(x: T, y: T): Vector2<T> {
    return Vector2(x, y)
}