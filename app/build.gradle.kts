plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    alias(libs.plugins.google.gms.google.services)
    id("com.google.firebase.crashlytics")

}

android {
    namespace = "com.example.finalsetup"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.finalsetup"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    dependency for full mvvm structure
    // Retrofit & Gson converter
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Hilt for DI
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // OkHttp Logging Interceptor
    implementation(libs.logging.interceptor)

    // Coil for Compose image loading
    implementation(libs.coil.kt.coil.compose)


    // Jetpack Lifecycle & ViewModel ktx
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.activity.compose)

    // Coroutines (if used)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.coil.kt.coil.compose)

//    for country code picker
    implementation (libs.simplecountrypicker)
    implementation(libs.androidx.credentials)

//    for firebase notification
    implementation(libs.firebase.messaging) // check latest
    implementation(libs.firebase.analytics)

//    firebase crash lytic
    implementation(libs.firebase.crashlytics.ndk)
    implementation(platform(libs.firebase.bom))

    // Add the dependency for the Firebase AI Logic library
    implementation(libs.firebase.ai)

    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.extended)

    implementation("com.razorpay:checkout:1.6.41")

}