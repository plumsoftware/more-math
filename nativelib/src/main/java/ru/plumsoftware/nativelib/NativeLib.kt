package ru.plumsoftware.nativelib

class NativeLib {
    companion object INIT {
        init {
            System.loadLibrary("nativelib")
        }
    }

    object HyperOperators {
        external fun nativeFactorial(number: Int) : Long
    }
}