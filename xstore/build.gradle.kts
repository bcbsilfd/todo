plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    flavorDimensions.add(Flavors.DIMENSIONS)

    defaultConfig {
        applicationId = "com.github.bcbsilfd"
        minSdk = 22
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    productFlavors {
        create("hms") {
            dimension = Flavors.DIMENSIONS
            applicationIdSuffix = ".hms"
            versionName = "1.0"
        }
        create("web") {
            dimension = Flavors.DIMENSIONS
            applicationIdSuffix = ".web"
            versionName = "2.0"
            isDefault = true
        }
    }
}

dependencies {
    implementation(project(":core"))
}