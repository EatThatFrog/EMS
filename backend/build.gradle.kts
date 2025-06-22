plugins {
    id("java")
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.harshita.ems"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.amazonaws.serverless:aws-serverless-java-container-springboot3:2.0.1")
    implementation("com.fasterxml.jackson.core:jackson-databind")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.bootJar {
    archiveFileName.set("backend.jar")
    mainClass.set("com.harshita.ems.EmployeeManagementBackendApplication")
}

tasks.register<Copy>("lambdaJar") {
    dependsOn(tasks.bootJar)
    from(tasks.bootJar.get().archiveFile)
    into("$buildDir/lambda")
}
