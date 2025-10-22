plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.scanfie.sumuphelper"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.scanfie.sumuphelper"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        debug { isMinifyEnabled = false }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    // ✅ Compose aan
    buildFeatures {
        compose = true
    }
    composeOptions {
        // ✅ Compiler ext. voor Kotlin 1.9.24
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    // ✅ Compose BOM
    implementation(platform("androidx.compose:compose-bom:2024.08.00"))

    // Basis Compose UI
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Optioneel dev-tools (alleen debug)
    debugImplementation("androidx.compose.ui:ui-tooling")

    // KTX/compat (mag blijven)
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
}
