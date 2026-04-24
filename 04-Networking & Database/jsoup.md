You mean **parsing data from a webpage (HTML)**, not JSON.

So instead of API JSON data, you want to get things like:

* page **title**
* **div** text
* headings (`h1`, `h2`)
* links (`a`)
* images (`img`)
* tables
* paragraphs

This is called:

# 🌐 Web Scraping / HTML Parsing

You download webpage HTML, then extract elements.

---

# 📌 Example Webpage HTML

```html
<html>
<head>
<title>News Site</title>
</head>

<body>
<h1>Main News</h1>

<div class="price">$100</div>

<p>Hello world</p>
</body>
</html>
```

You may want:

* title = News Site
* h1 = Main News
* div price = $100
* paragraph = Hello world

---

# 📌 In Android / Kotlin Use **Jsoup**

Best library for HTML parsing:

![Image](https://images.openai.com/static-rsc-4/rjwluuwMpvma42vFED-H-9mFQzvrPtfk0HpTBoeuqjss4geSZMPmGlotuXB3T9lDD4Sksj5yqFwfwLklv43uok3q4pLO7mEiibEPEzEkVT0At_mZyZo_KAEpYRpOiEoNtJyOY4C0G3yF6ABFVktAnzng9Do6vZ1CxYJ1LIHS7CLNiMSGNgyaiMIjOawM4MGt?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/oHStVoMHPJUJFoX0KSdw_KsDnRK7dji3VqGVc3ps3XM7KR1I5fw4OiY7nHp12IH9425Kjdo_97QZ6f2f8_RtivhoRFR65gRSx-HqCStyPjdjrxZdcxrDJFxjWIxhfyZf1uoM-Ne0cDU6oKLBoaTne8UDz9BHHjLGuSMcLXV0Y33__qOwQK_2g8U_ffSkkjD8?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/lsnsrdw9r_XSOSDlTifS3_KraHIIfxgLwHMBGosLveVKEd2z1u2OcpZkfBbX4f9mfEGWdEOfX4wuYF6QfdoV1Kl2AOYdhoYlVZuz9MbaxVhutk6G77g46gQz9q9g-Wu_1cZMDiZVSLljHUkyAX96x27ojbvbhavl4cQbRMX8WQ8b_1ahP9_WSfdfW9hKErmj?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/j6UrMzz7swZ4VOL9j3I8gd7D_YHeRe-77eAQ9n8Bg8q-fjGZnHjP10mlzUwbJZqHtW2lwTi_qe11tMaywcit_ktP1B1-rzc_7RezYz6DubzBQH-KghQ2nXBO2tVmbhnxSXo6y08fbiJdAWmVPMyC67rzi-a4_0haJLI0AchSgHMkT8B9hBrVxbKgWEqM5XXH?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/y9RFfdSvsMSX7CSCjzRNCqLs5lQDPf0-tewyF4cH8nfZaM8ZDbt_hvKb65fqgHfKdmQUIAXdLMu1MBl_MV9qiXNDZQXF8E3zuMv_q50Y9Oq_rQ4wZCvySr6mjuhb_IWzSmG1jHZomaHO6mfeHrGBbLskTai3XTkwjJ4yxWnRfcMcZcFhd5nBE_OFTq4ut2Sj?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/vElStJbkPA5FPa-3ozgQ67PHDJjX9HYRwI_FkMJfQ6zKPNPSWhxxJYMfBR2me713NWaH3dacFSNJy6UW3lZFm38gA53A4EE3xC31i0gl0OyFl5d2unjEaLv7VLyh5WMTLq5lZ3GclNT0-qx2RHFYVFGQuO7whdVkiFdWQNdveYrYHktAKDJzxIL4bqVsItim?purpose=fullsize)

**Jsoup** downloads webpage and lets you select HTML elements.

---

# 📌 Add Dependency

```gradle
implementation("org.jsoup:jsoup:1.17.2")
```

---

# 📌 Example Kotlin Code

```kotlin
Thread {
    
    val doc = Jsoup.connect("https://example.com").get()

    val title = doc.title()

    val heading = doc.select("h1").text()

    val divText = doc.select("div").first()?.text()

    runOnUiThread {
        textView.text = "$title\n$heading\n$divText"
    }

}.start()
```

---

# 📌 Explanation

## 1. Get webpage

```kotlin
Jsoup.connect(url).get()
```

Downloads HTML page.

---

## 2. Get title

```kotlin
doc.title()
```

Gets:

```html
<title>Example</title>
```

---

## 3. Get first h1

```kotlin
doc.select("h1").text()
```

Gets heading text.

---

## 4. Get div

```kotlin
doc.select("div")
```

Gets all divs.

---

# 📌 CSS Selectors

Like web frontend:

| Selector | Meaning     |
| -------- | ----------- |
| `title`  | title tag   |
| `div`    | all div     |
| `.price` | class=price |
| `#main`  | id=main     |
| `h1`     | heading     |
| `a`      | links       |
| `img`    | images      |

---

# Example

```kotlin
doc.select(".price").text()
```

HTML:

```html
<div class="price">$500</div>
```

Output:

```plaintext
$500
```

---

# 📌 Get Links

```kotlin
for(link in doc.select("a")){
    val url = link.attr("href")
    val text = link.text()
}
```

---

# 📌 Get Image URL

```kotlin
val img = doc.select("img").first()?.attr("src")
```

---

# 📌 Important in Android

Do not run network on main thread.

Use:

* Thread
* Coroutine
* Retrofit
* WorkManager

---

# ⚠️ Some Websites Block Scraping

If site uses:

* JavaScript rendering
* Cloudflare
* Login
* Anti-bot protection

Then Jsoup may fail.

---

# 📌 Difference

| Type         | Use             |
| ------------ | --------------- |
| JSON Parsing | API data        |
| HTML Parsing | webpage content |

---

# 📌 Real Example

Get product price from shopping page:

```html
<div class="price">$199</div>
```

Kotlin:

```kotlin
val price = doc.select(".price").text()
```

---

# 📌 If You Are Android Student

Learn:

1. Jsoup basics
2. CSS selectors
3. Thread / Coroutine
4. RecyclerView display
5. Images with Picasso/Glide

---

# 📌 Short Memory Trick

```plaintext
JSON = API Data
HTML = Website Page
Jsoup = HTML Parser
```

---

# If you want, I can also show you **Android Kotlin app that gets webpage title + div text + image using Jsoup step-by-step**.
