plugins {
    id("java")
}

group = "com.javier"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.datafaker:datafaker:2.4.2")

}

tasks.test {
    useJUnitPlatform()
}