# 🏛 UniManager (SHID-11 Edition)

**UniManager** is a console-based Educational ERP (Enterprise Resource Planning) system developed by the SHID-11 student team. This project serves as a practical demonstration of **Object-Oriented Programming (OOP)**, **MVC Architecture**, and robust software design principles in Java.

## 🚀 Key Features

* **🎓 Student Management:** Add, delete, sort, and search for students based on various criteria (e.g., group, grades, budget status).
* **👔 Teacher Management:** Track university staff, calculate the total salary budget, and filter teachers by academic degree.
* **💾 In-Memory Storage:** Custom implementation of dynamic arrays with automatic capacity expansion (no external SQL databases used in this sprint).
* **🖥️ Interactive Console UI:** A multi-level, user-friendly command-line interface with built-in input validation.

## 🏗 Architecture (MVC)

The application strictly follows the **Model-View-Controller** design pattern, featuring an advanced layered architecture with abstract generic services to adhere to the DRY (Don't Repeat Yourself) principle.

* `model/` — POJO data classes (`User`, `Student`, `Teacher`).
* `service/` — Core business logic. Utilizes an abstract base layer (`UserServiceImpl`) to handle array manipulations, which is then extended by specific domain services.
* `controller/` — Acts as a bridge, parsing user input and delegating tasks to the services.
* `view/` — The `ConsoleMenu` that handles the I/O loop.

## 🛠 Tech Stack

* **Language:** Java 21
* **Build Tool:** Maven
* **Version Control:** Git & GitHub
* **CI/CD:** GitHub Actions (Automated build and test pipelines)

## 👨‍💻 Development Team (SHID-11)

| Role                           | Responsibility                                             | Team Member         |
|:-------------------------------|:-----------------------------------------------------------|:--------------------|
| **Team Lead / Core Architect** | Base Abstractions, CI/CD, Code Review                      | *Demyd Titenko*     |
| **Student**                    | Agile task selection (Full-Stack implementation & Testing) | *Maria Pisarenko*   |
| **Student**                    | Agile task selection (Full-Stack implementation & Testing) | *Polina Prikhodko*  |
| **Student**                    | Agile task selection (Full-Stack implementation & Testing) | *Andriy Babich*     |
| **Student**                    | Agile task selection (Full-Stack implementation & Testing) | *Oleksiy Stadnikov* |


## 📦 Getting Started

### Prerequisites
* Java Development Kit (JDK) 21 installed.
* Apache Maven installed.

### Installation & Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/Demyd06/UniManager_SHID_11.git](https://github.com/Demyd06/UniManager_SHID_11.git)
   
### CodeRebbit Integration
   ![CodeRabbit Pull Request Reviews](https://img.shields.io/coderabbit/prs/github/TeamWithMyStudents/UniManager_SHID_11?utm_source=oss&utm_medium=github&utm_campaign=TeamWithMyStudents%2FUniManager_SHID_11&labelColor=171717&color=FF570A&link=https%3A%2F%2Fcoderabbit.ai&label=CodeRabbit+Reviews)
