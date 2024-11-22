package more.math.platform.factorial

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BigNum actual constructor(value: String) {

    private val digits: List<Int> = value.reversed().map { it.digitToInt() }

    actual companion object {
        actual val ZERO: BigNum
            get() = BigNum("0")
        actual val ONE: BigNum
            get() = BigNum("1")
    }

    actual fun add(other: BigNum): BigNum {
        val maxLength = maxOf(this.digits.size, other.digits.size)
        val result = MutableList(maxLength + 1) { 0 }
        var carry = 0

        for (i in 0 until maxLength) {
            val thisDigit = if (i < this.digits.size) this.digits[i] else 0
            val otherDigit = if (i < other.digits.size) other.digits[i] else 0
            val sum = thisDigit + otherDigit + carry
            result[i] = sum % 10
            carry = sum / 10
        }

        if (carry > 0) {
            result[maxLength] = carry
        }

        return BigNum(result.reversed().dropWhile { it == 0 }.joinToString("") { it.toString() }
            .ifEmpty { "0" })
    }

    actual fun multiply(other: BigNum): BigNum {
        val result = MutableList(this.digits.size + other.digits.size) { 0 }

        for (i in this.digits.indices) {
            for (j in other.digits.indices) {
                val product = this.digits[i] * other.digits[j]
                result[i + j] += product
            }
        }

        for (i in result.indices) {
            if (result[i] >= 10) {
                val carry = result[i] / 10
                result[i] %= 10
                if (i + 1 < result.size) {
                    result[i + 1] += carry
                } else {
                    result.add(carry)
                }
            }
        }

        return BigNum(result.reversed().dropWhile { it == 0 }.joinToString("") { it.toString() }
            .ifEmpty { "0" })
    }

    actual override fun toString(): String {
        return digits.reversed().joinToString("") { it.toString() }.ifEmpty { "0" }
    }
}