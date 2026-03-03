# 🦠 COVID-19 Thailand Dashboard (JavaFX)

A JavaFX desktop application that fetches real-time COVID-19 data from Thailand’s public health API and displays it in a structured dashboard UI.

This project:
- Connects to Thailand’s official COVID-19 API
- Fetches live case statistics
- Parses JSON response
- Displays data in a JavaFX GUI
- Organizes cases, deaths, and recovery statistics visually

---

## 👨‍💻 Author

Sheshehang Limbu

---

## 🚀 Features

- 🌐 Real-time API data fetch
- 📊 Displays:
  - Total Cases
  - New Cases
  - Total Deaths
  - New Deaths
  - Total Recovered
  - New Recovered
- 🧩 JSON parsing using JSON.simple
- 🔗 HTTP requests using OkHttp
- 🖥 Desktop UI using JavaFX

---

## 🛠 Tech Stack

- Java 11+
- JavaFX
- OkHttp
- JSON.simple
- Maven or Gradle (recommended)

---

## 🌍 Data Source

API Endpoint:

http://covid19.ddc.moph.go.th/api/Cases/today-cases-all

Provided by:
Thailand Ministry of Public Health (DDC)

---

## 📂 Project Structure

.
├── src/
│   └── com/example/covid/
│       ├── TestFinal.java
│       └── TestFinalAPI.java
├── pom.xml (if Maven)
└── README.md

---

## 📦 Dependencies

If using Maven, add:

<dependencies>

    <!-- JavaFX (version depends on your system) -->

    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>4.9.3</version>
    </dependency>

    <dependency>
        <groupId>com.googlecode.json-simple</groupId>
        <artifactId>json-simple</artifactId>
        <version>1.1.1</version>
    </dependency>

</dependencies>

---

## ▶️ Run the Application

If using IntelliJ:

1. Configure JavaFX SDK
2. Set VM options:

--module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml

3. Run:

TestFinalAPI.java

Or:

mvn clean javafx:run

---

## 📊 Displayed Data

The dashboard shows:

- Transaction Date
- Total Cases
- New Cases
- Total Cases (excluding abroad)
- New Cases (excluding abroad)
- Total Deaths
- New Deaths
- Total Recovered
- New Recovered

All values are fetched dynamically from the API.

---

## 🧠 How It Works

1. OkHttp sends GET request to API
2. Response body is converted to string
3. JSON.simple parses response
4. Data extracted from first JSON object
5. Values inserted into JavaFX Text components
6. UI displayed inside VBox and HBox layouts

---

## 🖥 UI Layout Structure

Main VBox
 ├── Date Box
 ├── Confirmed Case Header
 ├── Total Case Box
 ├── New Case Section (HBox)
 ├── Death Section (HBox)
 └── Recovery Section (HBox)

---

## ⚠️ Notes

- Requires internet connection
- API must be online
- JavaFX must be configured correctly
- Tested on Java 11+

---

## 📈 Possible Improvements

- Add charts (LineChart / BarChart)
- Add auto-refresh timer
- Add loading indicator
- Improve UI styling with CSS
- Add province-level data
- Add dark mode theme
- Add error handling UI instead of console print

---

## 🏆 Project Type

Desktop Application + API Integration + JavaFX UI

Suitable for:
- Java portfolio
- API integration demonstration
- Government data visualization project
- Academic submission

---

## 📜 License

Copyright (c) 2026 Sheshehang Limbu

All rights reserved.

This project may not be copied, modified, or distributed
without explicit permission from the author.
