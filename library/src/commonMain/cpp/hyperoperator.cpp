#include "hyperoperator.h"
#include <cmath>

double tetraction(double number, int other) {
    if (other == 0) {
        return 1.0;
    } else {
        return pow(number, tetraction(number, other - 1));
    }
}

unsigned long factorial(int number) {
    unsigned long long result = 1;

    for (int i = 2; i <= number; ++i) {
        result *= i;

        if (result > 9223372036854775807ULL) {
            return -1;
        }
    }

    return result;
}

unsigned long factorial_(long number) {
    unsigned long long result = 1;

    for (int i = 2; i <= number; ++i) {
        result *= i;

        if (result > 9223372036854775807ULL) {
            return -1;
        }
    }

    return result;
}

double average(const int* numbers, size_t length) {
    if (length == 0) {
        return 0.0;
    }

    int sum = 0;
    for (size_t i = 0; i < length; i++) {
        sum += numbers[i];
    }
    return static_cast<double>(sum) / length;
}

double standardDeviation(const double* numbers, size_t length) {
    if (length < 2) {
        return 0.0;
    }

    double sum = 0.0;
    for (size_t i = 0; i < length; i++) {
        sum += numbers[i];
    }

    double avg = sum / length;
    double sumOfSquares = 0.0;
    for (size_t i = 0; i < length; i++) {
        sumOfSquares += (numbers[i] - avg) * (numbers[i] - avg);
    }

    return sqrt(sumOfSquares / (length - 1));
}

int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);
}