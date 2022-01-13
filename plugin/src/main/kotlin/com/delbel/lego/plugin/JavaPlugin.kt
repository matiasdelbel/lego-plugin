package com.delbel.lego.plugin

import com.delbel.lego.extension.androidExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class JavaPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project
            .androidExtension
            ?.apply {
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }
    }
}