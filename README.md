# SignInAppAndroid 

The SignInAppAndroid  repository contains Android UI tests authored using ComposeTest. PageObject model adopted considering scope to expand further when new features are added in future. 


### Application overview

The target application developed using **JetPack Compose** with Composable screens.
The application contains two screens, Login and MyTfL. Both screens have static data defined in the application. The current Login implementation accepts a combination of email and password, upon accepting the Login credentials App nav controller's logic defined to navigate to MyTfL screen.

### Test Setup overview:

The set up follows **PageObject pattern** and **ComposeTest** to ensure the scalability of the tests when new features are added and to facilitate maintainable test suites.

![Untitled Diagram drawio (2)](https://github.com/user-attachments/assets/9b6011a0-a2bb-4a8e-a8b2-d1d9273dabb4)

 - **BaseTest**  -  BaseTestFromLoginPage launches the MainActivity of the application with default state, i.e, Logged out state. BaseTest uses ActivityScenario from Android Test framework to launch Activity. 
 - **BasePage** - BasePage have implementation of different strategies in locating Compose node elements to perform actions (tap, scroll, swipe etc) and to assert node state (visibility on screen, selected/unselected, text comparison). The framework implementations in BasePage are not dependent on the target application's architecture, however the function implementation is contextual to perform actions and assertions on app's compose node elements.
 - **PageObject (Page files)** - The page classes are implementations on Compose node elements relevant to Target Application, where the class have functions that uses BasePage actions and assertions in performing instrumentation tasks. Each PageObject implementation are independent and is in context of the screen as classified in the application. These PageObject implementations can be used across multiple UI tests. A package level function (e.g, onSomePage()) is also added for simplicity by removing the need of declaring and creating an object in UI test files. This package level function is also helps in binding ComposeTestRule from BaseTest with PageObject implementation to keep a single instance of testRule instrument the application.
 - **UITests** - The tests are derived from BaseTest to launch MainActivity via the setUp function with default state. The tests are exercised using the package level functions from PageObject classes in performing multiple actions and assertions. The package level functions from PageObject classes allows tests to assert and action on expected screens.

### Misc
------
#### Test execution
Tests can be executed using Android Studio from the AndroidTest package from source or from command line using `./gradlew connectedAndroidTest`
#### Activity Animations
To reduce test execution time `animationsDisabled = true` is being added in `build.gradle.kts` test options.
