![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

![More Math logo](https://github.com/plumsoftware/more-math/blob/develop-v0.0.1/docs/images/logo.png)

# More math

Kotlin multiplatform library adding mathematical operations with matrices, vectors, combinatorics and much more.

## Add

To connect the library, you need to add the lines below to the ```build.gradle.kts``` file of your multiplatform module
```kotlin
dependencies {
    implementation("io.github.plumsoftware:more-math:<version>")
}
```

# Overview

This library provides functionality to work with Vector on a plane, Matrix, Combinatorics.

* [Factorial](#Factorial)
* [Tetraction](#Tetraction)
* [Other](#Other)
* [Matrix](#Matrix)
* [Vector on plane](#Vector)
* [Combinatorics](#Combinatorics)

## Usage

### Factorial
Use factorial like this
```kotlin
val res = MoreMath.factorial(3)
```



### Tetraction
To get tetraction use this
```kotlin
val res = MoreMath.tetraction(2.0, 3)
```


### Other
To get **least common multiple**
```kotlin
val res = MoreMath.gcd(13, 17)
```

Get a **standart deviation**
```kotlin
val res = MoreMath.standardDeviation(1.0, 2.0, 3.0)
```

Get a **average**
```kotlin
val res = MoreMath.average(1, 2, 3)
```


### Matrix
To create matrix just write
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



### Vector

#### On plane
To create vector
```kotlin
val vector2 = vector2Of(1 , 2)
```
or
```kotlin
val vector2 = Vector2(1 , 2)
```

You can ```+```, ```-```, ```-```, ```/``` vector2. Also ```equals()``` and ```length()``` are available.
```kotlin
val vector1 = vector2Of(1, 2)
val vector2 = vector2Of(3, 4)

val plus = vector1 + vector2
val minus = vector1 - vector2
val times = vector1 * vector2
val div = vector1 / vector2
val length = vector1.length()
```



### Combinatorics

Combinations of 5 elements by 2 elements 
```kotlin
val res = MoreMath.combinations(5, 2)
```

Placements
```kotlin
val res = MoreMath.placements(5, 2)
```

Binomial coefficient
```kotlin
val res = MoreMath.binomialCoefficient(5, 2)
```
