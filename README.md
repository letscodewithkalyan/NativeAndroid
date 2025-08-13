# MyNotes

Initial Architecture for android app using MVVM, Kotlin, Hilt, Retrofit and Kotlin Coroutines for Dependency Injection

# AndroidArc

A modern Android application built using **Kotlin**, following **Clean Architecture** and **MVVM** principles.  
The project is modular, scalable, and leverages best practices for Android development.

## 🚀 Features

- **Clean Architecture** with separation of concerns (data and presentation layers)
- **MVVM** (Model-View-ViewModel) for state management
- **Dependency Injection** using Hilt
- **Room Database** for local persistence
- **Retrofit** for network communication
- **Coroutines & Flow** for asynchronous programming
- **Repository Pattern** for data handling
- **Interceptor-based authentication** for secure API calls

## 🛠️ Tech Stack

- **Language**: Kotlin
- **Architecture**: Clean Architecture + MVVM
- **Dependency Injection**: Hilt
- **Networking**: Retrofit, OkHttp
- **Database**: Room
- **Coroutines**: Kotlin Coroutines & Flow
- **UI**: Jetpack Compose / XML (as needed)

## 📦 Modules Overview

- **Core**: Application-wide constants and utilities
- **Data Layer**:
  - Local data sources using Room (DAO, entities, database)
  - Remote data sources using Retrofit (API services, models)
  - Repository implementations
- **Dependency Injection**: Modules for providing database, network, and repository dependencies
- **Presentation Layer**:
  - ViewModels for business logic
  - Views (Activities, Fragments, UI components)
  - Adapters for lists and other UI bindings
