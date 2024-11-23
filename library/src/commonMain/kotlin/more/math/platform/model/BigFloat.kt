package more.math.platform.model

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class BigFloat(value: String) {
    companion object {
        val ZERO: BigFloat
        val ONE: BigFloat
    }
    fun add(other: BigFloat): BigFloat
    fun multiply(other: BigFloat): BigFloat
    override fun toString(): String
}