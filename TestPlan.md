# 🧪 Automation Test Plan – React CRUD App

## 1. 🎯 Objective

This test plan outlines the strategy for validating the functionality of a React-based frontend and a Node.js backend API using automated tests. The scope includes both **UI** and **API** automation with structured test coverage, reusable design, and CI integration.

---

## 2. ✅ What Is Being Tested

- **Login Flow** (positive and negative cases)
- **Item Management** (Create, Read, Update, Delete)
  - UI tests mimic real user interactions in the browser
  - API tests validate backend endpoints directly

---

## 3. 🧪 Test Coverage Areas

### ✅ UI Tests (Selenium + TestNG)
- Login with valid credentials
- Login with invalid/missing credentials
- Create new item
- Edit item
- Delete item
- Validate item presence and deletion
- Data-driven with multiple test inputs
- Assertions and visual validations

### ✅ API Tests (REST-assured)
- `POST /login`
- `GET /items`
- `POST /create`
- `PUT /items/:id`
- `DELETE /items/:id`
- Positive and negative test scenarios

---

## 4. 🔧 Tools Used & Why

| Tool           | Purpose                          |
|----------------|----------------------------------|
| Selenium       | UI automation of React frontend  |
| TestNG         | Test orchestration and grouping  |
| REST-assured   | HTTP-based API testing           |
| JSON           | Data-driven testing              |
| Maven          | Build and dependency management  |
| Allure Reports | Test result visualization        |
| GitHub Actions | CI automation and reporting      |

---

## 5. 🚀 How to Run the Tests

### UI Tests
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### API Tests
```bash
mvn test -Dtest=ApiTest
```

### Generate Allure Report
```bash
allure serve allure-results
```

---

## 6. 🔍 Assumptions & Limitations

- Node.js and React apps are expected to be running on:
  - Frontend: `http://localhost:3000`
  - Backend: `http://localhost:3001`
- ChromeDriver must be compatible with Chrome version
- No test data persistence between runs
- No database-level cleanup in UI tests
- UI tests depend on DOM structure (can break with design changes)
- Basic error message handling assumed (e.g. "Invalid credentials")

---

## 📌 Future Enhancements
- Dockerized grid/browser containers
- Jenkins/Allure dashboard integration
- Environment toggling (staging, prod)
- Parallel test execution