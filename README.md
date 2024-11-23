![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Maven Central Version](https://img.shields.io/maven-central/v/io.github.plumsoftware/more-math?style=for-the-badge&logo=kotlin&logoColor=white&logoSize=auto&label=more%20math&labelColor=orange&color=orange)

![More Math logo](https://github.com/plumsoftware/more-math/blob/develop-v0.0.1/docs/images/logo.png)

## More math

Мультиплатформенная библиотека Kotlin, добавляющая математические операции с матрицами, векторами, комбинаторикой и многим другим.
![Telegram](https://github.com/plumsoftware/more-math/blob/develop-v0.0.1/docs/images/telegram.svg)  Эмоджи для телеграм доступны по ссылке https://t.me/addemoji/RkIQSnNfAAA

## Подключение

Чтобы подключить библиотеку нужно добавить строчки ниже в файл ```build.gradle.kts``` вашего мультиплатформенного модуля
```kotlin
dependencies {
    implementation("io.github.plumsoftware:more-math:<version>")
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
* [Граф](#Граф)
* [Комплексные числа](#Комплексные-числа)
* [Вектор на плоскости](#Вектор)
* [Комбинаторика](#Комбинаторика)

## Возможности

### Факториал
Вычисление факториала для числа до 21
```kotlin
val res = MoreMath.factorial(3)
```

Вычислить факторил для числа более 20
```kotlin
val res = MoreMath.bigFactorial(22L)
```



### Тетрация
Вычислить тетрацию
```kotlin
val res = MoreMath.tetraction(2.0, 3)
```

Если, число в тетрации большое, то используйте
```kotlin
val res = MoreMath.bigTetraction(2.0, 40)
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

**Среднее значение**
```kotlin
val res = MoreMath.average(1, 2, 3)
```

Узнать, положительное или отрицательное число

```kotlin
4.isPositive
(-4).isNegative
```


### Матрица
Создать матрицу можно тремя способами
```kotlin
val matrix = matrixOf<Int> (
    mutableListOf(1, 2), 
    mutableListOf(3, 4)
)
```
или 
```kotlin
val matrix = Matrix<Int> (
    mutableListOf(1, 2),
    mutableListOf(3, 4)
)
```
или
```kotlin
val matrix = Matrix<Int>(size = MatrixSize(row = 3, column = 4))
```
Последее создаст пустую матрицу. Также можно получить размер матрицы
```kotlin
val size = matrix.size
```

Операторы, доступные для матриц ```+```, ```-```, ```*```, ```pow()```, ```>```, ```>=``` и подобные. Для сравнения контента матриц, используйте метод ```equals()```.
```kotlin
val matrix1 = matrixOf<Int> (
    mutableListOf(1, 2),
    mutableListOf(3, 4)
)
val matrix2 = matrixOf<Int> (
    mutableListOf(5, 6),
    mutableListOf(7, 8)
)
val matrix3 = matrix1.pow(2)

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

Умножить матрицу на число
```kotlin
val res = matrix.times(2)
```

Найти минимальный или максимальный элемент в матрице.
Если Ваша матрица состоит из ```Double```, ```Long```, ```Float``` или ```Int```, то воспользуйтесь кодом ниже
```kotlin
val min = matrix.minInMatrix()
val max = matrix.maxInMatrix()
```
или
```kotlin
val min = matrix.minInMatrixBy { it }
val max = matrix.maxInMatrixBy { it }
```

### Граф
Создать взвешенный граф
```kotlin
val graph = Graph<VertexType, WeightType>(mode = GraphMode.UNDIRECTED)
```
Где ```VertexType``` - это тип вершины. 
```WeightType``` - это тип веса вершины: ```Int```, ```Double```, ```Long```, ```Float```.
```mode``` - это тип графа: ```UNDIRECTED```, ```DIRECTED```.

Для создания связи нужно добавить вершины:
```kotlin
val graph = Graph<String, Int>()

val vertexA = Vertex(id = "A")
val vertexB = Vertex(id = "B")
val vertexC = Vertex(id = "C")
val vertexD = Vertex(id = "D")

graph.addVertex(vertexA)
graph.addVertex(vertexB)
graph.addVertex(vertexC)
graph.addVertex(vertexD)
```

Затем создайте связь между вершинами
```kotlin
graph.createConnection(from = vertexA, to = vertexB, weight = 2)
```

Получить минимальный путь в графе от и до вершины
```kotlin
val minPath: GraphPath<String, Double> = graph.minPath(from = Vertex("A"), to = Vertex("B"))
```
В результате будет возвращен ```GraphPath```, который содержит пары - вершины и суммарный путь до следующей вершины.

Получить все вершины
```kotlin
val vertices = graph.vertices
```

Получить все связи
```kotlin
val vertices = graph.connections
```

Узнать, есть ли вершина
```kotlin
val vertex: Vertex<String>? = graph[someVertex]
```
Это вернёт ```null```, если вершины в графе нет.

Заменить вершину в графе
```kotlin
val newVertex = Vertex("A")
val oldVertex = Vertex("B") //Эта вершина уже есть в графе
graph.set(oldVertex, newVertex, SetVertexMode.NEW_FROM_TO)
```
Это заменит все вершины во всех связях в графе и удалит старую вершину. 
Если вы хотите заменить только начальные вершины в связях или конечные, то используйте ```NEW_FROM``` или ```NEW_TO``` соответственно.

Для удаления всех связей используйте:
```kotlin
graph.removeConnectionsByVertex(someVertex, RemoveVertexMode.TO)
```
Это удалит все связи, где есть переданная конечная вершина.
Если нужно удалить только начальные вершины или обе (начальную и конечную) из связей, то используйте ```FROM``` или ```BOTH``` соответственно.

Для получения всех вершин без связей или наоборот всех вершин в связях
```kotlin
val freeList = graph.getFreeVertices()
val busyList = graph.getBusyVertices()
```


### Комплексные числа
Создать комплексное число
```kotlin
val complex: Complex = complex(-4.0)
```
В результате будет ```0.0 - 2.0i```

Если Вам нужно указать реальную часть числа, то воспользуйтесь
```kotlin
val complex: Complex = complex(3, -4.0)
```
В результате будет ```3.0 - 2.0i```

Получить алгебраическую или геометрическую форму можно таким образом
```kotlin
val algebraic = complex.toAlgebraic()
val geometric = complex.toGeometric()
```

С комплексными числами можно выполнять ```+```, ```-```, ```*```, ```/```. Также доступны ```equals()``` и ```hashCode()```.



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

С векторами на плоскости доступны следующие операторы ```+```, ```-```, ```*```, ```/```. Также Вы можете использовать ```equals()``` и ```length()```.
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
