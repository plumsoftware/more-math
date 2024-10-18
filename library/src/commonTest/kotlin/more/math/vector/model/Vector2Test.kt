package more.math.vector.model

import more.math.vector2Of
import kotlin.test.Test
import kotlin.test.assertEquals

class Vector2Test {

    @Test
    fun plusTest() {
        val vector1 = vector2Of(1, 2)
        val vector2 = vector2Of(3, 4)

        val res = vector1 + vector2
        assertEquals(expected = Vector2(x = 4, y = 6), actual = res)
    }

    @Test
    fun minusTest() {
        val vector1 = vector2Of(1, 2)
        val vector2 = vector2Of(3, 4)

        val res = vector1 - vector2
        assertEquals(expected = Vector2(x = -2, y = -2), actual = res)
    }

    @Test
    fun timesTest() {
        val vector1 = vector2Of(1, 2)
        val vector2 = vector2Of(3, 4)

        val res = vector1 * vector2
        assertEquals(expected = Vector2(x = 3, y = 8), actual = res)
    }

    @Test
    fun divTest() {
        val vector1 = vector2Of(1, 2)
        val vector2 = vector2Of(3, 4)

        val res = vector1 / vector2
        assertEquals(expected = Vector2(x = 1/3, y = 1/2), actual = res)
    }

    @Test
    fun length() {
        val vector1 = vector2Of(8.0, 6.0)

        val res = vector1.length()
        assertEquals(expected = 10.0, actual = res)
    }
}