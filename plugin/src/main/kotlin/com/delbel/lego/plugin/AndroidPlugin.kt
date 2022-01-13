package com.delbel.lego.plugin

import com.android.build.gradle.BaseExtension
import com.delbel.lego.extension.androidExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlin-kapt")

        project.androidExtension?.setUp(project)
    }

    private fun BaseExtension.setUp(project: Project) = apply {
        setCompileSdkVersion(COMPILE_VERSION)
        buildToolsVersion(BUILD_TOOLS_VERSION)

        defaultConfig {
            minSdk = MIN_VERSION_LIB
            targetSdk = TARGET_VERSION

            versionName = project.version as String
            versionCode = 1
        }
    }

    private companion object {
        const val MIN_VERSION_LIB = 23

        const val COMPILE_VERSION = 31
        const val TARGET_VERSION = COMPILE_VERSION

        const val BUILD_TOOLS_VERSION = "31.0.0"
    }
}