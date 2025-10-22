plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }

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
    getByName("debug") { isMinifyEnabled = false }
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      // Voor nu geen release signing; we gebruiken debug APK om te testen op Sunmi.
      signingConfig = signingConfigs.getByName("debug")
    }
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.13.1")
  implementation("androidx.activity:activity-ktx:1.9.2")
  implementation("androidx.appcompat:appcompat:1.7.0")
  implementation("com.google.android.material:material:1.12.0")
}
