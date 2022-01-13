package com.delbel.lego.plugin

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import com.delbel.lego.extension.androidExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

class ProguardPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val androidExtension = project.androidExtension ?: return

        project
            .extensions
            .getByType(AndroidComponentsExtension::class.java)
            .finalizeDsl { extension ->
                extension.setUpIsMinifyEnabledFor(buildType = "release", isMinifyEnabled = true)
                extension.setUpIsMinifyEnabledFor(buildType = "debug", isMinifyEnabled = false)
            }

        (androidExtension as? LibraryExtension)?.defaultConfig {
            consumerProguardFiles(PROGUARD_CONSUMER_FILE)
            proguardFiles.add(File(PROGUARD_RULES_FILE))
        }
    }

    @Suppress("UnstableApiUsage")
    private fun CommonExtension<*, *, *, *>.setUpIsMinifyEnabledFor(
        buildType: String,
        isMinifyEnabled: Boolean
    ) = buildTypes
        .maybeCreate(buildType)
        .let { buildType -> buildType.isMinifyEnabled = isMinifyEnabled }

    companion object {
        private const val PROGUARD_CONSUMER_FILE = "consumer-rules.pro"
        private const val PROGUARD_RULES_FILE = "proguard-rules.pro"
    }
}
