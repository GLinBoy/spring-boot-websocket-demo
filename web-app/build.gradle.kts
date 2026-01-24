plugins {
    id("org.springframework.boot") version "4.0.2"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    id("org.ec4j.editorconfig") version "0.1.0"
    id("com.github.ben-manes.versions") version "0.53.0"
}

group = "com.glinboy.demo.websocket"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

val socketJsClientVersion = "1.5.1"
val stompWebsocketVersion = "2.3.4"
val bootstrapVersion = "5.3.8"
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

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
