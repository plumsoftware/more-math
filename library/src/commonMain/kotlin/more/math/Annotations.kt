package more.math

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.FIELD
)
@Retention(AnnotationRetention.RUNTIME)
public annotation class ExperimentalApi public constructor(val reason: String = "Experimental API")
