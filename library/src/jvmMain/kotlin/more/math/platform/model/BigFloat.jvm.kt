package more.math.platform.model

import java.math.BigDecimal

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BigFloat actual constructor(value: String) {
    actual companion object {
        actual val ZERO: BigFloat get() = BigFloat(BigDecimal.ZERO.toString())
        actual val ONE: BigFloat get() = BigFloat(BigDecimal.ONE.toString())
    }

    private val bigFloat = BigDecimal(value)

    actual fun add(other: BigFloat): BigFloat {
        return BigFloat(this.bigFloat.add(other.bigFloat).toString())
    }

    actual fun multiply(other: BigFloat): BigFloat {
        return BigFloat(this.bigFloat.multiply(other.bigFloat).toString())
    }

    actual override fun toString(): String {
        return this.bigFloat.toString()
    }
}
