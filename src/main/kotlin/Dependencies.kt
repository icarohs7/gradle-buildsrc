@file:Suppress("PublicApiImplicitType", "MemberVisibilityCanBePrivate", "unused", "MayBeConstant")

import org.gradle.api.artifacts.dsl.DependencyHandler

object CommonDeps {
    val coroutinesCoreCommon = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.coroutines}"
}

object Deps {
    val arrowCoreData = "io.arrow-kt:arrow-core-data:${Versions.arrow}"
    val arrowCoreExtensions = "io.arrow-kt:arrow-core-extensions:${Versions.arrow}"
    val arrowEffectsData = "io.arrow-kt:arrow-effects-data:${Versions.arrow}"
    val arrowEffectsExtensions = "io.arrow-kt:arrow-effects-extensions:${Versions.arrow}"
    val arrowEffectsIoExtensions = "io.arrow-kt:arrow-effects-io-extensions:${Versions.arrow}"
    val arrowEffectsReactorData = "io.arrow-kt:arrow-effects-reactor-data:${Versions.arrow}"
    val arrowEffectsReactorExtensions = "io.arrow-kt:arrow-effects-reactor-extensions:${Versions.arrow}"
    val arrowEffectsRx2Data = "io.arrow-kt:arrow-effects-rx2-data:${Versions.arrow}"
    val arrowEffectsRx2Extensions = "io.arrow-kt:arrow-effects-rx2-extensions:${Versions.arrow}"
    val arrowExtrasData = "io.arrow-kt:arrow-extras-data:${Versions.arrow}"
    val arrowExtrasExtensions = "io.arrow-kt:arrow-extras-extensions:${Versions.arrow}"
    val arrowFreeData = "io.arrow-kt:arrow-free-data:${Versions.arrow}"
    val arrowFreeExtensions = "io.arrow-kt:arrow-free-extensions:${Versions.arrow}"
    val arrowGeneric = "io.arrow-kt:arrow-generic:${Versions.arrow}"
    val arrowIntegrationRetrofitAdapter = "io.arrow-kt:arrow-integration-retrofit-adapter:${Versions.arrow}"
    val arrowMtl = "io.arrow-kt:arrow-mtl:${Versions.arrow}"
    val arrowOptics = "io.arrow-kt:arrow-optics:${Versions.arrow}"
    val arrowQueryLanguage = "io.arrow-kt:arrow-query-language:${Versions.arrow}"
    val arrowRecursionData = "io.arrow-kt:arrow-recursion-data:${Versions.arrow}"
    val arrowRecursionExtensions = "io.arrow-kt:arrow-recursion-extensions:${Versions.arrow}"
    val arrowSyntax = "io.arrow-kt:arrow-syntax:${Versions.arrow}"
    val arrowTypeclasses = "io.arrow-kt:arrow-typeclasses:${Versions.arrow}"
    val awsDynamoDBSDK = "com.amazonaws:aws-java-sdk-dynamodb"
    val awsPlatform = { d: DependencyHandler -> d.platform("com.amazonaws:aws-java-sdk-bom:${Versions.awsPlatform}") }
    val clikt = "com.github.ajalt:clikt:${Versions.clikt}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesReactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Versions.coroutines}"
    val coroutinesRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutines}"
    val exposed = "org.jetbrains.exposed:exposed:${Versions.exposed}"
    val fuel = "com.github.kittinunf.fuel:fuel:${Versions.fuel}"
    val fuelKotlinxSerialization = "com.github.kittinunf.fuel:fuel-kotlinx-serialization:${Versions.fuel}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val jodaTime = "joda-time:joda-time:${Versions.jodaTime}"
    val khronos = "com.github.hotchemi:khronos:${Versions.khronos}"
    val kodaTime = "com.github.debop:koda-time:${Versions.kodaTime}"
    val koinCore = "org.koin:koin-core:${Versions.koin}"
    val koinKtor = "org.koin:koin-ktor:${Versions.koin}"
    val kotlinEvents = "com.github.halcyxn:kotlin-events:${Versions.kotlinEvents}"
    val kotlinFlowExtensions = "com.github.akarnokd:kotlin-flow-extensions:${Versions.kotlinFlowExtensions}"
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlinxSerialization}"
    val ktorServerCore = "io.ktor:ktor-server-core:${Versions.ktor}"
    val ktorServerGson = "io.ktor:ktor-gson:${Versions.ktor}"
    val ktorServerJackson = "io.ktor:ktor-jackson:${Versions.ktor}"
    val ktorServerCIO = "io.ktor:ktor-server-cio:${Versions.ktor}"
    val ktorServerJetty = "io.ktor:ktor-server-jetty:${Versions.ktor}"
    val ktorServerNetty = "io.ktor:ktor-server-netty:${Versions.ktor}"
    val ktorServerSerialization = "io.ktor:ktor-serialization:${Versions.ktor}"
    val logbackClassic = "ch.qos.logback:logback-classic:${Versions.logback}"
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    val okio = "com.squareup.okio:okio:${Versions.okio}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitKotlinxSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitKotlinxSerializationConverter}"
    val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    val rxRelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxRelay}"
    val snakeYaml = "org.yaml:snakeyaml:${Versions.snakeYaml}"
    val unoxCoreJvm = "com.github.icarohs7:unoxcore-jvm:${Versions.unoxCore}"
}

