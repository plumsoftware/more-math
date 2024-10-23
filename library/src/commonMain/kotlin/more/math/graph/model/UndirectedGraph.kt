package more.math.graph.model

import more.math.graph.parent.GraphExperimentalApi
import more.math.graph.parent.GraphParent

@GraphExperimentalApi(reason = "Experimental API")
class UndirectedGraph : GraphParent() {
    val vertices: MutableList<Vertex> = mutableListOf()

    fun addVertex(id: String) {
        vertices.add(Vertex(id))
    }

    fun get(id: String) : Vertex? {
        return vertices.find { it.name == id }
    }

    fun addEdge(from: String, to: String, weight: Int) {
        val fromVertex = vertices.find { it.name == from }
        val toVertex = vertices.find { it.name == to }
        verify(vertices, from, to)
        fromVertex!!
        toVertex!!
        fromVertex.addEdge(toVertex, weight)
    }
}
