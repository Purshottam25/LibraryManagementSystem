# 📚 Library Management System (Backend - JDBC Project)

A simple **Library Management System** developed using **Core Java**, **JDBC**, and **MySQL**. This is a backend-only console-based project that demonstrates CRUD (Create, Read, Update, Delete) operations on a library database.

Developed by **Purshottam Patel**.

---

## 🛠️ Technologies Used

- **Java (Core Java)**
- **JDBC (Java Database Connectivity)**
- **MySQL** (Relational Database Management System)

---

## 🧱 Project Description

This backend system allows basic management of a book inventory using JDBC. The project connects to a **MySQL** database called `Library` and performs operations on a single table named `books`.

You can perform the following operations through the console:

- ✅ Add new book
- 📖 View all books
- 📝 Update existing book
- ❌ Delete book record

Each book record contains the following information:

- `book_id` – Unique identifier
- `title` – Title of the book
- `author` – Author's name
- `publisher` – Publisher's name
- `year` – Year of publication
- `available_copies` – Number of copies currently available

---

## 🗃️ Database Setup

1. **Create the database**:
   ```sql
   CREATE DATABASE Library;
   ```

2. **Use the database**:
   ```sql
   USE Library;
   ```

3. **Create the `books` table**:
   ```sql
   CREATE TABLE books (
       book_id INT PRIMARY KEY,
       title VARCHAR(255),
       author VARCHAR(255),
       publisher VARCHAR(255),
       year INT,
       available_copies INT
   );
   ```

---

## 🚀 Getting Started

### 1. Clone or Download the Project

You can clone this project using Git or simply download the source code.

```bash
git clone https://github.com/your-username/library-management-jdbc.git
```

### 2. Configure JDBC Driver

- Download the **MySQL Connector/J** (`.jar`) file.
- Add it to your project’s classpath using your IDE (e.g., IntelliJ, Eclipse) or build system.

### 3. Update Database Credentials

In your Java class (usually in a `DBConnection` or `Main` class), update:

```java
String url = "jdbc:mysql://localhost:3306/Library";
String username = "your_mysql_username";
String password = "your_mysql_password";
```

### 4. Compile and Run the Project

Use your IDE or terminal to run the project. All operations will be performed via console inputs.

---

## ✅ Features

- Add a new book to the system
- View all available books
- Update book details (title, author, year, etc.)
- Delete a book by ID

---

## 📌 Project Limitations

- Backend only – no graphical user interface
- No user login or role-based access
- No advanced features like borrowing history, due dates, or search by keyword

---

## 🙋‍♂️ Author

**Purshottam Patel**

> A passionate Java developer exploring backend development with real-world database applications.

---

## 📃 License

This project is open-source and free to use for educational or non-commercial purposes.
