package more.math.platform.factorial

import java.math.BigInteger

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BigNum actual constructor(value: String) {

    actual companion object {
        actual val ZERO: BigNum
            get() = BigNum("0")
        actual val ONE: BigNum
            get() = BigNum("1")
    }

    private val bigInt = BigInteger(value)

    actual fun add(other: BigNum): BigNum {
        return BigNum(this.bigInt.add(other.bigInt).toString())
    }

    actual fun multiply(other: BigNum): BigNum {
        return BigNum(this.bigInt.multiply(other.bigInt).toString())
    }

    actual override fun toString(): String {
        return this.bigInt.toString()
    }
}