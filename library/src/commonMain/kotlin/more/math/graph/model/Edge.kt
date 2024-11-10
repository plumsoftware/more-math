package more.math.graph.model

data class Edge <V>(
    val weight: Number,
    val destination: Vertex<V>
)
