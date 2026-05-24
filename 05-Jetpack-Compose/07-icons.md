# Icons in Jetpack Compose — Complete Combined Notes

In Jetpack Compose, **Icons** are small graphical symbols used to visually represent:

* actions
* navigation
* status
* content

Examples:

* 🔍 Search
* ❤️ Favorite
* ⚙️ Settings
* 🏠 Home
* ➕ Add

Icons improve:

* UI readability
* user experience
* app appearance

---

# 1. Types of Icons

## A) Built-in Material Icons

Provided by Material Design.

Examples:

* Home
* Search
* Favorite
* Settings
* Delete

---

## B) Custom Vector Icons

Imported SVG/XML vector assets.

---

## C) Image-based Icons

PNG/JPG/WebP images used as icons.

---

# 2. Dependencies

## Material 2

```kotlin
implementation("androidx.compose.material:material-icons-extended")
```

---

## Material 3

```kotlin
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material:material-icons-extended")
```

---

# 3. Required Imports

## Filled Icons

```kotlin
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
```

---

## Outlined Icons

```kotlin
import androidx.compose.material.icons.outlined.*
```

---

## Rounded Icons

```kotlin
import androidx.compose.material.icons.rounded.*
```

---

## Sharp Icons

```kotlin
import androidx.compose.material.icons.sharp.*
```

---

# 4. Basic Icon Syntax

```kotlin
Icon(
    imageVector = Icons.Default.Home,
    contentDescription = "Home"
)
```

---

# 5. Main Parameters

| Parameter            | Purpose               |
| -------------------- | --------------------- |
| `imageVector`        | Which icon to display |
| `contentDescription` | Accessibility text    |
| `tint`               | Icon color            |
| `modifier`           | Size, padding, etc    |

---

# 6. imageVector

Defines the icon.

```kotlin
imageVector = Icons.Default.Home
```

Examples:

```kotlin
Icons.Default.Home
Icons.Default.Search
Icons.Default.Settings
Icons.Default.Delete
```

---

# 7. contentDescription

Used for accessibility (screen readers).

```kotlin
contentDescription = "Settings"
```

Decorative icon:

```kotlin
contentDescription = null
```

---

# 8. tint (Color)

Changes icon color.

```kotlin
Icon(
    imageVector = Icons.Default.Favorite,
    contentDescription = null,
    tint = Color.Red
)
```

---

# 9. modifier

Controls:

* size
* padding
* rotation
* click behavior

Example:

```kotlin
modifier = Modifier.size(40.dp)
```

Full example:

```kotlin
Icon(
    imageVector = Icons.Default.Settings,
    contentDescription = "Settings",
    modifier = Modifier.size(32.dp)
)
```

---

# 10. Complete Basic Example

```kotlin
@Composable
fun MyIcon() {

    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorite",
        tint = Color.Red,
        modifier = Modifier.size(40.dp)
    )
}
```

---

# 11. Multiple Icons Example

```kotlin
@Composable
fun IconExample() {

    Row {

        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite",
            tint = Color.Red,
            modifier = Modifier.size(30.dp)
        )
    }
}
```

---

# 12. Icon Styles

## Filled

```kotlin
Icons.Filled.Home
```

Solid icons.

---

## Outlined

```kotlin
Icons.Outlined.Home
```

Border-only style.

---

## Rounded

```kotlin
Icons.Rounded.Face
```

Rounded corners.

---

## Sharp

```kotlin
Icons.Sharp.Delete
```

Sharp edges.

---

## TwoTone

```kotlin
Icons.TwoTone.Settings
```

Two-color style.

---

# 13. Clickable Icons

Use `IconButton()`.

```kotlin
IconButton(
    onClick = { }
) {

    Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = "Delete"
    )
}
```

Used for:

* back buttons
* menu buttons
* delete buttons
* favorite buttons

---

# 14. Icon Inside Button

```kotlin
Button(onClick = {}) {

    Icon(
        imageVector = Icons.Default.Add,
        contentDescription = null
    )

    Spacer(modifier = Modifier.width(8.dp))

    Text("Add")
}
```

