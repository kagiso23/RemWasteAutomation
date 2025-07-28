# React CRUD Automation Framework

This project provides a complete Java-based test automation framework for a React + Node.js web application.

## ✅ Features

- **Selenium WebDriver** for UI testing
- **REST-assured** for API testing
- **TestNG** for test orchestration
- **Data-driven testing** using JSON
- **Page Object Model (POM)** for UI layer
- **Environment config** for frontend/backend URLs
- **GitHub Actions CI** with Allure + HTML reporting
- **Negative login scenarios**

---

## 📁 Project Structure

```
src/test/java/
├── api/                    # REST-assured API tests
├── ui/                     # Base UI test setup
│   ├── pages/              # POM classes (LoginPage, DashboardPage)
│   └── tests/              # UI test classes
src/test/resources/
├── env.json                # Frontend/backend config
├── testdata.json           # Valid test data (multiple entries)
```

---

## ⚙️ Setup

### 1. Clone & Build

```bash
mvn clean install
```

### 2. Run UI Tests

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### 3. Run Allure Report

```bash
allure serve allure-results
```

---

## 🔁 Data Providers

- `testdata.json`: Used to loop multiple create/edit/delete tests
- Invalid login cases: defined in Java array (can be externalized)

---

## 🔐 Credentials

- Username: `admin`
- Password: `admin`

---

## ☁️ CI/CD with GitHub Actions

- Allure reports published on push to `main`
- HTML reports generated using Surefire plugin

---

## 📌 Notes

- Browser: Chrome (ChromeDriver required)
- Java 18+
- Node backend and React frontend must be running locally

---

