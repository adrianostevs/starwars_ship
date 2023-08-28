# Android App Starwars Ship API
<h1 align="center">Starwars Ship API</h1>
<p align="center">  
A simple Starwars Ship App getting API with Retrofit, maintaining data using LiveData, and Material Design based on architecture.
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous
- [LiveData](https://developer.android.com/reference/android/arch/lifecycle/LiveData)
- Jetpack
  - Lifecycle - Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel - Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - ViewBindings - Binds UI components class for each XML layout file present in that module.
  - [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Architecture
  - MVVM Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.

## Architecture
Starwars Ship App is based on the MVVM Pattern Architecture.

## Open API
Starwars Ship App using the [SWAPI](https://swapi.dev/documentation) for constructing RESTful API.<br>
SWAPI provides a RESTful API interface to highly detailed objects built from thousands of lines of data related to Starwars.
