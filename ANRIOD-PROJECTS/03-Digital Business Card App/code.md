# 💼 Full Working Kotlin Code — Digital Business Card App (Jetpack Compose)

This app includes:

✅ Gray background Column
✅ Profile Image
✅ Full Name
✅ Profession Title
✅ Contact Info using Rows
✅ Custom Button
✅ Rounded Corners
✅ Toast Message on Click

---

# 📁 Project Structure

```plaintext
com.example.businesscardapp
│
├── MainActivity.kt
│
├── res/drawable/
│   └── profile.png
```

> Put your profile image inside **res/drawable** folder as `profile.png`

---

# 🚀 MainActivity.kt

```kotlin
package com.example.businesscardapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clip
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusinessCardApp()
        }
    }
}

@Composable
fun BusinessCardApp() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBDBDBD))
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Image",

            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape),

            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Full Name
        Text(
            text = "ZAW NAING",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Profession
        Text(
            text = "Android Developer",
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Contact Info Row 1
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Phone: ",
                fontWeight = FontWeight.Bold
            )

            Text(text = "+90 555 123 4567")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Contact Info Row 2
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Email: ",
                fontWeight = FontWeight.Bold
            )

            Text(text = "zawnaing@email.com")
        }

        Spacer(modifier = Modifier.height(35.dp))

        // Button
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Thanks for contacting me!",
                    Toast.LENGTH_SHORT
                ).show()
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1976D2)
            ),

            shape = RoundedCornerShape(16.dp),

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Get in Touch",
                fontSize = 18.sp
            )
        }
    }
}
```

---

# 📱 UI Preview


---

# 🎨 Customize Easily

## Change Name

```kotlin
text = "Your Name"
```

## Change Profession

```kotlin
text = "Software Engineer"
```

## Change Button Color

```kotlin
containerColor = Color.Red
```

## Change Button Radius

```kotlin
RoundedCornerShape(25.dp)
```

---

