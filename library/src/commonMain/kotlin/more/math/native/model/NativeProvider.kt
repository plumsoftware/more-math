package more.math.native.model

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect class NativeProvider constructor() {

    //region::hyper operators
    fun nativeFactorial(number: Int): Long

    fun nativeFactorial(number: Long): Long

    fun nativeAverage(vararg numbers: Int) : Double

    fun standardDeviation(vararg numbers: Double) : Double
    //endregion
}