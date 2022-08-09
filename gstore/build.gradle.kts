plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32
    flavorDimensions.add("gstore")

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
        create("gp") {
            dimension = "gstore"
            applicationIdSuffix = ".gp"
            isDefault = true
            versionName = "1.0.1"
        }
        create("fb") {
            dimension = "gstore"
            applicationIdSuffix = ".fb"
            versionName = "2.0.1"
        }
    }
}

dependencies {

    implementation(project(":core"))
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
}