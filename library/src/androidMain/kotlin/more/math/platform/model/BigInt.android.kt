package more.math.platform.model

import java.math.BigInteger

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BigInt actual constructor(value: String) {

    actual companion object {
        actual val ZERO: BigInt
            get() = BigInt("0")
        actual val ONE: BigInt
            get() = BigInt("1")
    }

    private val bigInt = BigInteger(value)

    actual fun add(other: BigInt): BigInt {
        return BigInt(this.bigInt.add(other.bigInt).toString())
    }

    actual fun multiply(other: BigInt): BigInt {
        return BigInt(this.bigInt.multiply(other.bigInt).toString())
    }

    actual override fun toString(): String {
        return this.bigInt.toString()
    }
}