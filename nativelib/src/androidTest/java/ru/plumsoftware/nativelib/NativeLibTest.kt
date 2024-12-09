package ru.plumsoftware.nativelib

import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class NativeLibTest {

    @Before
    fun setup() {
        NativeLib.INIT
    }

    @Test
    fun useNativeFactorial() {
        val actual: Long = NativeLib.HyperOperators.nativeFactorial(number = 3)
        val expected: Long = 6L
        assertEquals(expected, actual)
    }
}