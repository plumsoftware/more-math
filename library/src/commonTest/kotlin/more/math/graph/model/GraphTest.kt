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

        graph.addEdge(from = Vertex(id = m1), to = Vertex(id = m2), weight = 2)
        assertFails {
            graph.addEdge(Vertex(id = m1), Vertex(id = m3), weight = 3)
        }

        val vertex = graph[Vertex(id = m1)]
        assertEquals(
            expected = Vertex(
                id = m1,
                edges = mutableListOf(
                    Edge(
                        weight = 2,
                        destination = Vertex(id = m2, edges = mutableListOf())
                    )
                )
            ),
            actual = vertex
        )
        assertEquals(expected = 2, actual = graph.vertices.size)
    }

    @Test
    fun get() {
        val graph = Graph<String, Int>()

        graph.addVertex(Vertex(id = "A"))
        graph.addVertex(Vertex(id = "B"))

        graph.addEdge(from = Vertex(id = "A"), to = Vertex(id = "B"), weight = 2)

        val vertex = graph[Vertex(id = "A")]
        assertEquals(
            expected = Vertex(
                id = "A",
                edges = mutableListOf(
                    Edge(
                        weight = 2,
                        destination = Vertex(id = "B", edges = mutableListOf())
                    )
                )
            ),
            actual = vertex
        )
        assertNull(graph[Vertex(id = "C")])
    }

    @Test
    fun sizes() {
        val graph = Graph<String, Int>()

        graph.addVertex(Vertex(id = "A"))
        graph.addVertex(Vertex(id = "B"))

        graph.addEdge(from = Vertex(id = "A"), to = Vertex(id = "B"), weight = 2)

        assertEquals(expected = 2, actual = graph.vertices.size)
        assertEquals(expected = 1, actual = graph.edges.size)
    }

    @Test
    fun testConnections() {
        val graph = Graph<String, Int>()

        graph.addVertex(Vertex(id = "A"))
        graph.addVertex(Vertex(id = "B"))

        graph.addEdge(from = Vertex(id = "A"), to = Vertex(id = "B"), weight = 2)

        assertEquals(expected = 1, actual = graph.connections.size)
    }
}