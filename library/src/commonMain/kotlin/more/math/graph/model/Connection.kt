package more.math.graph.model

data class Connection<V, W : Number>(
    val from: Vertex<V>,
    val to: Vertex<V>,
    val weight: W
)
