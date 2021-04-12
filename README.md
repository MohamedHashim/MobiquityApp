# MobiquityApp

it shows list of categorized products and it's details.

App Features
---------------

1- Show all categorized products

2- Show product details

3- Save data locally as offline mode

App Architecture
--------------


MobiquityApp is implemented in Kotlin and the software architectural pattern is MVVM

We care to implement it in clean architecture which separates the application code into layers and these layers define the Separation of Concerns (SOC) inside the codebase

Thanks to clean architecture and jetpack components which enabled me to implement a modular and robust Android app


Github
--------------

I've created a structure for this GitHub repo.

The main branches are Master for production and release & develop which contain all new implemented features but not all sprint features aren't finished yet

Each new feature has its own branch from develop then will be merged into develop and when all sprint features are finished and merged into develop
then we can merge the develop branch into Master branch as a new release to the production


Libraries & Dependencies
------------------------
  * **AppCompat** - Degrade gracefully on older versions of Android.
  * **Android KTX** - Write more concise, idiomatic Kotlin code.
  * **Coroutines** - for managing background threads with simplified code and reducing needs for callbacks
  * **2 way Data Binding with custom attributes** - Declaratively bind observable data to UI elements.
  * **Lifecycles** - Create a UI that automatically responds to lifecycle events.
  * **LiveData** - Build data objects that notify views when the underlying database changes.
  * **ViewModel** - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
  * **Koin** - Dependency Injection to inject networks, repositories and viewModels modules
  * **Retrofit** - For calling APIs
  * **Gson** - API response converter
  * **Navigation** - To navigate between fragments
  * **Room** - To Save data locally
  * **Fragment** - A basic unit of composable UI.
  * **leakcanary** - To catch all memory leaks
  * **Junit** - For unit testing
  * **Mockito** - To mock data
