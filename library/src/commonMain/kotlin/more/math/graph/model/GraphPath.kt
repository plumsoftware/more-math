package more.math.graph.model

class GraphPath<V, W : Number> constructor(
    vararg val path: Pair<Vertex<V>, W>
)