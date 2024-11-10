package more.math.graph.parent

import more.math.graph.model.Vertex

abstract class GraphParent {
    fun <V> verify(list: List<Vertex<V>>, from: Vertex<V>, to: Vertex<V>) {
        val from_ = list.find { it.id == from.id }
        val to_ = list.find { it.id == to.id }

        require(from_ != null && to_ != null) {
            "Source or Destination Vertex not found"
        }
    }
}