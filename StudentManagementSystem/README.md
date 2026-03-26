# Student Management System (Console-Based)

## 📌 Description
A Java-based console application using JDBC and MySQL to manage student records.

## 🚀 Features
- Add Student
- View Students
- Search Student
- Update Student
- Delete Student

## 🛠️ Technologies Used
- Java
- JDBC
- MySQL

## ⚙️ How to Run
1. Start MySQL server
2. Create database `student_db`
3. Create table `students`
4. Run the Java file

## 📂 Structure
- StudentManagementSystem.java
- Student.java

## 📊 Database Table
```sql
CREATE TABLE students (
    roll_number INT PRIMARY KEY,
    name VARCHAR(100),
    grade VARCHAR(10),
    contact VARCHAR(15)
);
```
