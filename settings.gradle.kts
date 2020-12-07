pluginManagement {
    val quarkusPluginVersion: String by settings
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
      id("io.quarkus") version quarkusPluginVersion
    }
}
rootProject.name="example"
include("adapters:web", "domain", "port", "adapters:persistence")
