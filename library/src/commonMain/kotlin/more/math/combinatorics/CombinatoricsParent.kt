package more.math.combinatorics

class CombinatoricsParent {
    fun verify(n: Int, k: Int) {
        require(n >= 0 && k >= 0 && k <= n) { "Number n must be >= 0, k must be >= 0 and k must be <= n." }
    }
}