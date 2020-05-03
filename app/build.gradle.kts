import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

val apiKey = gradleLocalProperties(rootDir).getProperty("imdb.key")

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "org.jazzilla.cleanarchitectuteimdb"
        minSdkVersion(22)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "IMDB_key", "\"$apiKey\"")
    }

    buildTypes {
        named("release").configure {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    //implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation(Dependencies.Kotlin.stdLib)

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.navigationComponent)
    implementation(Dependencies.AndroidX.navigationComponentFragment)
    implementation(Dependencies.AndroidX.viewModel)
    implementation(Dependencies.AndroidX.viewModelExtensions)

    implementation(Dependencies.Koin.koin)
    implementation(Dependencies.Koin.viewModel)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.logging)
    implementation(Dependencies.Retrofit.gson)

    implementation(Dependencies.Timber.timber)
}