@file:Suppress("PublicApiImplicitType", "MemberVisibilityCanBePrivate", "unused", "MayBeConstant")

object Deps {
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
}

object TestDeps {
    val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestDeps {
    val testRunner = "androidx.test:runner:${Versions.androidxTest}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Versions {
    val compileSdk = 29
    val minSdk = 21
    val targetSdk = 29

    val kotlin = "1.3.61"

    val androidxTest = "1.2.0"
    val espresso = "3.2.0"
    val junit = "4.12"
}