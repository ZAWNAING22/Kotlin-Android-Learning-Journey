Jetpack Compose is Android’s **modern UI toolkit**. Instead of XML layouts, you build UI using **Kotlin functions** called **Composable functions**.

---

# 📌 1. What is Composable?

A **Composable** is a special Kotlin function that describes part of the UI.

It uses `@Composable` annotation.

```kotlin
@Composable
fun Greeting() {
    Text("Hello World")
}
```

### ✅ Meaning:

* `Greeting()` creates UI.
* `Text()` is also a composable.
* Compose combines many composables to build screen.

Think like LEGO blocks:

* `Text()` = small block
* `Button()` = block
* `Column()` = layout block
* Combine them = complete app screen

---

# 📌 2. Why Composable?

Old Android:

```xml
<TextView />
<Button />
```

New Compose:

```kotlin
Text("Hello")
Button(onClick = {}) { Text("Click") }
```

Everything is Kotlin code.

---

# 📌 3. Common Composables
### UI Elements:

```kotlin
Text()
Button()
Image()
TextField()
Card()
Checkbox()
Switch()
```

### Layouts:

```kotlin
Column()
Row()
Box()
LazyColumn()
LazyRow()
```

---

# 📌 4. Attributes (Parameters) of Composable

Composable functions accept **parameters** (attributes).

Example:

```kotlin
Text(
    text = "Hello",
    color = Color.Red,
    fontSize = 24.sp
)
```

### Here:

| Attribute | Meaning      |
| --------- | ------------ |
| text      | what to show |
| color     | text color   |
| fontSize  | size         |

---

# 📌 5. Important Common Attributes

## 🔹 Modifier

Most important attribute.

Used for:

* size
* padding
* background
* click
* alignment
* border

Example:

```kotlin
Text(
    text = "Hello",
    modifier = Modifier
        .padding(16.dp)
        .background(Color.Yellow)
)
```

---

## 🔹 onClick

Used in Button:

```kotlin
Button(
    onClick = { }
) {
    Text("Press")
}
```

---

## 🔹 content

Children inside composable.

```kotlin
Button(onClick = {}) {
    Text("Login")
}
```

---

# 📌 6. Layouts in Compose

Layouts arrange UI items.

---

# 🔷 Column

Vertical layout (Top → Bottom)

```kotlin
Column {
    Text("Name")
    Text("Age")
}
```
![Image](https://images.openai.com/static-rsc-4/rpZXcNNv2YDAawxQ4iBBAjm8Yy6kSFN4ds4BPTjJBUdEbvHok8jcstOBJVjqmNBg0vtAOJ_4wwFcDSTKpTT5xZic-4kV8o2zBwpXAoODei9cYV3a362bUAkGos51IOoM_PzDEXCZ4nkaKkF4P1isZAV3UJN4F-8x-uCx5imcJaYbVvsHUkubsu8cfheexpd9?purpose=fullsize)

---

# 🔷 Row

Horizontal layout (Left → Right)

```kotlin
Row {
    Text("Yes")
    Text("No")
}
```
---

# 🔷 Box

Stack items on top of each other.

```kotlin
Box {
    Image(...)
    Text("Top Text")
}
```
![Image](https://images.openai.com/static-rsc-4/JPHXv50mack9Q4OoldXrv12e-xY7WIOR4MNRYWqFEwaKu1Hr3VMQSj8gsP5ijMilK-zaTVC6cZar1_jWs4wpp3aZnb7Fzll3HgxZpZY3r3uMIHcogY6H34LqyP-imbz4OMWs98qWTlHi6i2xDKn96CLkzjo-yvWl7KIfwCwUxaFBDFUpIsUMHBvVCuMOfVVi?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/VP2nfmG4yrLG_o1iFdCSoUedZo4D_9SGOc2rVaJ7a_kFO3vhXVB98CpDuNlMgKvUUCxnFFsGRuUS8QnXqkxyERk97rXe0fvPrtUJnyahMEure231cJI8NjfKQ5pABoa-t7MiuGXOXwYv9X1qHeHYXqLWVl0Eht1uWb3g75ymxUnsde6Wee97NWIvpWwY8O3A?purpose=fullsize)

---

# 🔷 LazyColumn

Scrollable vertical list.

```kotlin
LazyColumn {
    items(100) {
        Text("Item $it")
    }
}
```

Used for RecyclerView replacement.

---

# 📌 7. Layout Attributes

## For Column / Row:

```kotlin
Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
)
```

| Attribute           | Meaning             |
| ------------------- | ------------------- |
| verticalArrangement | spacing vertical    |
| horizontalAlignment | horizontal position |

---

# 📌 8. Full Example

```kotlin
@Composable
fun MyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Start")
        }
    }
}
```

---

# 📌 9. Real Life Analogy

Think website HTML:

```html
<div>
   <h1>Hello</h1>
   <button>Click</button>
</div>
```

Compose version:

```kotlin
Column {
   Text("Hello")
   Button{}
}
```

---

# 📌 10. Most Important To Learn First

### Must Know:

✅ Text
✅ Button
✅ Modifier
✅ Column
✅ Row
✅ Box
✅ State (`remember`)
✅ LazyColumn
✅ TextField

---

# 📌 11. One Line Summary

**Composable = Function that builds UI**
**Attributes = Settings of that UI**
**Layouts = How UI items are arranged**

---

