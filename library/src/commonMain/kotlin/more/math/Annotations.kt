package more.math

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.FIELD
)
@Retention(AnnotationRetention.RUNTIME)
public annotation class ExperimentalApi public constructor(val reason: String = "Experimental API")

@Target(
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.RUNTIME)
public annotation class InProgress public constructor(val reason: String = "In progress")
