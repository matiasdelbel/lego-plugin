package com.delbel.lego.plugin

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jlleitschuh.gradle.ktlint.KtlintExtension

class ScaPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(PLUGIN_KTLINT)
        project.plugins.apply(PLUGIN_DETEKT)

        project.extensions.configure(EXTENSION_KT_LINT, Action<KtlintExtension> { debug.set(true) })
    }

    companion object {
        private const val PLUGIN_KTLINT = "org.jlleitschuh.gradle.ktlint"
        private const val PLUGIN_DETEKT = "io.gitlab.arturbosch.detekt"

        private const val EXTENSION_KT_LINT = "ktlint"
    }
}