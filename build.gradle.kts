buildscript {

    repositories {
        google()
        mavenCentral()

        maven("https://plugins.gradle.org/m2/") /* Needed for DetectKt */
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("com.android.tools.build:gradle:7.0.4")
    }
}

allprojects {
    repositories {
        mavenLocal()

        google()
        mavenCentral()

        maven { setUrl("https://jitpack.io") }
    }
}
