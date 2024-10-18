package more.math.tetraction

class TetractionParent {
    fun verify(number: Double, other: Int) {
        require(number >= 0 && other >= 0) {
            "Both arguments must be more than zero"
        }
    }
}