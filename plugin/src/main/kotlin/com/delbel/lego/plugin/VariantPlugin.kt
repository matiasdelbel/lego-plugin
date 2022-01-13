package com.delbel.lego.plugin

import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class VariantPlugin : Plugin<Project> {

    @Suppress("UnstableApiUsage")
    override fun apply(project: Project) = project
        .extensions
        .getByType(AndroidComponentsExtension::class.java)
        .finalizeDsl { extension ->
            extension.buildTypes.maybeCreate("release").let { release ->
                release.isMinifyEnabled = true
            }
            extension.buildTypes.maybeCreate("debug").let { debug ->
                debug.isMinifyEnabled = true
            }
        }
}
