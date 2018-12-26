plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.example.framgianguyenthanhtungh.exoplayer"
        minSdkVersion(16)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.11")
    implementation("androidx.appcompat:appcompat:1.1.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-alpha3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
    implementation("com.google.android.exoplayer:exoplayer:2.9.0")
    implementation("pub.devrel:easypermissions:2.0.0")

    //Navigation
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0-alpha09")
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0-alpha09")
}
