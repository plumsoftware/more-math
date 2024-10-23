package more.math.graph.model

import kotlin.test.Test
import kotlin.test.assertFails

class GraphTest {

    @Test
    fun testGraphFakeVertex() {
        val undirectedGraph = UndirectedGraph()

        undirectedGraph.addVertex("A")
        undirectedGraph.addVertex("B")

        undirectedGraph.addEdge("A", "B", weight = 2)
        assertFails {
            undirectedGraph.addEdge("A", "C", weight = 3)
        }
    }
}