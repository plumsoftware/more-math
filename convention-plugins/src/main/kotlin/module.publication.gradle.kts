import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications.withType<MavenPublication> {
        // Stub javadoc.jar artifact
        artifact(tasks.register("${name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            archiveAppendix.set(this@withType.name)
        })

        // Provide artifacts information required by Maven Central
        pom {
            name.set("More math")
            description.set("Это KMP библиотека слегка упрощающая работу с математикой.")
            url.set("https://github.com/plumsoftware/more-math")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("https://t.me/Sl1vka")
                    name.set("Vyacheslav Deych")
                    organization.set("Plumsoftware")
                    organizationUrl.set("https://github.com/plumsoftware")
                }
            }
            scm {
                url.set("https://github.com/plumsoftware/more-math")
                connection.set("scm:git:git://github.com/plumsoftware/more-math")
                developerConnection = "scm:git:ssh://git@github.com:plumsoftware/more-math.git"
            }
        }
    }
}

signing {
    if (project.hasProperty("signing.gnupg.keyName")) {
        useGpgCmd()
        sign(publishing.publications)
    }
}
