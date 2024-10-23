package more.math.complex.model

public data class Complex (val realPart: Number, val imaginaryPart: Double) {

    override fun toString(): String {
        return if (imaginaryPart >= 0) {
            "$realPart + ${imaginaryPart}i"
        } else {
            "$realPart - ${-imaginaryPart}i"
        }
    }

    operator fun plus(other: Complex): Complex {
        val realPartSum = when (this.realPart) {
            is Int -> this.realPart.toInt() + other.realPart.toInt()
            is Double -> this.realPart.toDouble() + other.realPart.toDouble()
            else -> throw IllegalArgumentException("Unknown realPart type")
        }

        return Complex(realPartSum, this.imaginaryPart + other.imaginaryPart)
    }

    operator fun minus(other: Complex): Complex {
        val realPartMinus = when (this.realPart) {
            is Int -> this.realPart.toInt() - other.realPart.toInt()
            is Double -> this.realPart.toDouble() - other.realPart.toDouble()
            else -> throw IllegalArgumentException("Unknown realPart type")
        }

        return Complex(realPartMinus, this.imaginaryPart - other.imaginaryPart)
    }

    operator fun times(other: Complex): Complex {
        val realPartMul = when (this.realPart) {
            is Int -> this.realPart.toInt() * other.realPart.toInt()
            is Double -> this.realPart.toDouble() * other.realPart.toDouble()
            else -> throw IllegalArgumentException("Unknown realPart type")
        }

        val realPartRes = when (realPartMul) {
            is Int -> realPartMul.toInt() - this.imaginaryPart * other.imaginaryPart
            is Double -> realPartMul.toDouble() - this.imaginaryPart * other.imaginaryPart
            else -> throw IllegalArgumentException("Unknown realPart type")
        }

        val imaginaryPartRes =
            this.realPart.toDouble() * other.imaginaryPart + this.imaginaryPart * other.realPart.toDouble()

        return Complex(realPartRes, imaginaryPartRes)
    }

    operator fun div(other: Complex): Complex {
        val thisReal = this.realPart.toDouble()
        val otherReal = other.realPart.toDouble()

        val denominator =
            otherReal * otherReal + other.imaginaryPart * other.imaginaryPart
        val realPart = (thisReal * otherReal + this.imaginaryPart * other.imaginaryPart) / denominator
        val imaginaryPart = (this.imaginaryPart * otherReal - thisReal * other.imaginaryPart) / denominator

        return Complex(realPart, imaginaryPart)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false

        return this.realPart == other.realPart && this.imaginaryPart == other.imaginaryPart
    }

    override fun hashCode(): Int {
        var result = realPart.hashCode()
        result = 31 * result + imaginaryPart.hashCode()
        return result
    }
}
