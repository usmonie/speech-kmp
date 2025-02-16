@file:Suppress("UnstableApiUsage")import org.gradle.api.internal.FeaturePreviews

rootProject.name = "speechWTF"

enableFeaturePreview(FeaturePreviews.Feature.TYPESAFE_PROJECT_ACCESSORS.name)
enableFeaturePreview(FeaturePreviews.Feature.STABLE_CONFIGURATION_CACHE.name)

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")

include(":compass:core")
include(":compass:state")

include(":core:kit")

include(":features:post:kit")
include(":features:post:ui")
include(":features:post:domain")
include(":features:post:data")

include(":features:timeline:kit")
include(":features:timeline:ui")
include(":features:timeline:domain")
include(":features:timeline:data")

include(":features:user:kit")
include(":features:user:ui")
include(":features:user:domain")
include(":features:user:data")
