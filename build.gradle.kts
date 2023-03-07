plugins {
    kotlin("jvm") version "1.8.10" apply false

    id("io.gitlab.arturbosch.detekt") version "1.20.0"
}

group = "my.great.app"
version = "0.0.1-SNAPSHOT"

detekt {
    toolVersion = "1.20.0"
    config = files("../config/detekt.yml")
}
