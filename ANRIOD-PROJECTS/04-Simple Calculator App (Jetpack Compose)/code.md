# 🧮 Full Working Kotlin Code — Calculator App (Jetpack Compose)

This calculator app includes:

✅ Two number input fields
✅ Addition, Subtraction, Multiplication, Division
✅ Result display
✅ Jetpack Compose UI
✅ Material 3 buttons
✅ Responsive layout using Column & Row

---

# 📁 Project Structure

```plaintext id="8xrmqa"
com.example.calculatorapp
│
├── MainActivity.kt
│
├── ui/theme/
```

---

# 🚀 MainActivity.kt

```kotlin id="a2l9kw"
package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {

    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Simple Calculator",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // First Number
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },

            label = {
                Text(text = "First Number")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Second Number
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },

            label = {
                Text(text = "Second Number")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Buttons Row 1
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                onClick = {

                    val n1 = number1.toDoubleOrNull() ?: 0.0
                    val n2 = number2.toDoubleOrNull() ?: 0.0

                    result = (n1 + n2).toString()
                }
            ) {
                Text(text = "+")
            }

            Button(
                onClick = {

                    val n1 = number1.toDoubleOrNull() ?: 0.0
                    val n2 = number2.toDoubleOrNull() ?: 0.0

                    result = (n1 - n2).toString()
                }
            ) {
                Text(text = "-")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons Row 2
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                onClick = {

                    val n1 = number1.toDoubleOrNull() ?: 0.0
                    val n2 = number2.toDoubleOrNull() ?: 0.0

                    result = (n1 * n2).toString()
                }
            ) {
                Text(text = "*")
            }

            Button(
                onClick = {

                    val n1 = number1.toDoubleOrNull() ?: 0.0
                    val n2 = number2.toDoubleOrNull() ?: 0.0

                    if (n2 != 0.0) {
                        result = (n1 / n2).toString()
                    } else {
                        result = "Cannot divide by zero"
                    }
                }
            ) {
                Text(text = "/")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Result
        Text(
            text = "Result: $result",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
```

---

# 📱 UI Preview


---

# 🔥 Features Explained

## 📥 Input Fields

```kotlin id="y30z9q"
OutlinedTextField()
```

Used for entering numbers.

---

## 🔘 Buttons

```kotlin id="g4r2fw"
Button()
```

Used for arithmetic operations.

---

## 🧠 State Management

```kotlin id="11j70x"
remember { mutableStateOf() }
```

Stores input values and result dynamically.

---

## ➗ Division Safety

```kotlin id="qsv4m0"
if (n2 != 0.0)
```

Prevents divide-by-zero crash.

---

# 🎯 Output Example

```plaintext id="hf95ea"
First Number: 10
Second Number: 5

+ Result = 15
- Result = 5
* Result = 50
/ Result = 2
```

---