object JavaFxDeps {
    val coroutinesJavaFx = "org.jetbrains.kotlinx:kotlinx-coroutines-javafx:${Versions.coroutines}"
    val ikonliDashIcons = "org.kordamp.ikonli:ikonli-dashicons-pack:${Versions.ikonli}"
    val ikonliDevIcons = "org.kordamp.ikonli:ikonli-devicons-pack:${Versions.ikonli}"
    val ikonliElusive = "org.kordamp.ikonli:ikonli-elusive-pack:${Versions.ikonli}"
    val ikonliEntypo = "org.kordamp.ikonli:ikonli-entypo-pack:${Versions.ikonli}"
    val ikonliFeather = "org.kordamp.ikonli:ikonli-feather-pack:${Versions.ikonli}"
    val ikonliFontAwesome = "org.kordamp.ikonli:ikonli-fontawesome-pack:${Versions.ikonli}"
    val ikonliFontAwesome5 = "org.kordamp.ikonli:ikonli-fontawesome5-pack:${Versions.ikonli}"
    val ikonliFontelico = "org.kordamp.ikonli:ikonli-fontelico-pack:${Versions.ikonli}"
    val ikonliFoundation = "org.kordamp.ikonli:ikonli-foundation-pack:${Versions.ikonli}"
    val ikonliHawconsFilled = "org.kordamp.ikonli:ikonli-hawconsfilled-pack:${Versions.ikonli}"
    val ikonliHawconsStroke = "org.kordamp.ikonli:ikonli-hawconsstroke-pack:${Versions.ikonli}"
    val ikonliIcomoon = "org.kordamp.ikonli:ikonli-icomoon-pack:${Versions.ikonli}"
    val ikonliIonicons = "org.kordamp.ikonli:ikonli-ionicons-pack:${Versions.ikonli}"
    val ikonliIonicons4 = "org.kordamp.ikonli:ikonli-ionicons4-pack:${Versions.ikonli}"
    val ikonliJavaFx = "org.kordamp.ikonli:ikonli-javafx:${Versions.ikonli}"
    val ikonliLigatureSymbols = "org.kordamp.ikonli:ikonli-ligaturesymbols-pack:${Versions.ikonli}"
    val ikonliMaki = "org.kordamp.ikonli:ikonli-maki-pack:${Versions.ikonli}"
    val ikonliMaki2 = "org.kordamp.ikonli:ikonli-maki2-pack:${Versions.ikonli}"
    val ikonliMapicons = "org.kordamp.ikonli:ikonli-mapicons-pack:${Versions.ikonli}"
    val ikonliMaterialDesign = "org.kordamp.ikonli:ikonli-materialdesign-pack:${Versions.ikonli}"
    val ikonliMaterialIcons = "org.kordamp.ikonli:ikonli-material-pack:${Versions.ikonli}"
    val ikonliMetrizeicons = "org.kordamp.ikonli:ikonli-metrizeicons-pack:${Versions.ikonli}"
    val ikonliOcticons = "org.kordamp.ikonli:ikonli-octicons-pack:${Versions.ikonli}"
    val ikonliOpenIconic = "org.kordamp.ikonli:ikonli-openiconic-pack:${Versions.ikonli}"
    val ikonliPaymentFont = "org.kordamp.ikonli:ikonli-paymentfont-pack:${Versions.ikonli}"
    val ikonliRunestroIcons = "org.kordamp.ikonli:ikonli-runestroicons-pack:${Versions.ikonli}"
    val ikonliThemify = "org.kordamp.ikonli:ikonli-themify-pack:${Versions.ikonli}"
    val ikonliTypicons = "org.kordamp.ikonli:ikonli-typicons-pack:${Versions.ikonli}"
    val ikonliWeathericons = "org.kordamp.ikonli:ikonli-weathericons-pack:${Versions.ikonli}"
    val ikonliWebsymbols = "org.kordamp.ikonli:ikonli-websymbols-pack:${Versions.ikonli}"
    val ikonliZondicons = "org.kordamp.ikonli:ikonli-zondicons-pack:${Versions.ikonli}"
    val jFoenix = "com.jfoenix:jfoenix:${Versions.jFoenix}"
    val tornadoFx = "no.tornado:tornadofx:${Versions.tornadoFx}"
    val unoxJavafxArchCore = "com.github.icarohs7:unox-javafx-arch-core:${Versions.unoxJavafxArch}"
}

