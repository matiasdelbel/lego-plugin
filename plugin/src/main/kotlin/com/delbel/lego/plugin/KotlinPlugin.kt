package com.delbel.lego.plugin

import com.delbel.lego.configuration.Configuration
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(PLUGIN_KOTLIN_ANDROID)
        project.plugins.apply(PLUGIN_KOTLIN_KAPT)

        project
            .tasks
            .withType(KotlinCompile::class.java)
            .configureEach { kotlinOptions { jvmTarget = JVM_1_8 } }

        project.dependencies { add(Configuration.Implementation, STD_JDK7) }
    }

    companion object {
        private const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
        private const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"

        private const val JVM_1_8 = "1.8"

        private const val STD_JDK7 = "org.jetbrains.kotlin:kotlin-stdlib:1.6.0"
    }
}