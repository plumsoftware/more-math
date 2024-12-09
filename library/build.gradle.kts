import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.ByteArrayOutputStream

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }



        task("assemble_cpp") {
            dependsOn(tasks.getByPath("assemble"))

            val out = ByteArrayOutputStream()
            doLast {
                exec {
                    mkdir("$project.buildDir")
                    workingDir("$project.buildDir")
                    commandLine("cmake", "$project.projectDir")
                    standardOutput = out
                }
                exec {
                    workingDir("$project.buildDir")
                    commandLine("make")
                    standardOutput = out
                }
                logger.info(out.toString())
            }
        }
    }

    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    linuxX64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        val commonMain by getting {
            dependencies {}
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "more.math"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    externalNativeBuild {
        cmake {
            path("src/commonMain/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    dependencies {
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
    }
}

mavenPublishing {

    group = "io.github.plumsoftware"
    version = "1.1.0"

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "more-math", version.toString())

    pom {
        name.set("More math")
        description.set("Это KMP библиотека для работы с математикой.")
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
