package more.math.factorial.implementation

import kotlinx.coroutines.*
import more.math.factorial.parent.FactorialParent
import more.math.factorial.repository.RecursiveFactorialParentCalculatorRepository

class RecursiveFactorialParentCalculator : FactorialParent(), RecursiveFactorialParentCalculatorRepository {
    override fun calculate(n: Int): Long {
        validateForNegative(n)
        return if (n == 0) 1 else n * calculate(n - 1)
    }

    //Async
    override suspend fun calculate(n: Long): Long {
        validateForNegative(n)
        return if (n == 0L) 1L else n * calculate(n - 1L)
    }

    override fun calculateBlocking(n: Long): Long {
        validateForNegative(n)
        val result = runBlocking {
            return@runBlocking if (n == 0L) 1L else n * calculate(n - 1L)
        }
        return result
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun calculateAsync(n: Long): Deferred<Long> {
        return GlobalScope.async {
            validateForNegative(n)
            calculate(n)
        }
    }
}