package more.math.native.model

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual class NativeProvider actual constructor() {

    //endregion
    actual fun nativeFactorial(number: Int): Long {
        return if (number == 0) 1L else number * nativeFactorial(number - 1)
    }
}