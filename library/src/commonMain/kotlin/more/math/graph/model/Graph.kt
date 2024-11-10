package more.math.graph.model

import more.math.ExperimentalApi
import more.math.InProgress
import more.math.graph.parent.GraphParent

@ExperimentalApi
public class Graph<V, W : Number>
public constructor(@InProgress val mode: GraphMode = GraphMode.UNDIRECTED) : GraphParent() {
    val vertices: MutableList<Vertex<V>> = mutableListOf()
    val connections: MutableList<Connection<V, W>> = mutableListOf()

    public fun addVertex(vertex: Vertex<V>) {
        vertices.add(vertex)
    }

    public operator fun get(vertex: Vertex<V>): Vertex<V>? {
        return vertices.find { it.id == vertex.id }
    }

    public operator fun set(oldVertex: Vertex<V>, newVertex: Vertex<V>, setVertexMode: SetVertexMode) {
        when (setVertexMode) {
            SetVertexMode.NEW_FROM -> {
                this.addVertex(vertex = newVertex)
                connections.forEachIndexed { index, item ->
                    if (item.from.id == oldVertex.id) {
                        connections[index] = connections[index].copy(from = newVertex)
                    }
                }
            }
            SetVertexMode.NEW_TO -> {
                this.addVertex(vertex = newVertex)
                connections.forEachIndexed { index, item ->
                    if (item.to.id == oldVertex.id) {
                        connections[index] = connections[index].copy(to = newVertex)
                    }
                }
            }
            SetVertexMode.NEW_FROM_TO -> {
                this.addVertex(vertex = newVertex)
                connections.forEachIndexed { index, item ->
                    if (item.to.id == oldVertex.id) {
                        connections[index] = connections[index].copy(to = newVertex)
                    } else if (item.from.id == oldVertex.id) {
                        connections[index] = connections[index].copy(from = newVertex)
                    }
                }
            }
        }
    }

    fun createConnection(from: Vertex<V>, to: Vertex<V>, weight: W) {
        val fromVertex = vertices.find { it.id == from.id }
        val toVertex = vertices.find { it.id == to.id }
        verify(vertices, from, to)

        fromVertex!!
        toVertex!!

        connections.add(Connection(from = fromVertex, to = toVertex, weight = weight))
    }
}
