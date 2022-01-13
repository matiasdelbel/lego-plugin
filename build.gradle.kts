buildscript {

    repositories {
        google()
        mavenCentral()

        maven("https://plugins.gradle.org/m2/") /* Needed for DetectKt */
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.android.tools.build:gradle:7.0.4")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()

        maven("https://plugins.gradle.org/m2/") /* Needed for DetectKt */

        maven { setUrl("https://jitpack.io") }
    }
}
