package more.math.factorial.parent

abstract class FactorialParent constructor() {
    fun validateForNegative(n: Int) {
        require(n >= 0) { "Factorial is not defined for negative numbers." }
    }
    fun validateForNegative(n: Long) {
        require(n >= 0L) { "Factorial is not defined for negative numbers." }
    }
}