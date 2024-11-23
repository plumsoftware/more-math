package more.math.factorial

class FactorialParent {
    fun verifyFactorial(n: Int) {
        require(n in 0..20) {
            "Factorial must be in range 0..20."
        }
    }

    fun verifyFactorial(n: Long) {
        require(n in 0..20) {
            "Factorial must be in range 0..20."
        }
    }

    fun verifyPositive(n: Long) {
        require(n >= 0) {
            "Factorial must positive."
        }
    }
}