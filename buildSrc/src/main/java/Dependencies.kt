object Dependencies {

    object Kotlin {
        const val version = "1.3.70"

        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${version}"
    }

    object AndroidX {
        private const val navigationComponentVersion = "2.3.0-alpha04"
        private const val viewModelVersion = "2.2.0"

        const val core = "androidx.core:core-ktx:1.2.0"
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val navigationComponentFragment = "androidx.navigation:navigation-fragment-ktx:$navigationComponentVersion"
        const val navigationComponent = "androidx.navigation:navigation-ui-ktx:$navigationComponentVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion)"
        const val viewModelExtensions = "androidx.lifecycle:lifecycle-extensions:$viewModelVersion"
    }

    object Koin {
        private const val version = "2.1.5"

        const val koin = "org.koin:koin-android:$version"
        const val viewModel = "org.koin:koin-android-viewmodel:$version"
    }

    object Gradle {
        const val gradle = "com.android.tools.build:gradle:4.0.0-beta03"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }
}