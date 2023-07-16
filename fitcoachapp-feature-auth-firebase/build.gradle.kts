plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
}

group = "com.fitcoachapp.feature.auth.firebase"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    ios()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "common"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.serialization)
                implementation(project(":fitcoachapp-feature-auth-domain"))
                implementation("dev.gitlive:firebase-firestore:1.8.1")
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
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.junit)
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)
            dependencies {}
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