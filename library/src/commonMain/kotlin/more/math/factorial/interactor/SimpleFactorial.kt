package more.math.factorial.interactor

import kotlinx.coroutines.Deferred
import more.math.factorial.implementation.IterativeFactorialParentCalculator
import more.math.factorial.implementation.RecursiveFactorialParentCalculator
import more.math.factorial.repository.IterativeFactorialParentCalculatorRepository
import kotlin.coroutines.CoroutineContext

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

    fun recursiveBlocking(n: Long): Long {
        return recursiveFactorialParentCalculator.calculateBlocking(n = n)
    }

    fun recursiveAsync(n: Long): Deferred<Long> {
        return recursiveFactorialParentCalculator.calculateAsync(n = n)
    }

    fun recursiveAsync(context: CoroutineContext, n: Long): Deferred<Long> {
        return recursiveFactorialParentCalculator.calculateAsync(context = context, n = n)
    }
    //endregion

    //region::Iterative
    private val iterativeFactorialParentCalculator: IterativeFactorialParentCalculatorRepository = IterativeFactorialParentCalculator()

    fun iterative(n: Int) : Long {
        return iterativeFactorialParentCalculator.calculate(n)
    }

    suspend fun iterative(n: Long) : Long {
        return iterativeFactorialParentCalculator.calculate(n)
    }

    fun iterativeBlocking(n: Long) : Long {
        return iterativeFactorialParentCalculator.calculateBlocking(n)
    }

    fun iterativeAsync(n: Long) : Deferred<Long> {
        return iterativeFactorialParentCalculator.calculateAsync(n)
    }

    fun iterativeAsync(context: CoroutineContext, n: Long) : Deferred<Long> {
        return iterativeFactorialParentCalculator.calculateAsync(context, n)
    }
    //endregion
}