package com.delbel.lego.plugin

import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.JavaVersion.VERSION_1_8
import org.gradle.api.Plugin
import org.gradle.api.Project

class JavaPlugin : Plugin<Project> {

    override fun apply(project: Project) = project
        .extensions
        .getByType(AndroidComponentsExtension::class.java)
        .finalizeDsl { android ->
            android.compileOptions.sourceCompatibility = VERSION_1_8
            android.compileOptions.targetCompatibility = VERSION_1_8
        }
}