plugins {
    id("java")
    id("org.springframework.boot") version "3.3.0" // Use a stable Spring Boot version
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.harshita.ems"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Keep this dependency for AWS Lambda integration
    implementation("com.amazonaws.serverless:aws-serverless-java-container-springboot3:2.0.1")
    implementation("com.fasterxml.jackson.core:jackson-databind")

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

// Configure the bootJar task. This will be the task that actually creates your JAR.
tasks.bootJar {
    // Set the desired name for your single JAR file
    archiveFileName.set("backend.jar")

    // Explicitly set the main class for the Spring Boot application.
    // This is the class with the @SpringBootApplication annotation and the main method.
    // Make sure to pick the correct one if both com.harshita.ems.EmployeeManagementBackendApplication
    // and com.harshita.ems.backend.EmsBackendApplication exist.
    mainClass.set("com.harshita.ems.EmployeeManagementBackendApplication")
}

// Create a custom task named 'lambdaJar' that depends on 'bootJar'
tasks.register("lambdaJar") {
    dependsOn(tasks.bootJar) // This ensures bootJar is run when lambdaJar is called
    description = "Assembles the Spring Boot executable JAR for AWS Lambda deployment."
    // No explicit 'from' or 'manifest' configuration needed here,
    // as bootJar handles the actual JAR creation and contents.
}