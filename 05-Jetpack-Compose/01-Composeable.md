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
// or
LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.Start,
    contentPadding = PaddingValues(8.dp)
) {
    items(100) { index ->
        Text("Item $index")
    }
}

```
# 🔷 LazyCRow

Scrollable vertical list.

```kotlin
 LazyRow(modifier = Modifier.fillMaxSize()) {
            items(100) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )


        }
```
---
Parameters:

modifier → Same as Column/Row.

verticalArrangement / horizontalArrangement → Same idea as Column/Row.

horizontalAlignment / verticalAlignment → Same idea as Column/Row.

contentPadding → Extra padding around the scrollable content.

items(count) → Defines list items dynamically.

item { } → For a single composable item.
---
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

In Jetpack Compose, **Column / Row / Layout composables** have parameters that control:

✅ Size
✅ Position
✅ Alignment
✅ Spacing
✅ Child arrangement
✅ Styling through `Modifier`

These parameters are very important because layout = how UI items are placed.

---

# 📌 1. Column Parameters

```kotlin id="jlwmqv"
Column(
    modifier = Modifier,
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.Start
) {
   // children
}
```

---

## 🔹 A. modifier

Most used parameter.

Used for:

* padding
* size
* width/height
* background
* click
* border

```kotlin id="3rw5sl"
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
)
```

### Meaning:

* take full screen
* padding 16dp

---

## 🔹 B. verticalArrangement

Controls how children are arranged **top to bottom** inside Column.

```kotlin id="otk0zv"
Column(
    verticalArrangement = Arrangement.Center
)
```

Options:

| Value        | Meaning                 |
| ------------ | ----------------------- |
| Top          | Start from top          |
| Center       | Center vertically       |
| Bottom       | Bottom                  |
| SpaceBetween | Equal gap between items |
| SpaceAround  | Space around each item  |
| SpaceEvenly  | Equal everywhere        |



![Image](https://images.openai.com/static-rsc-4/ho9j9reO83g-cPtoxxVjlJ4LDGZ-wBsSn4qIcFwUYMdHjDXky6QfYQXAcMWFc5_gH97qLkRH_LRH5aZ3-sZ56JcAjgKVXjnJ5j5gDWV8vlCPswFlY3ku4nAxmVov4pTtXKBX5fKB2k41prbILhwMu0BzTxeTqAPBCehbeLBqTYSDei4A5P2HHRWIRZFTrUFt?purpose=fullsize)

---

## 🔹 C. horizontalAlignment

Controls left/right alignment of children.

```kotlin id="jl89se"
Column(
    horizontalAlignment = Alignment.CenterHorizontally
)
```

Options:

| Value              | Meaning |
| ------------------ | ------- |
| Start              | Left    |
| CenterHorizontally | Center  |
| End                | Right   |

---

# 📌 2. Row Parameters

```kotlin id="1r2q2g"
Row(
    modifier = Modifier,
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.Top
) {
}
```

---

## 🔹 A. horizontalArrangement

Controls left → right item placement.

```kotlin id="dg6j8r"
Row(
    horizontalArrangement = Arrangement.SpaceEvenly
)
```

Options same as Column arrangement.

---

## 🔹 B. verticalAlignment

Controls top/bottom alignment inside Row.

```kotlin id="g0yjj5"
Row(
    verticalAlignment = Alignment.CenterVertically
)
```

Options:

| Value            | Meaning |
| ---------------- | ------- |
| Top              | Top     |
| CenterVertically | Middle  |
| Bottom           | Bottom  |

---

# 📌 3. Box Parameters

```kotlin id="w9u6zl"
Box(
    modifier = Modifier,
    contentAlignment = Alignment.Center
      { Text("one")
       Text("two", modifier = Modifier.align(Alignment.BottomCenter))
        Text("three",modifier = Modifier.align(Alignment.BottomStart))
    }
)
```

### contentAlignment

Controls child position inside Box.

Examples:

| Value     | Meaning      |
| --------- | ------------ |
| Center    | Middle       |
| TopStart  | Top left     |
| BottomEnd | Bottom right |

![Image](https://images.openai.com/static-rsc-4/K9GjxwwcVpkNNKjWsM_ArK80sEiFLiNSK-YEHca4mR49WqNobDU347f3-UFB6aOdVTgm0ciJFLwi2QS0MT3T37AuRPOmyim3WmMfQxM4nElDzlFXaOcJPh0dYbn9CCYqiSwtpASwft-nLtsYcUOofKd5YhA1KOp5fzhKn2HMP40tEicASQoFnERAz4fB0y6F?purpose=fullsize)


---

# 📌 4. Important Modifier Parameters Inside Layout

---

## fillMaxSize()

Take full available space.

```kotlin id="xgd5dh"
Modifier.fillMaxSize()
```

---

## fillMaxWidth()

Take full width only.

```kotlin id="4k65zr"
Modifier.fillMaxWidth()
```

---

## weight()

Share space equally.

```kotlin id="gklxyd"
Row {
   Text("A", Modifier.weight(1f))
   Text("B", Modifier.weight(1f))
}
```

Both take equal width.

---

## padding()

Space inside outer border.

```kotlin id="i3d8i8"
Modifier.padding(16.dp)
```

---

## size()

Exact size.

```kotlin id="i27s95"
Modifier.size(100.dp)
```

---

# 📌 5. Full Example

```kotlin id="eg2h7j"
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {}) { Text("Yes") }
        Button(onClick = {}) { Text("No") }
    }
}
```

---

# 📌 6. Easy Memory Trick

## Column

* verticalArrangement ⬆⬇
* horizontalAlignment ⬅➡

## Row

* horizontalArrangement ⬅➡
* verticalAlignment ⬆⬇

---

# 📌 7. Real Life Meaning

Think Column = people standing in line vertically.

Need:

* where line starts?
* gap between people?
* centered or left?

Think Row = people sitting in row horizontally.

---

# 📌 8. Most Used In Real Apps

```kotlin id="38y6or"
Column(
  modifier = Modifier.fillMaxSize().padding(16.dp),
  verticalArrangement = Arrangement.Top
)
```

```kotlin id="o1m6f5"
Row(
  modifier = Modifier.fillMaxWidth(),
  horizontalArrangement = Arrangement.SpaceBetween
)
```

---

# 📌 9. One Line Summary

**Arrangement = spacing direction**
**Alignment = opposite direction positioning**
**Modifier = size/style/behavior**

---

