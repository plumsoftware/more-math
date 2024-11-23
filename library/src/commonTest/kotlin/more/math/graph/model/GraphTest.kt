package more.math.graph.model

import more.math.graph.model.mode.GraphMode
import more.math.graph.model.mode.SetVertexMode
import more.math.matrix.model.Matrix
import more.math.matrixOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNull

class GraphTest {

    @Test
    fun testGraphFakeVertex() {
        val graph = Graph<Matrix<Int>, Int>()

        val m1 = matrixOf(
            mutableListOf(1, 2),
            mutableListOf(3, 4)
        )
        val m2 = matrixOf(
            mutableListOf(5, 6),
            mutableListOf(7, 8)
        )
        val m3 = matrixOf<Int>(mutableListOf(0), mutableListOf(0))

        graph.addVertex(
            Vertex(
                id = m1
            )
        )
        graph.addVertex(
            Vertex(
                id = m2
            )
        )

        graph.createConnection(from = Vertex(id = m1), to = Vertex(id = m2), weight = 2)
        assertFails {
            graph.createConnection(Vertex(id = m1), Vertex(id = m3), weight = 3)
        }

        val vertex = graph[Vertex(id = m1)]
        assertEquals(
            expected = Vertex(id = m1),
            actual = vertex
        )
        assertEquals(expected = 2, actual = graph.vertices.size)
    }

    @Test
    fun get() {
        val graph = Graph<String, Int>()

        graph.addVertex(Vertex(id = "A"))
        graph.addVertex(Vertex(id = "B"))

        graph.createConnection(from = Vertex(id = "A"), to = Vertex(id = "B"), weight = 2)

        val vertex = graph[Vertex(id = "A")]
        assertEquals(
            expected = Vertex(id = "A"),
            actual = vertex
        )
        assertNull(graph[Vertex(id = "C")])
    }

    @Test
    fun sizes() {
        val graph = Graph<String, Int>()

        graph.addVertex(Vertex(id = "A"))
        graph.addVertex(Vertex(id = "B"))

        graph.createConnection(from = Vertex(id = "A"), to = Vertex(id = "B"), weight = 2)

        assertEquals(expected = 2, actual = graph.vertices.size)
        assertEquals(expected = 1, actual = graph.connections.size)
    }

    @Test
    fun testConnections() {
        val graph = Graph<String, Int>()

        graph.addVertex(Vertex(id = "A"))
        graph.addVertex(Vertex(id = "B"))

        graph.createConnection(from = Vertex(id = "A"), to = Vertex(id = "B"), weight = 2)

        assertEquals(expected = 1, actual = graph.connections.size)
    }

    @Test
    fun testSetVertexMode() {
        val graph = Graph<String, Int>()

        val vertexA = Vertex(id = "A")
        val vertexB = Vertex(id = "B")
        val vertexC = Vertex(id = "C")
        val vertexD = Vertex(id = "D")

        graph.addVertex(vertexA)
        graph.addVertex(vertexB)
        graph.addVertex(vertexD)

        graph.createConnection(from = vertexA, to = vertexB, weight = 2)
        graph.createConnection(from = vertexA, to = vertexD, weight = 5)

        graph.set(oldVertex = vertexA, newVertex = vertexC, setVertexMode = SetVertexMode.NEW_FROM)

        assertEquals(expected = vertexC, actual = graph[vertexC])
        assertEquals(expected = 2, actual = graph.connections.size)

        graph.set(oldVertex = vertexC, newVertex = vertexA, setVertexMode = SetVertexMode.NEW_TO)

        assertEquals(expected = vertexA, actual = graph[vertexA])
        assertEquals(expected = 2, actual = graph.connections.size)

        graph.createConnection(from = vertexD, to = vertexA, weight = 5)
        graph.createConnection(from = vertexA, to = vertexD, weight = 10)

        graph.set(
            oldVertex = vertexA,
            newVertex = vertexC,
            setVertexMode = SetVertexMode.NEW_FROM_TO
        )

        assertEquals(expected = vertexC, actual = graph[vertexC])
        assertEquals(expected = 4, actual = graph.connections.size)
    }

    @Test
    fun freeVertices() {
        val graph = Graph<String, Int>()

        val vertexA = Vertex(id = "A")
        val vertexB = Vertex(id = "B")
        val vertexC = Vertex(id = "C")
        val vertexD = Vertex(id = "D")

        graph.addVertex(vertexA)
        graph.addVertex(vertexB)
        graph.addVertex(vertexC)
        graph.addVertex(vertexD)

        graph.createConnection(from = vertexA, to = vertexB, weight = 2)
        assertEquals(expected = 2, graph.getFreeVertices().size)
        assertEquals(expected = 2, graph.getBusyVertices().size)
    }

    @Test
    fun testMinPathFunUndirectedGraph() {
        val graph = Graph<String, Int>(mode = GraphMode.UNDIRECTED)

        val vertexA = Vertex(id = "A")
        val vertexB = Vertex(id = "B")
        val vertexC = Vertex(id = "C")
        val vertexD = Vertex(id = "D")
        val vertexE = Vertex(id = "E")

        graph.addVertex(vertexA)
        graph.addVertex(vertexB)
        graph.addVertex(vertexC)
        graph.addVertex(vertexD)
        graph.addVertex(vertexE)

        graph.createConnection(from = vertexA, to = vertexB, weight = 2)
        graph.createConnection(from = vertexB, to = vertexC, weight = 5)
        graph.createConnection(from = vertexC, to = vertexD, weight = 6)
        graph.createConnection(from = vertexA, to = vertexD, weight = 17)

        val minPath1: GraphPath<String, Double> = graph.minPath(from = vertexA, to = vertexD)
        val expected1 = GraphPath(
            Pair(vertexA, 0.0),
            Pair(vertexB, 2.0),
            Pair(vertexC, 7.0),
            Pair(vertexD, 13.0),
        )
        assertEquals(expected = expected1.path[2], actual = minPath1.path[2])

        graph.createConnection(from = vertexB, to = vertexE, weight = 1)
        graph.createConnection(from = vertexE, to = vertexD, weight = 3)

        val minPath2: GraphPath<String, Double> = graph.minPath(from = vertexA, to = vertexD)
        val expected2 = GraphPath(
            Pair(vertexA, 0.0),
            Pair(vertexB, 2.0),
            Pair(vertexE, 3.0),
            Pair(vertexD, 6.0),
        )
        assertEquals(expected = expected2.path[2].second, actual = minPath2.path[2].second)

        graph.createConnection(from = vertexE, to = vertexA, weight = -3)
        assertFails {
            graph.minPath(from = vertexA, to = vertexD)
        }
    }
}