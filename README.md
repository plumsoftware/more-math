![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

![More Math logo](https://github.com/plumsoftware/more-math/blob/develop-v0.0.1/docs/images/logo.png)

## More math

Мультиплатформенная библиотека Kotlin, добавляющая математические операции с матрицами, векторами, комбинаторикой и многим другим.

## Подключение

Чтобы подключить библиотеку нужно добавить строчки ниже в файл ```build.gradle.kts``` вашего мультиплатформенного модуля
```kotlin
dependencies {
    implementation("ru.plumsoftware:more-math:<version>")
}
```

## Документация на других языках (Documentation)

+ [English](https://github.com/plumsoftware/more-math/blob/develop-v0.0.1/docs/languages/README-en.md)

## Содержание

Эта библиотека предоставляет функциональность для работы с вектором на плоскости, матрицей, комбинаторикой.

* [Факториал](#Факториал)
* [Тетрация](#Тетрация)
* [Остальное](#Другое)
* [Матрица](#Матрица)
* [Вектор на плоскости](#Вектор)
* [Комбинаторика](#Комбинаторика)

## Возможности

### Факториал
Вычисление факториала
```kotlin
val res = MoreMath.factorial(3)
```



### Тетрация
Вычислить тетрацию
```kotlin
val res = MoreMath.tetraction(2.0, 3)
```


### Другое
Чтобы вычислить **наименьшее общее кратное** двух чисел
```kotlin
val res = MoreMath.gcd(13, 17)
```

Вычисление **стандартного отклонения** ряда чисел
```kotlin
val res = MoreMath.standardDeviation(1.0, 2.0, 3.0)
```

**Срднее значение**
```kotlin
val res = MoreMath.average(1, 2, 3)
```


### Матрица
Создать матрицу можно двумя способами
```kotlin
val matrix = matrixOf<Int> (
  listOf(1, 2),
  listOf(3, 4)
)
```
или 
```kotlin
val matrix = Matrix<Int> (
  listOf(1, 2),
  listOf(3, 4)
)
```

Операторы, доступныее для матриц ```+```, ```-```, ```-```. Также можно использовать ```equals()``` и ```hashCode```.
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

Вычислить определитель матрицы
```kotlin
val det = matrix.determinant()
```

Транспонировать матрицу
```kotlin
val transposedMatrix = matrix.transpose()
```



### Вектор

#### Вектор на плоскости
Создание вектора аналогично созданию матрицы
```kotlin
val vector2 = vector2Of(1 , 2)
```
или
```kotlin
val vector2 = Vector2(1 , 2)
```

С векторами на плоскости доступны следующие операторы ```+```, ```-```, ```-```, ```/```. Также Вы можете использовать ```equals()``` и ```length()```.
```kotlin
val vector1 = vector2Of(1, 2)
val vector2 = vector2Of(3, 4)

val plus = vector1 + vector2
val minus = vector1 - vector2
val times = vector1 * vector2
val div = vector1 / vector2
val length = vector1.length()
```



### Комбинаторика

Комбинации из 5 элементов по 2 элемента
```kotlin
val res = MoreMath.combinations(5, 2)
```

Размещения
```kotlin
val res = MoreMath.placements(5, 2)
```

Биноменальный коэффициент
```kotlin
val res = MoreMath.binomialCoefficient(5, 2)
```
