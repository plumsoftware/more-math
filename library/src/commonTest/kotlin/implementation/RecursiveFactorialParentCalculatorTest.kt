package implementation

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.test.runTest
import more.math.factorial.implementation.RecursiveFactorialParentCalculator
import more.math.factorial.repository.RecursiveFactorialParentCalculatorRepository
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RecursiveFactorialParentCalculatorTest {

    private lateinit var recursiveFactorialParentCalculatorRepository: RecursiveFactorialParentCalculatorRepository

    @BeforeTest
    fun setUp() {
        recursiveFactorialParentCalculatorRepository = RecursiveFactorialParentCalculator()
    }

    @Test
    fun calculate() {
        val result: Long = recursiveFactorialParentCalculatorRepository.calculate(n = 3)
        assertEquals(expected = 6, actual = result)
    }

    @Test
    fun testCalculate() = runTest {
        val result: Long = recursiveFactorialParentCalculatorRepository.calculate(n = 3L)
        assertEquals(expected = 6L, actual = result)
    }

    @Test
    fun calculateBlocking() {
        val result: Long = recursiveFactorialParentCalculatorRepository.calculateBlocking(n = 3L)
        assertEquals(expected = 6L, actual = result)
    }

    @Test
    fun calculateAsync() = runTest {
        val deferredResult: Deferred<Long> = recursiveFactorialParentCalculatorRepository.calculateAsync(n = 3L)
        val result = deferredResult.await()
        assertEquals(expected = 6, actual = result)
    }

    @Test
    fun testCalculateAsync() = runTest {
        val deferredResult: Deferred<Long> = recursiveFactorialParentCalculatorRepository.calculateAsync(context = this.coroutineContext,n = 3L)
        val result = deferredResult.await()
        assertEquals(expected = 6, actual = result)
    }
}