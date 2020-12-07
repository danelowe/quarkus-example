import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
    // outer scope not available in plugins block,
    // so kotlinVersion cannot be shared between plugins blocks in different projects
    val kotlinVersion = "1.3.72"
    id("io.quarkus")
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
}
repositories {
    mavenCentral()
}
//https://youtrack.jetbrains.com/issue/KT-27994#focus=streamItem-27-3148043.0-0
extra["kotlin.version"] = plugins.getPlugin(KotlinPluginWrapper::class.java).kotlinPluginVersion

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(project(":port"))
    implementation(project(":domain"))
    implementation(project(":adapters:persistence"))
    implementation(project(path = ":adapters:web", configuration = "default"))
    implementation("io.quarkus:quarkus-kotlin")
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
}

configure<io.quarkus.gradle.QuarkusPluginExtension> {
    setOutputDirectory("$projectDir/build/classes/kotlin/main")
}

tasks.withType<io.quarkus.gradle.tasks.QuarkusDev> {
    setSourceDir("$projectDir/src/main/kotlin")
}


allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    apply {
        plugin("io.quarkus")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.allopen")
        plugin("org.jetbrains.kotlin.plugin.jpa")
        plugin("org.jetbrains.kotlin.plugin.noarg")
    }

    repositories {
        mavenCentral()
    }

    val implementation by configurations
    dependencies {
        implementation(kotlin("stdlib"))
        implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
        testImplementation("io.quarkus:quarkus-junit5")
        testImplementation("org.jboss.weld:weld-junit5:2.0.1.Final")
        testImplementation("io.rest-assured:kotlin-extensions")
        testImplementation("org.mockito:mockito-core:2.+")
    }

    allOpen {
        annotation("com.example.port.ParamsBean")
        annotation("javax.ws.rs.Path")
        annotation("javax.enterprise.context.ApplicationScoped")
        annotation("io.quarkus.test.junit.QuarkusTest")

        annotation("javax.persistence.Entity")
        annotation("javax.persistence.MappedSuperclass")
        annotation("javax.persistence.Embeddable")
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "11"
            kotlinOptions.javaParameters = true
        }

        withType<Test> {
            useJUnitPlatform()
            systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
