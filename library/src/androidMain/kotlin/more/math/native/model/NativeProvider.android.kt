package more.math.native.model

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual class NativeProvider actual constructor() {

    companion object {
        init {
            System.loadLibrary("nativelib")
        }
    }

    private external fun cppFactorial(number: Int) : Long

    private external fun cppLongFactorial(number: Long) : Long

    private external fun cppAverage(vararg number: Int) : Double

    private external fun cppStandardDeviation(vararg numbers: Double) : Double

    private external fun cppTetraction(number: Double, other: Int) : Double

    private external fun cppGcd(a: Int, b: Int) : Int

    actual fun nativeFactorial(number: Int): Long {
        return cppFactorial(number = number)
    }

    actual fun nativeFactorial(number: Long): Long {
        return cppLongFactorial(number = number)
    }

    actual fun nativeAverage(vararg numbers: Int) : Double {
        return cppAverage(*numbers)
    }

    actual fun standardDeviation(vararg numbers: Double) : Double {
        return cppStandardDeviation(*numbers)
    }

    actual fun tetraction(number: Double, other: Int) : Double {
        return cppTetraction(number = number, other = other)
    }

    actual fun gcd(a: Int, b: Int): Int {
        return cppGcd(a, b)
    }
}