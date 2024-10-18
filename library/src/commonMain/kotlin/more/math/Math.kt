package more.math

import more.math.factorial.interactor.SimpleFactorial
import more.math.matrix.model.Matrix
import kotlin.math.pow

object Math {
    val simpleFactorial = SimpleFactorial()

    fun factorial(n: Int) : Long {
        return if (n == 0) 1L else n * factorial(n - 1)
    }

    inline fun <reified R> matrixOf(vararg row: List<Any>): Matrix<R> {
        return Matrix(*row.map { it.map { elem -> elem as R } }.toTypedArray())
    }

    fun tetraction(number: Double, other: Int) : Double {
        require(number >= 0 && other >= 0) {
            "Both arguments must be more than zero"
        }
        return if (other == 0) {
            1.0
        } else {
            number.pow(tetraction(number, other - 1))
        }
    }
}