object AndroidDeps {
    val androidSpeedDial = "com.leinardi.android:speed-dial:${Versions.androidSpeedDial}"
    val androidToggle = "com.github.angads25:toggle:${Versions.androidToggle}"
    val androidxPreference = "androidx.preference:preference-ktx:${Versions.androidxPreference}"
    val ankoCommons = "org.jetbrains.anko:anko-commons:${Versions.anko}"
    val ankoSdk25 = "org.jetbrains.anko:anko-sdk25:${Versions.anko}"
    val anotherViewPager = "io.kri:anotherViewPager:${Versions.anotherViewPager}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val bluetoothKit = "com.github.sirvar:bluetoothkit-android:${Versions.bluetoothKit}"
    val bungee = "com.github.Binary-Finery:Bungee:${Versions.bungee}"
    val checkableChipView = "com.github.okdroid:checkablechipview:${Versions.checkableChipView}"
    val chucker = "com.github.ChuckerTeam.Chucker:library:${Versions.chucker}"
    val chuckerNoOp = "com.github.ChuckerTeam.Chucker:library-no-op:${Versions.chucker}"
    val circularImageView = "com.github.abdularis:CircularImageView:${Versions.circularImageView}"
    val coil = "io.coil-kt:coil:${Versions.coil}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val coreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"
    val crunchyCalendar = "ru.cleverpumpkin:crunchycalendar:${Versions.crunchyCalendar}"
    val cryptoPrefs = "com.github.AndreaCioccarelli:CryptoPrefs:${Versions.cryptoPrefs}"
    val currencyEditText = "com.github.BlacKCaT27:CurrencyEditText:${Versions.currencyEditText}"
    val disposer = "io.sellmair:disposer:${Versions.disposer}"
    val drawableToolbox = "com.github.duanhong169:drawabletoolbox:${Versions.drawableToolbox}"
    val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    val epoxyDatabinding = "com.airbnb.android:epoxy-databinding:${Versions.epoxy}"
    val expansionPanel = "com.github.florent37:expansionpanel:${Versions.expansionPanel}"
    val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    val firebaseFirestore = "com.google.firebase:firebase-firestore:${Versions.firebaseFirestore}"
    val firebaseMessaging = "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"
    val firebaseStorage = "com.google.firebase:firebase-storage:${Versions.firebaseStorage}"
    val flashbar = "com.andrognito.flashbar:flashbar:${Versions.flashBar}"
    val flexboxLayout = "com.google.android:flexbox:${Versions.flexboxLayout}"
    val floatingSearchView = "com.github.arimorty:floatingsearchview:${Versions.floatingSearchView}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val fullscreenDialog = "com.nikialeksey:fullscreendialog:${Versions.fullscreenDialog}@aar"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val googlePlayCore = "com.google.android.play:core:${Versions.googlePlayCore}"
    val googlePlayServicesLocation =
            "com.google.android.gms:play-services-location:${Versions.googlePlayServicesLocation}"
    val googlePlayServicesMaps = "com.google.android.gms:play-services-maps:${Versions.googlePlayServicesMaps}"
    val googlePlayServicesPlaces = "com.google.android.gms:play-services-places:${Versions.googlePlayServicesPlaces}"
    val helloCharts = "com.github.lecho:hellocharts-android:${Versions.helloCharts}"
    val iconicsFontAwesome = "com.mikepenz:fontawesome-typeface:${Versions.iconicsFontAwesome}@aar"
    val iconicsMaterial = "com.mikepenz:material-design-iconic-typeface:${Versions.iconicsMaterial}@aar"
    val iconicsMaterialOriginal = "com.mikepenz:google-material-typeface:${Versions.iconicsMaterialOriginal}@aar"
    val inputMask = "com.redmadrobot:input-mask-android:${Versions.inputMask}"
    val kaml = "com.charleskorn.kaml:kaml:${Versions.kaml}"
    val kFormMaster = "com.thejuki:k-form-master:${Versions.kFormMaster}"
    val kidAdapter = "com.link184:kid-adapter:${Versions.kidAdapter}"
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinAndroidxViewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    val kotpref = "com.chibatching.kotpref:kotpref:${Versions.kotpref}"
    val kotprefEnumSupport = "com.chibatching.kotpref:enum-support:${Versions.kotpref}"
    val kotprefGson = "com.chibatching.kotpref:gson-support:${Versions.kotpref}"
    val kotprefInitializer = "com.chibatching.kotpref:initializer:${Versions.kotpref}"
    val kotprefLiveData = "com.chibatching.kotpref:livedata-support:${Versions.kotpref}"
    val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val lifecycleReactiveStreamsKtx = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycle}"
    val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lightCalendarView = "jp.co.recruit_mp:LightCalendarView:${Versions.lightCalendarView}"
    val lithoCore = "com.facebook.litho:litho-core:${Versions.litho}"
    val lithoSectionsAnnotations = "com.facebook.litho:litho-sections-annotations:${Versions.litho}" //compileOnly
    val lithoSectionsCore = "com.facebook.litho:litho-sections-core:${Versions.litho}"
    val lithoSectionsWidget = "com.facebook.litho:litho-sections-widget:${Versions.litho}"
    val lithoWidget = "com.facebook.litho:litho-widget:${Versions.litho}"
    val maskedEditText = "com.github.santalu:mask-edittext:${Versions.maskEditText}"
    val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
    val materialDialogs = "com.afollestad.material-dialogs:core:${Versions.materialDialogs}"
    val materialDialogsBottomSheets = "com.afollestad.material-dialogs:bottomsheets:${Versions.materialDialogs}"
    val materialDialogsColor = "com.afollestad.material-dialogs:color:${Versions.materialDialogs}"
    val materialDialogsDateTime = "com.afollestad.material-dialogs:datetime:${Versions.materialDialogs}"
    val materialDialogsFiles = "com.afollestad.material-dialogs:files:${Versions.materialDialogs}"
    val materialDialogsInput = "com.afollestad.material-dialogs:input:${Versions.materialDialogs}"
    val materialDialogsLifecycle = "com.afollestad.material-dialogs:lifecycle:${Versions.materialDialogs}"
    val materialDrawer = "com.mikepenz:materialdrawer:${Versions.materialDrawer}"
    val materialDrawerKt = "co.zsmb:materialdrawer-kt:${Versions.materialDrawerKt}"
    val materialEditText = "com.rengwuxian.materialedittext:library:${Versions.materialEditText}"
    val materialFabSpeedDial = "com.github.kobakei:MaterialFabSpeedDial:${Versions.materialFabSpeedDial}"
    val materialSearchBar = "com.github.mancj:MaterialSearchBar:${Versions.materialSearchBar}"
    val materialSpinner = "com.jaredrummler:material-spinner:${Versions.materialSpinner}"
    val multiLineRadioGroup = "com.github.Gavras:MultiLineRadioGroup:${Versions.multiLineRadioGroup}"
    val mvRx = "com.airbnb.android:mvrx:${Versions.mvRx}"
    val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val passcodeView = "in.arjsna:passcodeview:${Versions.passcodeView}"
    val persistentSearch = "com.quinny898.library.persistentsearch:library:${Versions.persistentSearch}"
    val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
    val pugNotification = "com.github.halysongoncalves:pugnotification:${Versions.pugNotification}"
    val quantum = "io.sellmair:quantum:${Versions.quantum}"
    val quantumLiveData = "io.sellmair:quantum-livedata:${Versions.quantum}"
    val quantumRx = "io.sellmair:quantum-rx:${Versions.quantum}"
    val reactiveLocation = "pl.charmas.android:android-reactive-location2:${Versions.reactiveLocation2}@aar"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomRxJava2 = "androidx.room:room-rxjava2:${Versions.room}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Versions.rxBinding}"
    val rxBindingAppCompat = "com.jakewharton.rxbinding3:rxbinding-appcompat:${Versions.rxBinding}"
    val rxBindingCore = "com.jakewharton.rxbinding3:rxbinding-core:${Versions.rxBinding}"
    val rxBindingDrawerLayout = "com.jakewharton.rxbinding3:rxbinding-drawerlayout:${Versions.rxBinding}"
    val rxBindingLeanback = "com.jakewharton.rxbinding3:rxbinding-leanback:${Versions.rxBinding}"
    val rxBindingMaterial = "com.jakewharton.rxbinding3:rxbinding-material:${Versions.rxBinding}"
    val rxBindingRecyclerView = "com.jakewharton.rxbinding3:rxbinding-recyclerview:${Versions.rxBinding}"
    val rxBindingSlidingPaneLayout = "com.jakewharton.rxbinding3:rxbinding-slidingpanelayout:${Versions.rxBinding}"
    val rxBindingSwipeRefreshLayout = "com.jakewharton.rxbinding3:rxbinding-swiperefreshlayout:${Versions.rxBinding}"
    val rxBindingViewPager = "com.jakewharton.rxbinding3:rxbinding-viewpager:${Versions.rxBinding}"
    val rxPermission = "com.github.vanniktech:RxPermission:${Versions.rxPermissions}"
    val searchDialog = "com.github.mirrajabi:search-dialog:${Versions.searchDialog}"
    val simpleAuthFacebook = "com.jaychang:simpleauth-facebook:${Versions.simpleAuthFacebook}"
    val simpleBarcodeScanner = "com.github.bobekos:SimpleBarcodeScanner:${Versions.simpleBarcodeScanner}"
    val smartLocation = "io.nlopez.smartlocation:library:${Versions.smartLocation}"
    val smartScheduler = "io.hypertrack:smart-scheduler:${Versions.smartScheduler}"
    val soLoader = "com.facebook.soloader:soloader:${Versions.soLoader}"
    val spinKit = "com.github.ybq:Android-SpinKit:${Versions.spinkit}"
    val splittiesActivities = "com.louiscad.splitties:splitties-activities:${Versions.splitties}"
    val splittiesAlertdialog = "com.louiscad.splitties:splitties-alertdialog:${Versions.splitties}"
    val splittiesAlertdialogAppcompat = "com.louiscad.splitties:splitties-alertdialog-appcompat:${Versions.splitties}"
    val splittiesAlertdialogAppcompatCoroutines =
            "com.louiscad.splitties:splitties-alertdialog-appcompat-coroutines:${Versions.splitties}"
    val splittiesAppctx = "com.louiscad.splitties:splitties-appctx:${Versions.splitties}"
    val splittiesArchLifecycle = "com.louiscad.splitties:splitties-arch-lifecycle:${Versions.splitties}"
    val splittiesArchRoom = "com.louiscad.splitties:splitties-arch-room:${Versions.splitties}"
    val splittiesBitflags = "com.louiscad.splitties:splitties-bitflags:${Versions.splitties}"
    val splittiesBundle = "com.louiscad.splitties:splitties-bundle:${Versions.splitties}"
    val splittiesCheckedlazy = "com.louiscad.splitties:splitties-checkedlazy:${Versions.splitties}"
    val splittiesCollections = "com.louiscad.splitties:splitties-collections:${Versions.splitties}"
    val splittiesDimensions = "com.louiscad.splitties:splitties-dimensions:${Versions.splitties}"
    val splittiesExceptions = "com.louiscad.splitties:splitties-exceptions:${Versions.splitties}"
    val splittiesFragmentargs = "com.louiscad.splitties:splitties-fragmentargs:${Versions.splitties}"
    val splittiesFragments = "com.louiscad.splitties:splitties-fragments:${Versions.splitties}"
    val splittiesInitprovider = "com.louiscad.splitties:splitties-initprovider:${Versions.splitties}"
    val splittiesIntents = "com.louiscad.splitties:splitties-intents:${Versions.splitties}"
    val splittiesLifecycleCoroutines = "com.louiscad.splitties:splitties-lifecycle-coroutines:${Versions.splitties}"
    val splittiesMainHandler = "com.louiscad.splitties:splitties-mainhandler:${Versions.splitties}"
    val splittiesMainthread = "com.louiscad.splitties:splitties-mainthread:${Versions.splitties}"
    val splittiesMaterialColors = "com.louiscad.splitties:splitties-material-colors:${Versions.splitties}"
    val splittiesMaterialLists = "com.louiscad.splitties:splitties-material-lists:${Versions.splitties}"
    val splittiesPermissions = "com.louiscad.splitties:splitties-permissions:${Versions.splitties}"
    val splittiesPreferences = "com.louiscad.splitties:splitties-preferences:${Versions.splitties}"
    val splittiesResources = "com.louiscad.splitties:splitties-resources:${Versions.splitties}"
    val splittiesSnackbar = "com.louiscad.splitties:splitties-snackbar:${Versions.splitties}"
    val splittiesSystemservices = "com.louiscad.splitties:splitties-systemservices:${Versions.splitties}"
    val splittiesToast = "com.louiscad.splitties:splitties-toast:${Versions.splitties}"
    val splittiesTypesaferecyclerview = "com.louiscad.splitties:splitties-typesaferecyclerview:${Versions.splitties}"
    val splittiesViews = "com.louiscad.splitties:splitties-views:${Versions.splitties}"
    val splittiesViewsAppcompat = "com.louiscad.splitties:splitties-views-appcompat:${Versions.splitties}"
    val splittiesViewsCardview = "com.louiscad.splitties:splitties-views-cardview:${Versions.splitties}"
    val splittiesViewsCoroutines = "com.louiscad.splitties:splitties-views-coroutines:${Versions.splitties}"
    val splittiesViewsCoroutinesMaterial =
            "com.louiscad.splitties:splitties-views-coroutines-material:${Versions.splitties}"
    val splittiesViewsDsl = "com.louiscad.splitties:splitties-views-dsl:${Versions.splitties}"
    val splittiesViewsDslAppcompat = "com.louiscad.splitties:splitties-views-dsl-appcompat:${Versions.splitties}"
    val splittiesViewsDslConstraintlayout =
            "com.louiscad.splitties:splitties-views-dsl-constraintlayout:${Versions.splitties}"
    val splittiesViewsDslCoordinatorlayout =
            "com.louiscad.splitties:splitties-views-dsl-coordinatorlayout:${Versions.splitties}"
    val splittiesViewsDslMaterial = "com.louiscad.splitties:splitties-views-dsl-material:${Versions.splitties}"
    val splittiesViewsDslRecyclerview = "com.louiscad.splitties:splitties-views-dsl-recyclerview:${Versions.splitties}"
    val splittiesViewsMaterial = "com.louiscad.splitties:splitties-views-material:${Versions.splitties}"
    val splittiesViewsRecyclerview = "com.louiscad.splitties:splitties-views-recyclerview:${Versions.splitties}"
    val splittiesViewsSelectable = "com.louiscad.splitties:splitties-views-selectable:${Versions.splitties}"
    val splittiesViewsSelectableAppcompat =
            "com.louiscad.splitties:splitties-views-selectable-appcompat:${Versions.splitties}"
    val splittiesViewsSelectableConstraintlayout =
            "com.louiscad.splitties:splitties-views-selectable-constraintlayout:${Versions.splitties}"
    val spotsDialog = "com.github.d-max:spots-dialog:${Versions.spotsdialog}@aar"
    val stateViews = "com.github.kobeumut:StateViews:${Versions.stateViews}"
    val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    val stethoOkHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    val stickyTimelineView = "com.github.sangcomz:StickyTimeLine:${Versions.stickyTimelineView}"
    val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
    val swipeRevealLayout = "com.chauthai.swipereveallayout:swipe-reveal-layout:${Versions.swipeRevealLayout}"
    val textViewDotsAnimation = "com.github.rajputkapil:textviewdotsanimation:${Versions.textViewDotsAnimation}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val viewAnimator = "com.github.florent37:viewanimator:${Versions.viewAnimator}"
    val workManagerKtx = "androidx.work:work-runtime-ktx:${Versions.workManager}"
    val workManagerRx = "androidx.work:work-rxjava2:${Versions.workManager}"
}

