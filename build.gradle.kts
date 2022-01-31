plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "xyz.tehbrian.mcmidi"
version = "1.0.0-SNAPSHOT"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/") {
        name = "papermc"
    }
    maven("https://repo.thbn.me/snapshots/") {
        name = "thbn-snapshots"
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
