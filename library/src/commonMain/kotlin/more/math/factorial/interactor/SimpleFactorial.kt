package more.math.factorial.interactor

import more.math.factorial.implementation.RecursiveFactorialParentCalculator

class SimpleFactorial {
    private val recursiveFactorialParentCalculator: RecursiveFactorialParentCalculator =
        RecursiveFactorialParentCalculator()

    fun recursive(n: Int): Long {
        return recursiveFactorialParentCalculator.calculate(n = n)
    }
}