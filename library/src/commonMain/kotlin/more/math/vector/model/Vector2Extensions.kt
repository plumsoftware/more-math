package more.math.vector.model

fun Vector2<Double>.length(): Double {
    return kotlin.math.sqrt(this.x * this.x + this.y * this.y)
}