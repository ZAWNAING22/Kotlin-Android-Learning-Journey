# 🌍 Country List App (Jetpack Compose + LazyColumn)

A modern Android application built using **Kotlin** and **Jetpack Compose** that displays a list of countries using a high-performance `LazyColumn`.

The app demonstrates modern Android UI development concepts such as:

✅ LazyColumn
✅ Card Components
✅ Row & Column Layouts
✅ Drawable Resources
✅ Image Handling
✅ Modern Material 3 Design

---

# 📚 Assignment Overview

### 📌 Objective

Develop an Android application using **Jetpack Compose** that displays information about 10 countries around the world.

Each country item must include:

* 🏳️ Country Flag
* 🌍 Country Name
* 🏙️ Capital City
* 💰 Currency

The application must use a **LazyColumn** for efficient list rendering.

---

# 🚀 Features

✅ High-performance scrolling with `LazyColumn`
✅ Beautiful country cards using `Card`
✅ Flag images loaded from `drawable`
✅ Modern Compose UI
✅ Row & Column layout hierarchy
✅ Clean Material 3 design

---

# 🧩 Components Used

| Feature           | Compose Component |
| ----------------- | ----------------- |
| Scrollable List   | `LazyColumn`      |
| Country Container | `Card`            |
| Horizontal Layout | `Row`             |
| Vertical Layout   | `Column`          |
| Flag Display      | `Image`           |
| Text Information  | `Text`            |

---

# 🎨 UI Layout Structure

```mermaid id="w9m8ht"
flowchart TD
    A[LazyColumn 📜] --> B[Country Card 🪪]

    B --> C[Row Layout ↔️]

    C --> D[Flag Image 🏳️]
    C --> E[Country Details 📄]

    E --> F[Country Name 🌍]
    E --> G[Capital City 🏙️]
    E --> H[Currency 💰]
```

---

# 📱 Example UI Preview

![Image](https://images.openai.com/static-rsc-4/50RT4jG1Yosu4bj0p4L7dw3DK_t_G4jToi0OEXsHSTrIATi7bNPEquC5BDx84D3u7G-q2ee1Yq9DPSnZISzS98dFCQozW10K_dMyRIHr-5_SAIh-ltBvuFUCdheqUrbFKDY2l08NVxah3l8kTDEgyD4lPEY5OWy535Tf7DjqNFhuT3ZAobSQqKjU65NI_ajH?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/vNeOKEIbyvvku-IAZ-YMWDJOxvtpJ-BrN2cJfHVns9ZqoXcrx7okgRKiOEV66bPGcQKQcKIAk4BTZ4ouKSAPoCVs-BukMa5c3HFOZks9ULo79GxtpYhYwwTa_IX-1_9an-XfadIewIO8R7rjxZCjorT1UnVJBcSgEZhw_Z4K35NGpyK1xNbdk3Ki4JuUXzmk?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/tzHaJ5mxZZwe2kJ3X8UGb3-pX_ZrEgy23Cmez2BI6uO6Sjs98REW11UgJTfJPjF5t2VOCO58uz1NSn8TjVhqsGeXF4cWNEoPE_ezYNtq1g0BejSbKtTcs86j8aK4Cs7tby9i9WiwwlMMD0Ky5q0JFQxi4kZdk5t3EByzlMhnPv_TOFUaGz2ZGVg49VKCYmZ9?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/H7LjBEOKrVpSqJMUtB6-UXGmSkRzG0hM5E6OK_P-uR7k3CwmFRcJK41mBzMyvcylgwwIyUhweMaRDdKDYpaTpE6dGOvlRAN5J39lTG6_0pKoGiUmLDOADTqyPO9yHANBmfpZDK0Qm_ghRzazHd3jIozjOQoFcxAlnWMU8j5j14nhh9WEkAt4_Sl2-7snxK9t?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/DNq1tSaYsaUJK85j69r2ESBR5IlLWRTUJZ0wISDdJEjNqhyBknDGCa0lMqq6-29QSsEZivHh_1fVAZtnWUtHqorXAL2pmDbldZ6Y6hH_ZoRLU8KOtcw3QwJP9lcOE1j1hlSR1uBugoRrlmxD_wbP9--euZpR-wuufBipMleiH4iWROpEWD_Udnjx2-mFR3tB?purpose=fullsize)

---

# 📁 Project Structure

```plaintext id="4p9m1n"
com.example.countrylistapp
│
├── MainActivity.kt
├── Country.kt
│
├── res/drawable/
│   ├── turkey.png
│   ├── usa.png
│   ├── japan.png
│   ├── germany.png
│   └── ...
│
├── ui/theme/
```

---

# 📦 Data Structure

The country list is created using:

```kotlin id="6px6wp"
listOf()
```

Each country object contains:

```plaintext id="mvlh80"
- Flag Image
- Country Name
- Capital City
- Currency
```

---

# 🔄 Application Workflow

```mermaid id="q4lt5g"
sequenceDiagram
    participant App
    participant LazyColumn
    participant Card
    participant User

    App->>LazyColumn: Load Country List
    LazyColumn->>Card: Create Country Cards
    Card-->>User: Display Country Information
```

---

# 🛠️ Tech Stack

* **Language:** Kotlin 🧩
* **UI Toolkit:** Jetpack Compose 🎨
* **Design:** Material 3 ✨
* **IDE:** Android Studio 🤖

---

# 🎯 Learning Outcomes

This project helps you understand:

* LazyColumn usage
* Efficient list rendering
* Card design in Compose
* Row & Column layouts
* Resource management
* Image loading from drawable
* Building modern Android UIs

---

# 📌 Expected Output

Each country row contains:

✅ Country flag image
✅ Country name
✅ Capital city
✅ Currency information

---

# 🌍 Example Countries

```plaintext id="0d0l7x"
Turkey
United States
Japan
Germany
France
Canada
Brazil
India
Italy
Australia
```

---

# 📌 Future Improvements

* 🔍 Search functionality
* 🌙 Dark mode support
* 🌐 Detailed country screen
* ❤️ Favorite countries feature
* ☁️ API integration for live country data

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub!

---

# 🔥 Next Step Available

I can also provide:

✅ Full working Jetpack Compose code
✅ Modern Material 3 UI
✅ Animated Cards
✅ Search Feature
✅ API-based country app
✅ RecyclerView XML version

Just say **give full code** 👍
