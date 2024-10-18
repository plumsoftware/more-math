package more.math.factorial.interactor

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SimpleFactorialTest {

    private lateinit var simpleFactorial: SimpleFactorial

    @Before
    fun setUp() {
        simpleFactorial = SimpleFactorial()
    }

    @Test
    fun recursive() {
        val result: Long = simpleFactorial.recursive(n = 3)
        assertEquals(expected = 6, actual = result)
    }
}