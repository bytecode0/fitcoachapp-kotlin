plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    kotlin("native.cocoapods")
}

group = "com.fitcoachapp"
version = "1.0-SNAPSHOT"

fun composeDependency(groupWithArtifact: String) = "$groupWithArtifact:${libs.versions.compose}"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    ios()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "fitcoachapp_app"
            isStatic = true
        }
    }



    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":fitcoachapp-feature-auth"))
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(libs.koin.core)
                implementation(libs.material.icon.extended)
                implementation(libs.compose.util)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))


            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.androidx.appcompat)
                api(libs.androidx.coreKtx)
                implementation(libs.koin.compose)
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.junit)
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

            }
        }
        val desktopTest by getting

        val iosMain by getting {
            dependsOn(commonMain)
            dependencies {
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }

    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}