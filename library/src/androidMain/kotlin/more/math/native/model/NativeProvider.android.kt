package more.math.native.model

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual class NativeProvider actual constructor() {

    companion object {
        init {
            System.loadLibrary("nativelib")
        }
    }

    private external fun factorial(number: Int) : Long

    actual fun nativeFactorial(number: Int): Long {
        return factorial(number = number)
    }
}