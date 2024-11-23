package more.math.graph.model

import more.math.ExperimentalApi
import more.math.graph.model.exception.NegativeWeightException
import more.math.graph.model.exception.VertexNotFoundException
import more.math.graph.model.mode.GraphMode
import more.math.graph.model.mode.RemoveVertexMode
import more.math.graph.model.mode.SetVertexMode
import more.math.graph.parent.GraphParent

@ExperimentalApi
public class Graph<V, W : Number>
public constructor(val mode: GraphMode = GraphMode.UNDIRECTED) : GraphParent() {
    val vertices: MutableList<Vertex<V>> = mutableListOf()
    val connections: MutableList<Connection<V, W>> = mutableListOf()
    private var hasNegativeWeight: Boolean = false

    public fun addVertex(vertex: Vertex<V>) {
        vertices.add(vertex)
    }

    public operator fun get(vertex: Vertex<V>): Vertex<V>? {
        return vertices.find { it.id == vertex.id }
    }

    public operator fun set(
        oldVertex: Vertex<V>,
        newVertex: Vertex<V>,
        setVertexMode: SetVertexMode
    ) {
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

    public fun clearAllConnection() {
        connections.clear()
    }

    public fun clearAllVertices() {
        vertices.clear()
    }

    public fun removeConnectionsByVertex(vertex: Vertex<V>, removeVertexMode: RemoveVertexMode) {
        when (removeVertexMode) {
            RemoveVertexMode.TO -> {
                connections.removeAll { it.to.id == vertex.id }
            }

            RemoveVertexMode.FROM -> {
                connections.removeAll { it.from.id == vertex.id }
            }

            RemoveVertexMode.BOTH -> {
                connections.removeAll { it.from.id == vertex.id || it.to.id == vertex.id }
            }
        }
    }

    public fun getFreeVertices(): List<Vertex<V>> {
        val free = mutableListOf<Vertex<V>>()
        vertices.forEach { vertex ->
            connections.forEach { connection ->
                if (!connection.hasVertex(vertex))
                    free.add(vertex)
            }
        }
        return free.toList()
    }

    public fun getBusyVertices(): List<Vertex<V>> {
        val free = mutableListOf<Vertex<V>>()
        vertices.forEach { vertex ->
            connections.forEach { connection ->
                if (connection.hasVertex(vertex))
                    free.add(vertex)
            }
        }
        return free.toList()
    }

    public fun createConnection(from: Vertex<V>, to: Vertex<V>, weight: W): Connection<V, W> {
        val fromVertex = vertices.find { it.id == from.id }
        val toVertex = vertices.find { it.id == to.id }
        verify(vertices, from, to)

        hasNegativeWeight = when (weight) {
            is Int -> weight < 0
            is Long -> weight < 0
            is Double -> weight < 0
            is Float -> weight < 0
            else -> false
        }

        fromVertex!!
        toVertex!!

        val connection = Connection(from = fromVertex, to = toVertex, weight = weight)
        connections.add(connection)
        return connection
    }

    public fun minPath(from: Vertex<V>, to: Vertex<V>) : GraphPath<V, Double> {
        if (from !in vertices || to !in vertices) {
            throw VertexNotFoundException()
        }

        if (hasNegativeWeight) throw NegativeWeightException()

        val distances = mutableMapOf<Vertex<V>, Double>()
        val previousVertices = mutableMapOf<Vertex<V>, Vertex<V>?>()
        val queue = vertices.toMutableList()

        vertices.forEach { vertex ->
            distances[vertex] = Double.MAX_VALUE
            previousVertices[vertex] = null
        }
        distances[from] = 0.0

        while (queue.isNotEmpty()) {
            val currentVertex = queue.minByOrNull { distances[it] ?: Double.MAX_VALUE }!!
            queue.remove(currentVertex)

            if (currentVertex == to) break

            connections.filter { it.from == currentVertex || (mode == GraphMode.UNDIRECTED && it.to == currentVertex) }.forEach { connection ->
                val neighbor = if (connection.from == currentVertex) connection.to else connection.from
                val newDist = distances[currentVertex]!! + connection.weight.toDouble()

                if (newDist < distances[neighbor]!!) {
                    distances[neighbor] = newDist
                    previousVertices[neighbor] = currentVertex
                }
            }
        }

        val path = mutableListOf<Pair<Vertex<V>, Double>>()
        var current: Vertex<V>? = to
        while (current != null) {
            val weight = distances[current]
            path.add(Pair(current, weight!!))
            current = previousVertices[current]
        }

        return GraphPath(*path.reversed().toTypedArray())
    }
}
