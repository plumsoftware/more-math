package interactor

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.test.runTest
import more.math.factorial.interactor.SimpleFactorial
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SimpleFactorialTest {

    private lateinit var simpleFactorial: SimpleFactorial

    @BeforeTest
    fun setUp() {
        simpleFactorial = SimpleFactorial()
    }

    @Test
    fun recursive() {
        val result: Long = simpleFactorial.recursive(n = 3)
        assertEquals(expected = 6, actual = result)
    }

    @Test
    fun suspendRecursive() = runTest {
        val result: Long = simpleFactorial.recursive(n = 3L)
        assertEquals(expected = 6, actual = result)
    }

    @Test
    fun recursiveBlocking() {
        val result: Long = simpleFactorial.recursiveBlocking(n = 3L)
        assertEquals(expected = 6, actual = result)
    }

    @Test
    fun recursiveAsync() = runTest {
        val deferredResult: Deferred<Long> = simpleFactorial.recursiveAsync(n = 3L)
        val result = deferredResult.await()
        assertEquals(expected = 6, actual = result)
    }
}