object AndroidKaptDeps {
    val core = listOf(
            "androidx.room:room-compiler:${Versions.room}"
    )

    val epoxy = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
    val litho = "com.facebook.litho:litho-processor:${Versions.litho}"
    val lithoSections = "com.facebook.litho:litho-sections-processor:${Versions.litho}"
}

object TestDeps {
    val core = listOf(
            "org.jacoco:org.jacoco.agent:0.7.9:runtime",
            "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}",
            "io.mockk:mockk:${Versions.mockK}",
            "org.bigtesting:fixd:${Versions.fixd}",
            "org.koin:koin-test:${Versions.koin}",
            "se.lovef:kotlin-assert-utils:${Versions.kotlinAssertUtils}",
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    )

    val androidCore = core + listOf(
            "androidx.room:room-testing:${Versions.room}",
            "androidx.test:core:${Versions.testCore}",
            "org.robolectric:robolectric:${Versions.robolectric}"
    )

    val ktorServer = "io.ktor:ktor-server-tests:${Versions.ktor}"
}

object JavaFxTestDeps {
    val core = listOf(
            "org.testfx:testfx-junit:${Versions.testFx}"
    )
}

object AndroidTestDeps {
    val core = listOf(
            "androidx.test.espresso:espresso-contrib:${Versions.espresso}",
            "androidx.test.espresso:espresso-intents:${Versions.espresso}",
            "androidx.test:rules:${Versions.testRules}"
    ) + TestDeps.androidCore.filterNot { it.contains("org.robolectric:robolectric") }

