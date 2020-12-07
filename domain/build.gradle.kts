plugins {
    kotlin("kapt")
}

dependencies {
    implementation(project(":port"))
    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:2.0.2")
    implementation("jakarta.transaction:jakarta.transaction-api:1.3.3")
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.mapstruct:mapstruct:1.4.1.Final")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")
    kapt("org.mapstruct:mapstruct-processor:1.4.1.Final")

    //For the annotations
    implementation("io.quarkus:quarkus-hibernate-orm")

}
