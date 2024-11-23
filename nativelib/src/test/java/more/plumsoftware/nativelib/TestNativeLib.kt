package more.plumsoftware.nativelib

import more.math.nativelib.NativeLib
import org.junit.Test
import org.junit.Assert.*

class TestNativeLib {
    @Test
    fun testInitString() {
        val lib = NativeLib().apply { init() }
        val expected = "Hello from C++"
        val actual = lib.stringFromJNI()
        assertEquals(expected, actual)
    }
}