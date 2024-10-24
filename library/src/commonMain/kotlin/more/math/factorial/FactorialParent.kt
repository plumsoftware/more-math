package more.math.factorial

class FactorialParent {
    fun verifyFactorial(n: Int) {
        require(n >= 0) {
            "Factorial must be more than zero"
        }
    }

    fun verifyFactorial(n: Long) {
        require(n >= 0) {
            "Factorial must be more than zero"
        }
    }
}