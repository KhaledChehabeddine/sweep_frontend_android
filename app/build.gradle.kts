import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
  id("com.android.application")
  id("org.jlleitschuh.gradle.ktlint") version "11.3.1"
  kotlin("android")
  kotlin("plugin.serialization") version "1.8.10"
}

android {
  compileSdk = 33
  namespace = "com.example.sweep"

  @Suppress("UnstableApiUsage")
  buildFeatures {
    compose = true
  }

  buildTypes {
    getByName("release") {
      proguardFiles(
        @Suppress("UnstableApiUsage")
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }

  defaultConfig {
    applicationId = "com.example.sweep"
    minSdk = 26
    targetSdk = 33
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    versionCode = 1
    versionName = "1.0"
  }

  kotlinOptions {
    allWarningsAsErrors = false
    freeCompilerArgs = freeCompilerArgs + "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
    jvmTarget = "17"
  }
}

dependencies {
  val accompanistVersion = "0.30.0"
  val coilVersion = "2.3.0"
  val composeVersion = "1.4.2"
  val ktorVersion = "2.3.0"

  androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")

  debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
  debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
  debugImplementation("androidx.customview:customview:1.2.0-alpha02")
  debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0")

  // Android, Jetpack Compose & Material3 Support
  implementation("androidx.activity:activity-compose:1.7.1")
  implementation("androidx.compose.material:material-icons-extended:$composeVersion")
  implementation("androidx.compose.material3:material3:1.1.0-rc01")
  implementation("androidx.compose.ui:ui:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
  implementation("androidx.compose.ui:ui-util:$composeVersion")
  implementation("androidx.core:core-ktx:1.10.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
  @Suppress("GradleDependency")
  implementation("androidx.navigation:navigation-compose:2.6.0-alpha08") // 2.6.0-beta01 doesn't navigate correctly
  // AWS SDK Support
  implementation("aws.sdk.kotlin:s3:0.17.5-beta")
  // Accompanist Support
  implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
  implementation("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")
  implementation("com.google.accompanist:accompanist-placeholder-material:$accompanistVersion")
  implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
  // Coil Support
  implementation("io.coil-kt:coil-compose:$coilVersion")
  implementation("io.coil-kt:coil-svg:$coilVersion")
  // Ktor Support
  implementation("io.ktor:ktor-client-android-jvm:$ktorVersion")
  implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
  implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

  testImplementation("junit:junit:4.13.2")
}

tasks.named("preBuild") {
  dependsOn("ktlintFormat")
}

ktlint {
  android.set(false)
  @Suppress("DEPRECATION")
  disabledRules.set(setOf("no-wildcard-imports", "trailing-comma-on-call-site"))
  ignoreFailures.set(true)
  reporters {
    reporter(ReporterType.PLAIN)
  }
}
