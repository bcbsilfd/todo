plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    flavorDimensions.add("xstore")

    defaultConfig {
        applicationId = "com.github.bcbsilfd"
        minSdk = 22
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        debug {  }

        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    productFlavors {
        create("hms") {
            dimension = "xstore"
            applicationIdSuffix = ".hms"
            isDefault = true
            versionName = "1.0"
        }
        create("web") {
            dimension = "xstore"
            applicationIdSuffix = ".web"
            versionName = "2.0"
        }
    }
}

dependencies {
    implementation(project(":core"))
}