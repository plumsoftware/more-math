package more.math.graph.model

data class Connection<V, W : Number>(
    val from: Vertex<V>,
    val to: Vertex<V>,
    val weight: W
) {
    fun hasVertex(vertex: Vertex<V>): Boolean {
        return from.id == vertex.id || to.id == vertex.id
    }
}
