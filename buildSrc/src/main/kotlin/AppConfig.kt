import org.gradle.api.JavaVersion

object AppConfig {
    val JAVA = JavaVersion.VERSION_1_8

    const val APP_ID = "com.osmancancinar.androidbootcamp"
    const val COMPILE_SDK = 32
    const val JVM_TARGET = "1.8"
    const val MIN_SDK = 23
    const val TARGET_SDK = 32
    const val TEST_INST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}