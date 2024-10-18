package more.math.factorial.repository

interface RecursiveFactorialParentCalculatorRepository {
    fun calculate(n: Int): Long
}