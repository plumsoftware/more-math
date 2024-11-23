package more.math.platform.model

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class BigInt(value: String) {
    companion object {
        val ZERO: BigInt
        val ONE: BigInt
    }
    fun add(other: BigInt): BigInt
    fun multiply(other: BigInt): BigInt
    override fun toString(): String
}