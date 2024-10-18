package more.math.factorial.interactor

import kotlinx.coroutines.Deferred
import more.math.factorial.implementation.RecursiveFactorialParentCalculator

class SimpleFactorial {

    //region:Recursive
    private val recursiveFactorialParentCalculator: RecursiveFactorialParentCalculator =
        RecursiveFactorialParentCalculator()

    fun recursive(n: Int): Long {
        return recursiveFactorialParentCalculator.calculate(n = n)
    }

    suspend fun recursive(n: Long): Long {
        return recursiveFactorialParentCalculator.calculate(n = n)
    }

    fun recursiveBlocking(n: Long) : Long {
        return recursiveFactorialParentCalculator.calculateBlocking(n = n)
    }

    fun recursiveAsync(n: Long) : Deferred<Long> {
        return recursiveFactorialParentCalculator.calculateAsync(n = n)
    }
    //endregion
}