![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

![More Math logo](https://github.com/plumsoftware/more-math/blob/develop-v0.0.1/docs/images/logo.png)

# More math
Kotlin multiplatform library adding mathematical operations with matrices, vectors, combinatorics and much more.

# Overview
This library provides functionality to work with Vector on a plane, Matrix, Combinatorics.

* [Factorial](#Factorial)
* [Matrix](#Matrix)

### Factorial
Use factorial like this
```kotlin
val res = MoreMath.factorial(3)
```

### Matrix
To create matrix just write:
```kotlin
val matrix = matrixOf<Int> (
  listOf(1, 2),
  listOf(3, 4)
)
```
or 
```kotlin
val matrix = Matrix<Int> (
  listOf(1, 2),
  listOf(3, 4)
)
```

You can ```+```, ```-```, ```-``` matrix. Also ```equals()``` and ```hashCode``` are available.
```kotlin
val matrix1 = matrixOf<Int> (
  listOf(1, 2),
  listOf(3, 4)
)
val matrix2 = matrixOf<Int> (
  listOf(5, 6),
  listOf(7, 8)
)

val plus = matrix1 + matrix2
val times = matrix1 * matrix2
val minus = matrix1 - matrix2
```

Get a determinant
```kotlin
val det = matrix.determinant()
```

Transpose matrix
```kotlin
val transposedMatrix = matrix.transpose()
```
