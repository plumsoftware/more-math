package more.math.nativelib

class NativeLib {
    external fun stringFromJNI(): String

    fun init() {
        System.loadLibrary("nativelib")
    }
}