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
        create("gp") {
            dimension = Flavors.DIMENSIONS
            applicationIdSuffix = ".gp"
            isDefault = true
            versionName = "1.0.1"
        }
        create("fb") {
            dimension = Flavors.DIMENSIONS
            applicationIdSuffix = ".fb"
            versionName = "2.0.1"
        }
    }
}

dependencies {
    implementation(project(":core"))
}