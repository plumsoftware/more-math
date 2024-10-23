package more.math.complex.model

infix fun Complex.pow(value: Int): Complex {
    var result = Complex(this.realPart, 0.0)
    val base = this

    for (i in 1..value) {
        result *= base
    }

    return result
}