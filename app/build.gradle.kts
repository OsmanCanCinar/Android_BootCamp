/**
 * The first section in the build configuration applies the Android plugin for
 * Gradle to this build and makes the android block available to specify
 * Android-specific build options.
 */
plugins {
    id(GradlePlugins.ANDROID_APP)
    id(GradlePlugins.KOTLIN_ANDROID)
    id(GradlePlugins.KOTLIN_JETBRAINS)
    id(GradlePlugins.KOTLIN_KAPT)
    id(GradlePlugins.SAFE_ARGS)
    id(GradlePlugins.HILT)
}

// The android block is where you configure all your Android-specific build options.
android {
    // The app's namespace. Used primarily to access app resources.
    namespace = AppConfig.APP_ID

    /**
     * compileSdkVersion specifies the Android API level Gradle should use to
     * compile your app. This means your app can use the API features included in
     * this API level and lower.
     */
    compileSdk = AppConfig.COMPILE_SDK

    /**
     * The defaultConfig block encapsulates default settings and entries for all
     * build variants, and can override some attributes in main/AndroidManifest.xml
     * dynamically from the build system. You can configure product flavors to override
     * these values for different versions of your app.
     */
    defaultConfig {
        // Uniquely identifies the package for publishing.
        applicationId = AppConfig.APP_ID

        // Defines the minimum API level required to run the app.
        minSdk = AppConfig.MIN_SDK

        // Specifies the API level used to test the app.
        targetSdk = AppConfig.TARGET_SDK

        // Defines the version number of your app.
        versionCode = AppConfig.VERSION_CODE

        // Defines a user-friendly version name for your app.
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = AppConfig.TEST_INST_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }

        /**
         * The `initWith` property allows you to copy configurations from other build types,
         * then configure only the settings you want to change. This one copies the debug build
         * type, and then changes the manifest placeholder and application ID.
         *
         *  create("staging") {
         *  initWith(getByName("debug"))
         *  manifestPlaceholders["hostName"] = "internal.example.com"
         *  applicationIdSuffix = ".debugStaging"
        }
         */
    }

    // Specifies the flavor dimensions you want to use. The order in which you
    // list each dimension determines its priority, from highest to lowest,
    // when Gradle merges variant sources and configurations. You must assign
    // each product flavor you configure to one of the flavor dimensions.
    flavorDimensions += listOf("paywall")

    productFlavors {
        create("free") {
            // Assigns this product flavor to the "mode" flavor dimension.
            dimension = "paywall"
            applicationIdSuffix = ".free"
            manifestPlaceholders["free"] = "free"
        }

        create("paid") {
            dimension = "paywall"
            applicationIdSuffix = ".paid"
            manifestPlaceholders["paid"] = "paid"
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = AppConfig.JAVA
        targetCompatibility = AppConfig.JAVA
    }

    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}

androidComponents {
    beforeVariants { variantBuilder ->
        // To check for a certain build type, use variantBuilder.buildType == "<buildType>"
        if (variantBuilder.productFlavors.containsAll(listOf("paywall" to "paid"))) {
            // Gradle ignores any variants that satisfy the conditions above.
            variantBuilder.enabled = false
        }
    }
}

/**
 * The dependencies block in the module-level build configuration file
 * specifies dependencies required to build only the module itself.
 */
dependencies {
    implementation(Dependencies.Android.APPCOMPAT)
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.Android.SWIPE_LAYOUT)
    implementation(Dependencies.Android.PREFERENCE)
    implementation(Dependencies.Android.Navigation.FRAGMENT)
    implementation(Dependencies.Android.Navigation.UI)
    implementation(Dependencies.Android.Room.CORE)
    implementation(Dependencies.Android.Room.RUN_TIME)
    implementation(Dependencies.Android.Room.ADAPTER_RXJAVA3)
    implementation(Dependencies.Android.LifeCycle.VIEW_MODEL)
    implementation(Dependencies.Android.LifeCycle.VM_SAVED_STATE)
    implementation(Dependencies.Android.LifeCycle.LIVE_DATA)
    implementation(Dependencies.Android.Ktx.ACTIVITY)
    implementation(Dependencies.Android.Ktx.FRAGMENT)
    implementation(Dependencies.Android.Ktx.CORE)
    implementation(Dependencies.Injection.CORE)
    implementation(Dependencies.Injection.NAVIGATION)
    implementation(Dependencies.Utilities.JETBRAINS_COROUTINES)
    implementation(Dependencies.Utilities.Glide.CORE)
    implementation(Dependencies.Utilities.Retrofit.CORE)
    implementation(Dependencies.Utilities.Retrofit.GSON)
    implementation(Dependencies.Utilities.Retrofit.CONVERTER_GSON)
    implementation(Dependencies.Utilities.Retrofit.ADAPTER_RXJAVA)
    implementation(Dependencies.Utilities.RxJava.CORE)
    implementation(Dependencies.Utilities.RxJava.ANDROID)

    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.ANDROIDX_JUNIT)
    testImplementation(Dependencies.Test.ESPRESSO_CORE)

    kapt(Dependencies.Android.Room.COMPILER)
    kapt(Dependencies.Injection.COMPILER)
    kapt(Dependencies.Utilities.Glide.COMPILER)
}

kapt {
    correctErrorTypes = true
}
