package more.math.vector.model

@Suppress("UNCHECKED_CAST")
data class Vector2<T : Number>(val x: T, val y: T) {

    operator fun plus(other: Vector2<T>): Vector2<T> {
        return Vector2(
            x = when (x) {
                is Double -> (x.toDouble() + other.x.toDouble()) as T
                is Float -> (x.toFloat() + other.x.toFloat()) as T
                is Int -> (x.toInt() + other.x.toInt()) as T
                is Long -> (x.toLong() + other.x.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            },
            y = when (y) {
                is Double -> (y.toDouble() + other.y.toDouble()) as T
                is Float -> (y.toFloat() + other.y.toFloat()) as T
                is Int -> (y.toInt() + other.y.toInt()) as T
                is Long -> (y.toLong() + other.y.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            }
        )
    }

    operator fun minus(other: Vector2<T>): Vector2<T> {
        return Vector2(
            x = when (x) {
                is Double -> (x.toDouble() - other.x.toDouble()) as T
                is Float -> (x.toFloat() - other.x.toFloat()) as T
                is Int -> (x.toInt() - other.x.toInt()) as T
                is Long -> (x.toLong() - other.x.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            },
            y = when (y) {
                is Double -> (y.toDouble() - other.y.toDouble()) as T
                is Float -> (y.toFloat() - other.y.toFloat()) as T
                is Int -> (y.toInt() - other.y.toInt()) as T
                is Long -> (y.toLong() - other.y.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            }
        )
    }

    operator fun times(other: Vector2<T>): Vector2<T> {
        return Vector2(
            x = when (x) {
                is Double -> (x.toDouble() * other.x.toDouble()) as T
                is Float -> (x.toFloat() * other.x.toFloat()) as T
                is Int -> (x.toInt() * other.x.toInt()) as T
                is Long -> (x.toLong() * other.x.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            },
            y = when (y) {
                is Double -> (y.toDouble() * other.y.toDouble()) as T
                is Float -> (y.toFloat() * other.y.toFloat()) as T
                is Int -> (y.toInt() * other.y.toInt()) as T
                is Long -> (y.toLong() * other.y.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            }
        )
    }

    operator fun div(other: Vector2<T>): Vector2<T> {
        return Vector2(
            x = when (x) {
                is Double -> (x.toDouble() / other.x.toDouble()) as T
                is Float -> (x.toFloat() / other.x.toFloat()) as T
                is Int -> (x.toInt() / other.x.toInt()) as T
                is Long -> (x.toLong() / other.x.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            },
            y = when (y) {
                is Double -> (y.toDouble() / other.y.toDouble()) as T
                is Float -> (y.toFloat() / other.y.toFloat()) as T
                is Int -> (y.toInt() / other.y.toInt()) as T
                is Long -> (y.toLong() / other.y.toLong()) as T
                else -> throw IllegalArgumentException("Unsupported type")
            }
        )
    }

    override fun toString(): String {
        return "[x: $x; y: $y]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Vector2<*>) return false
        return (x.toDouble() == other.x.toDouble() && y.toDouble() == other.y.toDouble())
    }

    // Переопределение hashCode
    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }
}