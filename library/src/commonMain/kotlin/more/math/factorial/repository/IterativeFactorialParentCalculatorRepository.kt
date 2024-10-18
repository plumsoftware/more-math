package more.math.factorial.repository

import kotlinx.coroutines.Deferred
import kotlin.coroutines.CoroutineContext

interface IterativeFactorialParentCalculatorRepository {
    fun calculate(n: Int): Long

    //Async
    suspend fun calculate(n: Long): Long
    fun calculateBlocking(n: Long): Long
    fun calculateAsync(n: Long): Deferred<Long>
    fun calculateAsync(context: CoroutineContext, n: Long): Deferred<Long>
}