package more.math.graph.model

import more.math.ExperimentalApi
import more.math.graph.parent.GraphParent

@ExperimentalApi
public class Graph<V, W : Number>
public constructor(mode: GraphMode = GraphMode.UNDIRECTED) : GraphParent() {
    val vertices: MutableList<Vertex<V>> = mutableListOf()
    val edges: MutableList<Edge<V>> = mutableListOf()
    val connections: MutableList<Connection<V, W>> = mutableListOf()

    public fun addVertex(vertex: Vertex<V>) {
        vertices.add(vertex)
    }

    public operator fun get(vertex: Vertex<V>): Vertex<V>? {
        return vertices.find { it.id == vertex.id }
    }

    fun addEdge(from: Vertex<V>, to: Vertex<V>, weight: W) {
        val fromVertex = vertices.find { it.id == from.id }
        val toVertex = vertices.find { it.id == to.id }
        verify(vertices, from, to)

        fromVertex!!
        toVertex!!

        val edge1 = fromVertex.addEdge(toVertex, weight)
        edges.add(edge1)

        connections.add(Connection(from = fromVertex, to = toVertex, weight = weight))
    }
}
