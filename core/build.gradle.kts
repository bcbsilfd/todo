plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.github.bcbsilfd.todo"
    compileSdk = 32
    flavorDimensions.add(Flavors.DIMENSIONS)

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    Flavors.FLAVORS.forEach {
        productFlavors.apply { create(it) }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.androidXcore)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.viewModel)
    implementation(Dependencies.material)

    testImplementation(Dependencies.junit)
}