    val barista = "com.schibsted.spain:barista:${Versions.barista}"
    val testOrchestrator = "androidx.test:orchestrator:${Versions.testRules}"
}

object JSDeps {
    val coroutinesJs = "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${Versions.coroutines}"
    val unoxCoreAndroid = "com.github.icarohs7:unoxcore-js:${Versions.unoxCore}"
}

object Versions {
    val androidSpeedDial = "3.1.0"
    val androidToggle = "1.1.0"
    val androidxCore = "1.1.0-rc02"
    val androidxPreference = "1.1.0"
    val anko = "0.10.8"
    val anotherViewPager = "1.0.2"
    val appCompat = "1.1.0-rc01"
    val arrow = "0.9.0"
    val awsPlatform = "1.11.228"
    val bluetoothKit = "0.3.1"
    val bungee = "master-SNAPSHOT"
    val checkableChipView = "1.0.3"
    val chucker = "3.0.1"
    val circularImageView = "1.4"
    val clikt = "1.7.0"
    val coil = "0.7.0"
    val constraintLayout = "2.0.0-beta2"
    val coroutines = "1.3.1"
    val crunchyCalendar = "2.0.0"
    val cryptoPrefs = "1.3.2.5"
    val currencyEditText = "2.0.2"
    val disposer = "2.0.0"
    val drawableToolbox = "1.0.7"
    val epoxy = "3.7.0"
    val expansionPanel = "1.2.2"
    val exposed = "0.17.3"
    val firebaseCore = "17.2.0"
    val firebaseFirestore = "21.0.0"
    val firebaseMessaging = "20.0.0"
    val firebaseStorage = "19.0.0"
    val flashBar = "1.0.3"
    val flexboxLayout = "1.1.0"
    val floatingSearchView = "2.1.1"
    val fragment = "1.2.0-alpha03"
    val fuel = "2.0.0"
    val fullscreenDialog = "1.0.0"
    val glide = "4.8.0"
    val googlePlayCore = "1.6.3"
    val googlePlayServicesLocation = "17.0.0"
    val googlePlayServicesMaps = "17.0.0"
    val googlePlayServicesPlaces = "17.0.0"
    val gson = "2.8.5"
    val helloCharts = "v1.5.8"
    val iconicsFontAwesome = "5.3.1.1"
    val iconicsMaterial = "2.2.0.5"
    val iconicsMaterialOriginal = "3.0.1.3.original"
    val ikonli = "2.4.0"
    val inputMask = "4.3.1"
    val jFoenix = "8.0.9"
    val jodaTime = "2.10.3"
    val kaml = "0.8.0"
    val kFormMaster = "6.1.1"
    val khronos = "0.9.0"
    val kidAdapter = "1.1.5"
    val kodaTime = "2.0.0"
    val koin = "2.0.1"
    val kotlin = "1.3.50"
    val kotlinEvents = "v2.0"
    val kotlinFlowExtensions = "0.0.2"
    val kotlinxSerialization = "0.13.0"
    val kotpref = "2.9.1"
    val ktor = "1.2.4"
    val lifecycle = "2.2.0-alpha04"
    val lightCalendarView = "1.0.1"
    val litho = "0.30.0"
    val logback = "1.2.3"
    val maskEditText = "1.1.1"
    val materialComponents = "1.1.0-alpha10"
    val materialDialogs = "3.1.1"
    val materialDrawer = "6.1.2"
    val materialDrawerKt = "2.0.2"
    val materialEditText = "2.1.4"
    val materialFabSpeedDial = "2.0.0-RC1"
    val materialSearchBar = "0.8.2"
    val materialSpinner = "1.3.1"
    val multiLineRadioGroup = "1.0.0.6"
    val mvRx = "1.1.0"
    val navigation = "2.2.0-alpha02"
    val okHttp = "4.2.0"
    val okio = "2.2.2"
    val passcodeView = "1.2.1"
    val persistentSearch = "1.1.0-SNAPSHOT"
    val picasso = "2.71828"
    val pugNotification = "1.8.1"
    val quantum = "1.0.0"
    val reactiveLocation2 = "2.1"
    val recyclerView = "1.1.0-beta04"
    val retrofit = "2.6.1"
    val retrofitKotlinxSerializationConverter = "0.4.0"
    val room = "2.2.0-rc01"
    val rxAndroid = "2.1.1"
    val rxBinding = "3.0.0-alpha2"
    val rxJava = "2.2.12"
    val rxKotlin = "2.3.0"
    val rxPermissions = "0.7.0"
    val rxRelay = "2.1.0"
    val searchDialog = "1.2.3"
    val simpleAuthFacebook = "2.1.4"
    val simpleBarcodeScanner = "1.0.23"
    val smartLocation = "3.3.3"
    val smartScheduler = "0.0.14"
    val snakeYaml = "1.23"
    val soLoader = "0.5.1"
    val spinkit = "1.4.0"
    val splitties = "3.0.0-alpha06"
    val spotsdialog = "1.1"
    val stateViews = "0.5"
    val stetho = "1.5.1"
    val stickyTimelineView = "v0.0.20"
    val swipeRefreshLayout = "1.1.0-alpha02"
    val swipeRevealLayout = "1.4.1"
    val textViewDotsAnimation = "v1.0"
    val timber = "4.7.1"
    val tornadoFx = "1.7.19"
    val unoxCore = "3.20-next.2"
    val unoxJavafxArch = "0.10-next.1"
    val viewAnimator = "1.1.1"
    val workManager = "2.2.0"

    val barista = "3.1.0"
    val fixd = "1.0.5"
    val jacoco = "0.8.4"
    val kotlinAssertUtils = "0.9.0"
    val mockK = "1.9.2"
    val robolectric = "4.3"
    val testCore = "1.2.0"
    val testFx = "4.0.16-alpha"

    val espresso = "3.2.0"
    val testRules = "1.2.0"
}