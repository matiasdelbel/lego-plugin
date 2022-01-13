package com.delbel.lego

import com.delbel.lego.plugin.*
import org.gradle.api.Plugin
import org.gradle.api.Project

class LegoPlugin : Plugin<Project> {

    private val plugins = listOf(
        AndroidPlugin(),
        JavaPlugin(),
        KotlinPlugin(),
        ProguardPlugin(),
        ScaPlugin()
    )

    override fun apply(project: Project) = plugins.forEach { it.apply(project) }

}