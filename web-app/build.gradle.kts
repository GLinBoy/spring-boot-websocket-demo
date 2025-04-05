import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.ec4j.editorconfig") version "0.1.0"
    id("com.github.ben-manes.versions") version "0.51.0"
}

group = "com.glinboy.demo.websocket"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21

val socketJsClientVersion = "1.5.1"
val stompWebsocketVersion = "2.3.4"
val bootstrapVersion = "5.3.3"
val jqueryVersion = "3.7.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.webjars:webjars-locator-core")
    implementation("org.webjars:sockjs-client:$socketJsClientVersion")
    implementation("org.webjars:stomp-websocket:$stompWebsocketVersion")
    implementation("org.webjars:bootstrap:$bootstrapVersion")
    implementation("org.webjars:jquery:$jqueryVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
