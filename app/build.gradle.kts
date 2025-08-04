plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    kotlin("kapt") // Para procesar anotaciones
}

android {

    buildFeatures {
        viewBinding = true
    }
    namespace = "com.example.myapplication4"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.myapplication4"
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
}

dependencies {
    implementation("com.google.dagger:hilt-android:2.51")
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.activity:activity-ktx:1.8.0") // o 1.8.2, 1.8.3, etc.

    //implementation("com.empresa:mylibrary-demo-release:1.0.0") // Esta libreria no tiene la clase que necesitamos por que la ofuzca

    //Se puede importar de las siguientes maneras, lo ideal es importarla con libs y usar el archivo toml
    //implementation("com.empresa:mylibrary-demo-debug:1.0.0")
    //https://github.com/AJgomez2001GH/ModuloLibreria
    //Para ensamblar -> ./gradlew :mylibrary:assembledemodebug
    //Para publicar  -> ./gradlew :mylibrary:publishDemoDebugPublicationToMavenLocal
    implementation(libs.myCustomlibrary)
}