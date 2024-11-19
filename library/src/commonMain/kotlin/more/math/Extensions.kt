package more.math

import more.math.complex.model.Complex
import more.math.matrix.model.Matrix
import more.math.vector.model.Vector2

public inline fun <reified R> matrixOf(vararg row: MutableList<R>): Matrix<R> {
    return Matrix(*row.map { it.toMutableList() }.toTypedArray())
}

//region::Vector
public inline fun <reified T : Number> vector2Of(x: T, y: T): Vector2<T> {
    return Vector2(x, y)
}
//endregion

//region::Complex
public inline fun <reified R : Number> complex(
    realPart: R,
    imaginaryPart: Double
): Complex {
    return Complex(
        realPart = realPart,
        imaginaryPart = (if (imaginaryPart < 0) -1 else 1) * kotlin.math.sqrt(kotlin.math.abs(imaginaryPart))
    )
}

public inline fun complex(
    imaginaryPart: Double
): Complex {
    return Complex(
        realPart = 0,
        imaginaryPart = (if (imaginaryPart < 0) -1 else 1) * kotlin.math.sqrt(kotlin.math.abs(imaginaryPart))
    )
}
//endregion