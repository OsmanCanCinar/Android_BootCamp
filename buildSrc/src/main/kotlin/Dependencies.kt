object Dependencies {
    object Android {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${DependencyVersion.Android.APPCOMPAT}"
        const val MATERIAL =
            "com.google.android.material:material:${DependencyVersion.Android.MATERIAL}"
        const val SWIPE_LAYOUT =
            "androidx.swiperefreshlayout:swiperefreshlayout:${DependencyVersion.Android.SWIPE_LAYOUT}"
        const val PREFERENCE =
            "androidx.preference:preference-ktx:${DependencyVersion.Android.PREFERENCE}"

        object Navigation {
            const val FRAGMENT =
                "androidx.navigation:navigation-fragment-ktx:${DependencyVersion.Android.NAVIGATION}"
            const val UI =
                "androidx.navigation:navigation-ui-ktx:${DependencyVersion.Android.NAVIGATION}"
        }

        object Room {
            const val CORE = "androidx.room:room-ktx:${DependencyVersion.Android.ROOM}"
            const val RUN_TIME = "androidx.room:room-runtime:${DependencyVersion.Android.ROOM}"
            const val COMPILER = "androidx.room:room-compiler:${DependencyVersion.Android.ROOM}"
            const val ADAPTER_RXJAVA3 =
                "androidx.room:room-rxjava3:${DependencyVersion.Android.ROOM}"
        }

        object LifeCycle {
            const val VIEW_MODEL =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersion.Android.LIFE_CYCLE}"
            const val VM_SAVED_STATE =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:${DependencyVersion.Android.LIFE_CYCLE}"
            const val LIVE_DATA =
                "androidx.lifecycle:lifecycle-livedata-ktx:${DependencyVersion.Android.LIFE_CYCLE}"
        }

        object Ktx {
            const val CORE = "androidx.core:core-ktx:${DependencyVersion.Android.Ktx.CORE}"
            const val ACTIVITY =
                "androidx.activity:activity-ktx:${DependencyVersion.Android.Ktx.ACTIVITY}"
            const val FRAGMENT =
                "androidx.fragment:fragment-ktx:${DependencyVersion.Android.Ktx.FRAGMENT}"
        }
    }

    object Injection {
        const val CORE = "com.google.dagger:hilt-android:${DependencyVersion.Injection.CORE}"
        const val COMPILER = "com.google.dagger:hilt-compiler:${DependencyVersion.Injection.CORE}"
        const val NAVIGATION =
            "androidx.hilt:hilt-navigation-fragment:${DependencyVersion.Injection.NAVIGATION}"
    }

    object Test {
        const val ANDROIDX_JUNIT =
            "androidx.test.ext:junit:${DependencyVersion.Test.ANDROIDX_JUNIT}"
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:${DependencyVersion.Test.ESPRESSO_CORE}"
        const val JUNIT = "junit:junit:${DependencyVersion.Test.JUNIT}"
    }

    object Utilities {
        const val JETBRAINS_COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersion.Utilities.JETBRAINS_COROUTINES}"

        object Glide {
            const val CORE = "com.github.bumptech.glide:glide:${DependencyVersion.Utilities.GLIDE}"
            const val COMPILER =
                "com.github.bumptech.glide:compiler:${DependencyVersion.Utilities.GLIDE}"
        }

        object Retrofit {
            const val CORE =
                "com.squareup.retrofit2:retrofit:${DependencyVersion.Utilities.Retrofit.CORE}"
            const val GSON =
                "com.google.code.gson:gson:${DependencyVersion.Utilities.Retrofit.GSON}"
            const val CONVERTER_GSON =
                "com.squareup.retrofit2:converter-gson:${DependencyVersion.Utilities.Retrofit.CORE}"
            const val ADAPTER_RXJAVA =
                "com.squareup.retrofit2:adapter-rxjava3:${DependencyVersion.Utilities.Retrofit.CORE}"
        }

        object RxJava {
            const val CORE = "io.reactivex.rxjava3:rxjava:${DependencyVersion.Utilities.RXJAVA}"
            const val ANDROID =
                "io.reactivex.rxjava3:rxandroid:${DependencyVersion.Utilities.RXJAVA}"
        }
    }
}