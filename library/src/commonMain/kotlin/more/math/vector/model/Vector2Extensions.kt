package more.math.vector.model

public fun Vector2<Double>.length(): Double {
    return kotlin.math.sqrt(this.x * this.x + this.y * this.y)
}