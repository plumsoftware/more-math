package more.math.factorial.implementation

import more.math.factorial.parent.FactorialParent
import more.math.factorial.repository.RecursiveFactorialParentCalculatorRepository

class RecursiveFactorialParentCalculator : FactorialParent(), RecursiveFactorialParentCalculatorRepository {
    override fun calculate(n: Int): Long {
        validateForNegative(n)
        return if (n == 0) 1 else n * calculate(n - 1)
    }
}