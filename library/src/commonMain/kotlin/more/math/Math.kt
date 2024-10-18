package more.math

import more.math.factorial.interactor.SimpleFactorial
import more.math.matrix.model.Matrix

object Math {
    val simpleFactorial = SimpleFactorial()

    inline fun <reified R> matrixOf(vararg row: List<Any>): Matrix<R> {
        return Matrix(*row.map { it.map { elem -> elem as R } }.toTypedArray())
    }
}