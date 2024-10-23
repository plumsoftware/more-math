package more.math.graph.model

data class Vertex(
    val name: String,
    val edges: MutableList<Edge> = mutableListOf()
) {
    fun <T : Number> addEdge(destination: Vertex, weight: T) {
        edges.add(Edge(weight, destination))
    }
}