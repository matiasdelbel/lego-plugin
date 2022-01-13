package com.delbel.lego.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

class DependencyPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.dependencies {
        implementation(dependency = STD_JDK7)
    }

    private fun DependencyHandlerScope.implementation(dependency: String) = add(implementation, dependency)

    companion object {
        const val implementation = "implementation"

        private const val STD_JDK7 = "org.jetbrains.kotlin:kotlin-stdlib:1.6.0"
    }
}