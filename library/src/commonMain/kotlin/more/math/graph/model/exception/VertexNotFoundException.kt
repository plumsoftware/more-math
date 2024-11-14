package more.math.graph.model.exception

class VertexNotFoundException : Exception() {
    override val message: String
        get() = "Vertex not found in graph."
    override val cause: Throwable?
        get() = super.cause
}