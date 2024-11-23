package more.math.platform.model

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BigFloat actual constructor(value: String) {
    private val integerPart: BigInt
    private val fractionalPart: BigInt

    init {
        val parts = value.split(".")
        integerPart = BigInt(parts[0])
        fractionalPart = if (parts.size > 1) BigInt(parts[1]) else BigInt("0")
    }

    actual companion object {
        actual val ZERO: BigFloat get() = BigFloat("0.0")
        actual val ONE: BigFloat get() = BigFloat("1.0")
    }

    actual fun add(other: BigFloat): BigFloat {
        val sumInteger = integerPart.add(other.integerPart)
        val sumFractional = fractionalPart.add(other.fractionalPart)

        return if (sumFractional.toString().length > fractionalPart.toString().length) {
            val newInteger = sumInteger.add(BigInt("1"))
            val newFractional = BigInt("0")
            BigFloat("$newInteger.$newFractional")
        } else {
            BigFloat("$sumInteger.$sumFractional")
        }
    }

    actual fun multiply(other: BigFloat): BigFloat {
        val productInteger = integerPart.multiply(other.integerPart)
        val productFractional = fractionalPart.multiply(other.fractionalPart)

        val combinedFractional = productInteger.add(
            productFractional
        )

        return BigFloat("$combinedFractional.0")
    }

    actual override fun toString(): String {
        return "$integerPart.$fractionalPart"
    }
}
