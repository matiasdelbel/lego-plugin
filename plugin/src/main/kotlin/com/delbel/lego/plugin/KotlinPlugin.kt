package com.delbel.lego.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project
            .plugins
            .apply(PLUGIN_KOTLIN_KAPT)

        project
            .tasks
            .withType(KotlinCompile::class.java)
            .configureEach { kotlinOptions { jvmTarget = JVM_1_8 } }
    }

    companion object {
        private const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"

        private const val JVM_1_8 = "1.8"
    }
}
