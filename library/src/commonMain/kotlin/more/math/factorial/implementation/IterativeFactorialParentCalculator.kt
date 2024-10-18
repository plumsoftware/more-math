package more.math.factorial.implementation

import kotlinx.coroutines.*
import more.math.factorial.parent.FactorialParent
import more.math.factorial.repository.IterativeFactorialParentCalculatorRepository
import kotlin.coroutines.CoroutineContext

class IterativeFactorialParentCalculator : FactorialParent(), IterativeFactorialParentCalculatorRepository {
    override fun calculate(n: Int): Long {
        validateForNegative(n)
        var result = 1L
        for (i in 1..n) {
            result *= i
        }
        return result
    }

    override suspend fun calculate(n: Long): Long {
        validateForNegative(n)
        var result = 1L
        for (i in 1..n) {
            result *= i
        }
        return result
    }

    override fun calculateBlocking(n: Long): Long {
        validateForNegative(n)
        var result = 1L
        for (i in 1..n) {
            result *= i
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

    override fun calculateAsync(context: CoroutineContext, n: Long): Deferred<Long> {
        return CoroutineScope(context).async {
            validateForNegative(n)
            calculate(n)
        }
    }
}