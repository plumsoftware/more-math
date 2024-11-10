package more.math.graph.model

data class Vertex <V>(
    val id: V,
    val edges: MutableList<Edge<V>> = mutableListOf()
) {
    fun <T : Number> addEdge(destination: Vertex<V>, weight: T): Edge<V> {
        // Проверяем, не существует ли уже ребро с этой вершиной
        if (edges.any { it.destination.id == destination.id }) {
            // Ребро уже существует, можно выбросить исключение или игнорировать
            return edges.find { it.destination.id == destination.id }!!
        }

        val edge = Edge(weight, destination)
        edges.add(edge)
        return edge
    }
}