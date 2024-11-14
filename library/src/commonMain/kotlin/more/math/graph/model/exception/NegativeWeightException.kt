package more.math.graph.model.exception

class NegativeWeightException : Exception() {
    override val message: String
        get() = "Negative weights in graph."
}