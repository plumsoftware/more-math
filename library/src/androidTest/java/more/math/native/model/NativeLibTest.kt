package more.math.native.model

import androidx.test.ext.junit.runners.AndroidJUnit4
import more.math.MoreMath
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class NativeLibTest {

    @Test
    fun nativeFactorial() {
        val actual = MoreMath.factorial(n = 3)
        val expected = 6L
        assertEquals(expected, actual)
    }
}