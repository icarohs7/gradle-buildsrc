package defaults

import configureDefaultAndroid

apply(from = "$rootDir/buildSrc/groovy/flutter-android-module.gradle")
configureDefaultAndroid()