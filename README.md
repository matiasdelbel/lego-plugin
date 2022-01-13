# Lego Plugin
A custom plugin that set up common properties on the `build.gradle` file for Android Libraries projects.

## What it does?
### Plugins
The following plugin are being added:
- `com.android.library` 
- `kotlin-android`
- `kotlin-kapt`
- `org.jlleitschuh.gradle.ktlint`
- `io.gitlab.arturbosch.detekt`

### Android
The Android extension is applied with the following values:

| Variable          | Value   |
|:-----------------:|:-------:|
| minSdk            | 23      |
| targetSdk         | 31      |
| targetSdk         | 31      |
| compileSdkVersion | 31      |
| buildToolsVersion | 31.0.0  |
| versionName       | version |
| versionCode       | 1       |

The `isMinifyEnabled` flag is set to `true` for `release` builds and `false` for `debug` builds. It also
sets the `consumer-rules.pro` as `consumerProguardFiles` and `proguard-rules.pro` as `proguardFiles`.

### Dependencies
The following dependencies are being added:
- `org.jetbrains.kotlin:kotlin-stdlib:1.6.0`

## Integration
The plugin is deployed in jitpack because of that the following repositories must be added to your 
top level `build.gradle` file. You also need to add the plugin to the `classpath`. 

```
buildscript {
    repositories {
        maven { setUrl("https://jitpack.io") } 
        maven { setUrl("https://plugins.gradle.org/m2/") } /* Needed by KtLint /*
    }
    
    dependencies {
        classpath 'com.github.matiasdelbel.lego-plugin:com.delbel.lego.gradle.plugin:1.0.7'
    }
}
```

And then in the library `build.gradle` file
```
plugins { id 'com.delbel.lego' }
```

## Development
Here are some useful links:
- https://jitpack.io/#matiasdelbel/lego-plugin
- https://github.com/android/gradle-recipes/blob/agp-7.0/BuildSrc/addBuildTypeUsingDslFinalize/buildSrc/src/main/kotlin/ExamplePlugin.kt
- https://www.youtube.com/watch?v=SB4QlngQQW0&ab_channel=AndroidDevelopers
- https://blog.sentry.io/2021/12/14/bytecode-transformations-the-android-gradle-plugin
