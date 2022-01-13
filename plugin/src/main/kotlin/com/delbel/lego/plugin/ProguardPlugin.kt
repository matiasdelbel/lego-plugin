package com.delbel.lego.plugin

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.delbel.lego.extension.androidExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

class ProguardPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val androidExtension = project.androidExtension ?: return

        androidExtension.setUpBuildType(buildType = "release", isMinifyEnabled = true)
        androidExtension.setUpBuildType(buildType = "debug", isMinifyEnabled = false)

        (androidExtension as? LibraryExtension)?.defaultConfig {
            consumerProguardFiles(PROGUARD_CONSUMER_FILE)
            proguardFiles.add(File(PROGUARD_RULES_FILE))
        }
    }

    private fun BaseExtension.setUpBuildType(buildType: String, isMinifyEnabled: Boolean) = buildTypes
        .maybeCreate(buildType)
        .apply { minifyEnabled(isMinifyEnabled) }

    companion object {
        private const val PROGUARD_CONSUMER_FILE = "consumer-rules.pro"
        private const val PROGUARD_RULES_FILE = "proguard-rules.pro"
    }
}
