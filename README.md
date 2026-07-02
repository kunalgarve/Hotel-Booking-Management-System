🏨 Hotel Booking System – Java + JDBC + MySQL : 

A console-based Hotel Booking System built using Core Java, JDBC, and MySQL.
This project helps manage customers, rooms, and bookings through a menu-driven interface.
It demonstrates JDBC connectivity, DAO design pattern, and Object-Oriented Programming.

🚀 Features : 

👤 Customer Management :

Add new customers

View all registered customers

🏠 Room Management :

Add rooms with room type, price, and availability

View all rooms

📅 Booking Management :

Make bookings for customers

View all bookings

🗄️ Database Layer :

Structured tables for customers, rooms, bookings

MySQL + JDBC connectivity

PreparedStatements for secure operations

🛠️ Technologies Used : 

Java 8+

JDBC

MySQL Database

Eclipse IDE

📂 Project Structure :

src/

 └── com.tka
 
      ├── main            # Main class with menu-driven program
      
      ├── dao             # Database operations (CRUD)
      
      ├── model           # Customer, Room, Booking POJO classes
      
      └── system          # DBUtil for MySQL connection

🗄️ Database Setup : 

1️⃣ Create Database

CREATE DATABASE hotel_booking_db;
USE hotel_booking_db;

2️⃣ Create Tables

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15)
);

CREATE TABLE rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(20),
    type VARCHAR(20),
    price DOUBLE,
    available BOOLEAN
);

CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    room_id INT,
    checkin_date DATE,
    checkout_date DATE
);     


▶️ How to Run the Project :

Step 1: Clone the Repository
git clone https://github.com/YOUR-USERNAME/YOUR-REPO.git
cd YOUR-REPO

Step 2: Open in Eclipse

Step 3: Add MySQL Connector/J
Right click project → Build Path → Configure Build Path
Add External JAR → Select mysql-connector-j-X.X.X.jar

Step 4: Update DB Credentials
Update your MySQL username/password in:
src/com/tka/system/DBUtil.java

Step 5: Run the Application
Run the main file:
com.tka.main.main

🎯 Learning Outcomes :

How to connect Java with MySQL using JDBC

CRUD operations using PreparedStatement

Exception handling in JDBC

DAO pattern implementation

Designing console-based applications

Good OOP practices

🔮 Future Enhancements : 

Admin Login Module

Automatic room availability check

Booking cancellation

Generate bill/receipt

Add GUI using JavaFX or Swing

Email/SMS notification integration

👨‍💻 Author

Ritesh Satre

📧 Email: satreritesh9@gmail.com

🌐 GitHub: https://github.com/Riteshsatre