---

# 15. Icons in TextField

## Search Bar Example

```kotlin
TextField(
    value = "",
    onValueChange = {},

    leadingIcon = {
        Icon(Icons.Default.Search, null)
    }
)
```

---

# 16. Bottom Navigation Icons

```kotlin
BottomNavigationItem(
    selected = true,
    onClick = { },

    icon = {
        Icon(
            Icons.Default.Home,
            contentDescription = "Home"
        )
    }
)
```

---

# 17. Custom Vector Icons

## Import Vector Asset

Android Studio:

```text
Right Click res
→ New
→ Vector Asset
```

---

## Use Custom Icon

```kotlin
Icon(
    painter = painterResource(id = R.drawable.my_icon),
    contentDescription = null
)
```

---

# 18. Using Image as Icon

```kotlin
Icon(
    painter = painterResource(R.drawable.profile),
    contentDescription = null
)
```

---

# 19. Difference Between Icon and Image

| Icon               | Image              |
| ------------------ | ------------------ |
| Small UI symbol    | Real picture/photo |
| Usually vector     | PNG/JPG/WebP       |
| Represents actions | Displays content   |
| Lightweight        | Larger files       |

Examples:

* Icon → ⚙️ Settings
* Image → User profile photo

---

# 20. Most Common Icons

| Purpose  | Code                      |
| -------- | ------------------------- |
| Home     | `Icons.Default.Home`      |
| Search   | `Icons.Default.Search`    |
| Favorite | `Icons.Default.Favorite`  |
| Settings | `Icons.Default.Settings`  |
| Add      | `Icons.Default.Add`       |
| Delete   | `Icons.Default.Delete`    |
| Menu     | `Icons.Default.Menu`      |
| Back     | `Icons.Default.ArrowBack` |
| Email    | `Icons.Default.Email`     |
| Person   | `Icons.Default.Person`    |

---

# 21. Real App Usage

| Screen         | Icons             |
| -------------- | ----------------- |
| Login          | email, visibility |
| Navigation Bar | home, search      |
| Toolbar        | menu, back        |
| Chat App       | send, attachment  |
| Shopping App   | cart, favorite    |
| Settings       | gear icon         |

---

# 22. Important Compose Concepts Related to Icons

## A) Vector Graphics

Most Compose icons are vectors:

* scalable
* sharp at all sizes
* lightweight

---

## B) Accessibility

Always use meaningful `contentDescription`.

Good:

```kotlin
contentDescription = "Delete Message"
```

Bad:

```kotlin
contentDescription = "Icon"
```

---

## C) Theming

Icons automatically adapt to:

* dark mode
* Material theme colors

Example:

```kotlin
tint = MaterialTheme.colorScheme.primary
```

---

# 23. Advanced Topics

## Animated Icons

Using:

* `animateFloatAsState`
* `AnimatedVisibility`

---

## Adaptive Icons

Icons changing for:

* theme
* device state

---

## SVG Optimization

Reducing vector complexity for performance.

---

# 24. Common Mistakes

## Missing Dependency

Error:

```text
Unresolved reference: Icons
```

Fix:

```kotlin
implementation("androidx.compose.material:material-icons-extended")
```

---

## Missing Import

Wrong:

```kotlin
Icons.Outlined.Home
```

Without:

```kotlin
import androidx.compose.material.icons.outlined.*
```

---

## Using Null Description Incorrectly

Use `null` only for decorative icons.

---

# 25. Simple Mental Model

```text
Icon() → display icon
IconButton() → clickable icon
Icons.Default → built-in icons
painterResource() → custom icon
modifier → size/style
tint → color
```

---

# 26. Interview/Exam Important Points

You should know:

* What `Icon()` does
* Difference between icon and image
* What `contentDescription` is
* `IconButton()`
* Material icons
* `tint`
* `modifier`
* custom vector assets
* icon styles (Filled, Outlined, Rounded)
