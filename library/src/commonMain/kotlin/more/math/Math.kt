package more.math

import more.math.factorial.interactor.SimpleFactorial
import more.math.matrix.model.Matrix

object Math {
    val simpleFactorial = SimpleFactorial()

    fun factorial(n: Int) : Long {
        return if (n == 0) 1L else n * factorial(n - 1)
    }

    inline fun <reified R> matrixOf(vararg row: List<Any>): Matrix<R> {
        return Matrix(*row.map { it.map { elem -> elem as R } }.toTypedArray())
    }
}