package more.math.factorial.repository

import kotlinx.coroutines.Deferred

interface RecursiveFactorialParentCalculatorRepository {
    fun calculate(n: Int): Long

    //Async
    suspend fun calculate(n: Long): Long
    fun calculateBlocking(n: Long): Long
    fun calculateAsync(n: Long): Deferred<Long>
}