package more.math.graph.parent

import more.math.graph.model.Vertex

abstract class GraphParent {
    fun verify(list: List<Vertex>, from: String, to: String) {
        val from_ = list.find { it.name == from }
        val to_ = list.find { it.name == to }

        require(from_ != null && to_ != null) {
            "Source or Destination Vertex not found"
        }
    }
}