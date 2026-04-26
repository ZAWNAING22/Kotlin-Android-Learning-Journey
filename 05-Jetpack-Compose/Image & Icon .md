In **Jetpack Compose**, **Image** and **Icon** are both used to show visuals, but they have different purposes.

---

# 🖼️ 1. Image in Jetpack Compose

Used to display:

* Photos
* PNG/JPG/WebP files
* Background images
* Network images
* User profile pictures

### Basic Syntax

```kotlin
Image(
    painter = painterResource(id = R.drawable.cat),
    contentDescription = "Cat Image"
)
```

### Example

```kotlin
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile Picture"
    )
}
```



## Important Parameters of Image

```kotlin
Image(
    painter = ...,
    contentDescription = ...,
    modifier = Modifier.size(100.dp),
    contentScale = ContentScale.Crop
)
```

### Meaning:

| Parameter          | Use                    |
| ------------------ | ---------------------- |
| painter            | image source           |
| contentDescription | accessibility text     |
| modifier           | size, padding, shape   |
| contentScale       | fit/crop/stretch image |

---

## ContentScale Types

| Type       | Meaning              |
| ---------- | -------------------- |
| Crop       | Fill area, cut extra |
| Fit        | Show full image      |
| FillBounds | Stretch              |
| Inside     | Fit inside box       |

---

# ⭐ 2. Icon in Jetpack Compose

Used for:

* Buttons
* Settings
* Search
* Delete
* Favorite
* Navigation

Usually vector icons.

### Basic Syntax

```kotlin
Icon(
    imageVector = Icons.Default.Home,
    contentDescription = "Home"
)
```

### Example

```kotlin
@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Like",
        tint = Color.Red
    )
}
```



# Important Parameters of Icon

```kotlin
Icon(
    imageVector = Icons.Default.Search,
    contentDescription = "Search",
    tint = Color.Blue,
    modifier = Modifier.size(30.dp)
)
```

| Parameter          | Use           |
| ------------------ | ------------- |
| imageVector        | icon image    |
| tint               | icon color    |
| modifier           | size/padding  |
| contentDescription | accessibility |

---

# 🆚 Image vs Icon

| Image                    | Icon                  |
| ------------------------ | --------------------- |
| Real picture/photo       | Small symbol          |
| JPG/PNG/WebP             | Vector                |
| Used for gallery/profile | Used for buttons/menu |
| Can be large             | Usually small         |

---

# 🔥 Real App Example

```kotlin
Row {
    Image(
        painter = painterResource(R.drawable.user),
        contentDescription = "User",
        modifier = Modifier.size(60.dp)
    )

    Icon(
        imageVector = Icons.Default.Settings,
        contentDescription = "Settings"
    )
}
```

➡ User photo + settings icon

---

# 📌 Where You'll Use in Apps

### Image:

* Food delivery app food photo
* Instagram post
* User avatar
* Product image

### Icon:

* Search button
* Back arrow
* Delete item
* Favorite heart
* Bottom navigation

---

# ⚡ Important Imports

```kotlin
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
```

---

# 🚀 Next Level (Very Important)

Later learn:

* `IconButton()`
* `AsyncImage()` (load internet image)
* Rounded profile image
* Clickable icons
* Animated icons

---

