package more.math.platform.factorial

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class BigNum(value: String) {
    companion object {
        val ZERO: BigNum
        val ONE: BigNum
    }
    fun add(other: BigNum): BigNum
    fun multiply(other: BigNum): BigNum
    override fun toString(): String
}