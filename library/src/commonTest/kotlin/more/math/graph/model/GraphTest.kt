package more.math.graph.model

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
            listOf(1, 2),
            listOf(3, 4)
        )
        val m2 = matrixOf(
            listOf(5, 6),
            listOf(7, 8)
        )
        val m3 = matrixOf<Int>()

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

        graph.set(oldVertex = vertexA, newVertex = vertexC, setVertexMode = SetVertexMode.NEW_FROM_TO)

        assertEquals(expected = vertexC, actual = graph[vertexC])
        assertEquals(expected = 4, actual = graph.connections.size)
    }
}