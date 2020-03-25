object Dependencies {

    object Kotlin {
        val version = "1.3.70"

        val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${version}"
    }

    object AndroidX {
        val core = "androidx.core:core-ktx:1.2.0"
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    }

    object Gradle {
        val gradle = "com.android.tools.build:gradle:4.0.0-beta03"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }
}