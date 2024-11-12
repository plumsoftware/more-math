![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Maven Central Version](https://img.shields.io/maven-central/v/io.github.plumsoftware/more-math?style=for-the-badge&logo=kotlin&logoColor=white&logoSize=auto&label=more%20math&labelColor=orange&color=orange)

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
* [Graph](#Graph)
* [Complex numbers](#Complex-numbers)
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

You can ```+```, ```-```, ```*```, ```pow()``` matrix. Also ```equals()``` and ```hashCode``` are available.
```kotlin
val matrix1 = matrixOf<Int> (
  listOf(1, 2),
  listOf(3, 4)
)
val matrix2 = matrixOf<Int> (
  listOf(5, 6),
  listOf(7, 8)
)
val matrix3 = matrix1.pow(2)

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

Times matrix with number
```kotlin
val res = matrix.times(2)
```

To find min or max item in matrix
```kotlin
val min = matrix.minInMatrix()
val max = matrix.maxInMatrix()
```


### Graph
Create a weighted graph
```kotlin
val graph = Graph<VertexType, WeightType>(mode = GraphMode.UNDIRECTED)
```

Where VertexType is the type of the vertex. WeightType is the type of the vertex weight: Int, Double, Long, Float. mode is the type of the graph: UNDIRECTED, DIRECTED.

To create a connection, you need to add vertices:
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

Then create a connection between the vertices
```kotlin
graph.createConnection(from = vertexA, to = vertexB, weight = 2)
```

Get all vertices
```kotlin
val vertices = graph.vertices
```

Get all connections
```kotlin
val vertices = graph.connections
```
Check if a vertex exists
```kotlin
val vertex: Vertex<String>? = graph[someVertex]
```
This will return null if the vertex does not exist in the graph.

Replace a vertex in a graph

```kotlin
val newVertex = Vertex("A")
val oldVertex = Vertex("B") //This vertex is already in the graph
graph.set(oldVertex, newVertex, SetVertexMode.NEW_FROM_TO)
```
This will replace all nodes in all links in the graph and remove the old node. If you want to replace only the start nodes in links or the end nodes, use NEW_FROM or NEW_TO respectively.

To remove all connections use:
```kotlin
graph.removeConnectionsByVertex(someVertex, RemoveVertexMode.TO)
```

This will remove all links where the given end node is present. If you want to remove only the start nodes or both (start and end) from links, use FROM or BOTH respectively.

To get all nodes without links or vice versa all nodes in links
```kotlin
val freeList = graph.getFreeVertices()
val busyList = graph.getBusyVertices()
```


### Complex numbers
Create a complex number
```kotlin
val complex: Complex = complex(-4.0)
```
This will be ```0.0 - 2.0i```

If you need to specify the real part of the number, use
```kotlin
val complex: Complex = MoreMath.complex(3, -4.0)
```
This will be ```3.0 - 2.0i```

T0 find algebraic or geometric form
```kotlin
val algebraic = complex.toAlgebraic()
val geometric = complex.toGeometric()
```

With complex numbers, you can perform ```+```, ```-```, ```*```, ```/```. ```equals()``` and ```hashCode()``` are also available.



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

You can ```+```, ```-```, ```*```, ```/``` vector2. Also ```equals()``` and ```length()``` are available.
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
