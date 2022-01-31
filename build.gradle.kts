plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "xyz.tehbrian.mcmidi"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    mavenLocal() // mcmidi server
    maven("https://papermc.io/repo/repository/maven-public/") {
        name = "papermc"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
    compileOnly("xyz.tehbrian.mcmidi:server-api:1.0.0-SNAPSHOT")

    implementation("com.google.inject:guice:5.0.1")
}

tasks {
    processResources {
        expand("version" to project.version)
    }
}
