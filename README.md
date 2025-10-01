# Koin in Android App

This Android application demonstrates how to use **Koin** as a dependency injection (DI) framework instead of **Hilt** or **Dagger**.

---

## What is Koin?

**Koin** is a lightweight dependency injection framework for Kotlin and Android. Unlike Dagger or Hilt, Koin does **not require annotation processing** and is easy to set up. It allows developers to declare dependencies in **Kotlin code** in a clear and concise way.

**Key Features of Koin:**
- Simple and lightweight DI for Kotlin projects.
- No code generation required.
- Fully written in Kotlin DSL.
- Easy integration with Android components like Activities, Fragments, and ViewModels.
- Supports scopes and modules for organized DI.

---

## Project Overview

This project demonstrates:
- Setting up Koin in an Android app.
- Creating modules for dependencies.
- Injecting dependencies into ViewModels, Activities, and Composables.
- Using `koinViewModel()` to get ViewModel instances in Jetpack Compose.
- Replacing Hilt/Dagger with Koin without losing flexibility.
- Using **TheCatAPI** with a secure API key setup.

---

## Tech Stack

- **Language:** Kotlin
- **DI Framework:** Koin
- **UI:** Jetpack Compose
- **Architecture:** MVVM

---

## API Key Setup (TheCatAPI)

1. Sign up and get your API key from [TheCatAPI](https://thecatapi.com).
2. Open your `local.properties` file (in the project root) and add:

```properties
API_KEY="your_cat_api_key_here"

