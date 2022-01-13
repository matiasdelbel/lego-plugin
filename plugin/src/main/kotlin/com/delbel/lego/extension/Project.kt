package com.delbel.lego.extension

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

val Project.androidExtension get() = project.extensions.getByName(EXTENSION_ANDROID) as? BaseExtension

private const val EXTENSION_ANDROID = "android"
