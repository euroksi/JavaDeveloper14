plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.h2database:h2")
    runtimeOnly("com.h2database:h2")
    implementation("org.flywaydb:flyway-core")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
}

tasks.test {
    useJUnitPlatform()
}