package implementation

import kotlinx.coroutines.test.runTest
import more.math.factorial.implementation.IterativeFactorialParentCalculator
import more.math.factorial.repository.IterativeFactorialParentCalculatorRepository
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class IterativeFactorialParentCalculatorTest {

    private lateinit var iterativeFactorialParentCalculatorRepository: IterativeFactorialParentCalculatorRepository

    @BeforeTest
    fun setUp() {
        iterativeFactorialParentCalculatorRepository = IterativeFactorialParentCalculator()
    }

    @Test
    fun calculate() {
        val result = iterativeFactorialParentCalculatorRepository.calculate(n = 3)
        assertEquals(expected = 6, actual = result)
    }

    @Test
    fun testCalculate() = runTest {
        val result = iterativeFactorialParentCalculatorRepository.calculate(n = 3L)
        assertEquals(expected = 6L, actual = result)
    }

    @Test
    fun calculateBlocking() {
        val result = iterativeFactorialParentCalculatorRepository.calculateBlocking(n = 3L)
        assertEquals(expected = 6L, actual = result)
    }

    @Test
    fun calculateAsync() = runTest {
        val resultD = iterativeFactorialParentCalculatorRepository.calculateAsync(n = 3L)
        val result = resultD.await()
        assertEquals(expected = 6, actual = result)
    }

    @Test
    fun testCalculateAsync() = runTest {
        val resultD =
            iterativeFactorialParentCalculatorRepository.calculateAsync(context = this.coroutineContext, n = 3L)
        val result = resultD.await()
        assertEquals(expected = 6, actual = result)
    }
}