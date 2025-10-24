plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.scanfie.sumuphelper"

    // ✅ Veilig voor Sunmi D3 Pro (Android 11)
    compileSdk = 30

    defaultConfig {
        applicationId = "com.scanfie.sumuphelper"
        minSdk = 24
        targetSdk = 30          // matcht Android 11 runtime
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            // ProGuard kan later weer aan als alles stabiel draait
            // proguardFiles(
            //     getDefaultProguardFile("proguard-android-optimize.txt"),
            //     "proguard-rules.pro"
            // )
        }
    }

    // ✅ Java 11 voor maximale compat op Android 11 devices
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    // ❌ GEEN Compose hier; eerst boot fixen. Later voegen we dit terug:
    // buildFeatures { compose = true }
    // composeOptions { kotlinCompilerExtensionVersion = "1.5.14" }
}

dependencies {
    // Basis AndroidX / Material
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")

    // (Optioneel) lifecycle basis
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")

    // Tests (optioneel)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
