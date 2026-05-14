# 🌍 Full Working Kotlin Code — Country List App (Jetpack Compose)

This app includes:

✅ LazyColumn
✅ Country Cards
✅ Flag Images from drawable
✅ Row & Column layouts
✅ Material 3 Card Design
✅ 10 Countries List
✅ Modern Jetpack Compose UI

---

# 📁 Project Structure

```plaintext id="3kcv2x"
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
│   ├── france.png
│   ├── canada.png
│   ├── brazil.png
│   ├── india.png
│   ├── italy.png
│   └── australia.png
```

> Put all country flag images inside the `drawable` folder.

---

# 📦 Country.kt

```kotlin id="g6a93d"
package com.example.countrylistapp

data class Country(
    val flag: Int,
    val name: String,
    val capital: String,
    val currency: String
)
```

---

# 🚀 MainActivity.kt

```kotlin id="l5j2fn"
package com.example.countrylistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CountryListApp()
        }
    }
}

@Composable
fun CountryListApp() {

    val countries = listOf(

        Country(
            R.drawable.turkey,
            "Turkey",
            "Ankara",
            "Turkish Lira"
        ),

        Country(
            R.drawable.usa,
            "United States",
            "Washington D.C.",
            "US Dollar"
        ),

        Country(
            R.drawable.japan,
            "Japan",
            "Tokyo",
            "Yen"
        ),

        Country(
            R.drawable.germany,
            "Germany",
            "Berlin",
            "Euro"
        ),

        Country(
            R.drawable.france,
            "France",
            "Paris",
            "Euro"
        ),

        Country(
            R.drawable.canada,
            "Canada",
            "Ottawa",
            "Canadian Dollar"
        ),

        Country(
            R.drawable.brazil,
            "Brazil",
            "Brasília",
            "Brazilian Real"
        ),

        Country(
            R.drawable.india,
            "India",
            "New Delhi",
            "Indian Rupee"
        ),

        Country(
            R.drawable.italy,
            "Italy",
            "Rome",
            "Euro"
        ),

        Country(
            R.drawable.australia,
            "Australia",
            "Canberra",
            "Australian Dollar"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        items(countries) { country ->

            CountryCard(country)
        }
    }
}

@Composable
fun CountryCard(country: Country) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        elevation = CardDefaults.cardElevation(6.dp),

        shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            // Flag Image
            Image(
                painter = painterResource(id = country.flag),
                contentDescription = country.name,

                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(12.dp)),

                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Country Details
            Column {

                Text(
                    text = country.name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Capital: ${country.capital}",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Currency: ${country.currency}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
```

---

# 📱 UI Preview


---

# 🎨 Features Explained

## 📜 LazyColumn

```kotlin id="l5z7v3"
LazyColumn()
```

Efficiently renders scrolling lists.

---

## 🪪 Card Component

```kotlin id="pj7y2d"
Card()
```

Used to display each country beautifully.

---

## 🏳️ Flag Images

```kotlin id="m1aqw4"
Image()
```

Loads flag images from drawable resources.

---

## ↔️ Row Layout

```kotlin id="mxs7h0"
Row()
```

Places image and text side-by-side.

---

## ↕️ Column Layout

```kotlin id="sj5k2v"
Column()
```

Stacks country details vertically.

---

# 🎯 Example Output

```plaintext id="r4v3p0"
🇹🇷 Turkey
Capital: Ankara
Currency: Turkish Lira

🇯🇵 Japan
Capital: Tokyo
Currency: Yen
```

---

# ⭐ Next Upgrade Available

I can also create:

✅ Search Bar
✅ Clickable Country Details
✅ Animated Cards
✅ API-based Country App
✅ Dark Mode
✅ Grid Layout Version
✅ MVVM Architecture Version

Just say **upgrade country app** 👍
