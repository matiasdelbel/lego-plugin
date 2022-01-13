plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

// TODO -> move plugin publishing to another file.
group = "com.delbel.lego"
version = "1.0.0"

publishing {
    publications {

        repositories {
            mavenLocal()
        }

        create<MavenPublication>("maven") {
            artifactId = "plugin"

            from(components["kotlin"])

            pom {
                name.set("Lego - Plugin")
                description.set("Set up the basic project configuration.")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("matiasdelbel")
                        name.set("Matias Del Bel")
                        email.set("matiasdelbel@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git@github.com:matiasdelbel/lego-plugin.git")
                    developerConnection.set("scm:git@github.com:matiasdelbel/lego-plugin.git")
                    url.set("https://github.com/matiasdelbel/lego-plugin")
                }
            }
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.4")

    implementation(kotlin("gradle-plugin"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")

    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.10.0")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.1.0")
}

gradlePlugin.plugins.register("com.delbel.lego") {
    id = "com.delbel.lego"
    implementationClass = "com.delbel.lego.LegoPlugin"
}
