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
                    name.set("Slava")
                    organization.set("Plumsoftware")
                    organizationUrl.set("https://github.com/plumsoftware/more-math")
                }
            }
            scm {
                url.set("https://github.com/plumsoftware/more-math")
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
