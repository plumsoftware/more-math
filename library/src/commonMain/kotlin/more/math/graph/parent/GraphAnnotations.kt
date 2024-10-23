package more.math.graph.parent

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
public annotation class GraphExperimentalApi public constructor(val reason: String)
