Online Shopping System
 Project Overview
The Online Shopping System is a console-based Java application developed to simulate the basic functionality of an e-commerce platform. The application allows users to register, log in, browse products, add products to a shopping cart, and place orders. All data is stored using the H2 Embedded Database, making the project lightweight and easy to run without installing MySQL.
This project was developed to practice Advanced Java, JDBC, Object-Oriented Programming (OOP), and Database Management concepts.

Project Objectives
•	Develop a real-world Java application.
•	Learn database connectivity using JDBC.
•	Perform CRUD (Create, Read, Update, Delete) operations.
•	Understand Object-Oriented Programming principles.
•	Practice exception handling.
•	Learn how to use an embedded database.
•	Build a menu-driven console application

Features
User Module
•	User Registration
•	User Login
•	Secure Authentication
•	View User Details
Product Module
•	Display All Products
•	Search Products
•	View Product Price
•	View Available Stock

Shopping Cart Module
•	Add Product to Cart
•	Remove Product from Cart
•	View Cart
•	Calculate Total Price
•	Clear Cart

Order Module
•	Place Order
•	Generate Order Summary
•	Store Orders in Database
•	Display Order History

Database Features
•	Embedded H2 Database
•	Automatic Database Creation
•	Automatic Table Creation
•	Persistent Data Storage

Technologies Used
Technology	Purpose
Java	Programming Language
JDBC	Database Connectivity
H2 Database	Embedded Database
SQL	Data Storage
VS Code / Eclipse	IDE
Command Prompt	Project Compilation

Software Requirements
•	Java JDK 8 or Higher
•	H2 Database JAR
•	VS Code or Eclipse
•	Windows/Linux/macOS


Project Folder Structure
OnlineShoppingSystem
│
├── Main.java
├── DBConnection.java
├── DatabaseSetup.java
│
├── Product.java
├── User.java
├── Cart.java
├── Order.java
│
├── ProductDAO.java
├── UserDAO.java
├── CartDAO.java
├── OrderDAO.java
│
├── h2.jar
│
└── README.md

Database Tables
User Table
Column	Type
user_id	  INT
name	VARCHAR
email	VARCHAR
password	VARCHAR

Product Table
Column	Type
product_id	    INT
product_name	  VARCHAR
price	  DOUBLE
stock	  INT

Cart Table
Column	   Type
cart_id	    INT
user_id	   INT
product_ id	   INT
quantity	  INT


Orders Table
Column	Type
order_id	    INT
user_id	  INT
total_amount	  DOUBLE
order_date	  DATE

Project Workflow
Start Application
       │
       ▼
Main Menu
       │
       ▼
Register / Login
       │
       ▼
View Products
       │
       ▼
Add Products to Cart
       │
       ▼
View Cart
       │
       ▼
Place Order
       │
       ▼
Order Stored in Database
       │
       ▼
Exit

 How to Run the Project
Step 1
Download or Clone the Repository.
Step 2
Copy h2.jar into the project folder.
Step 3
Compile the project.
For Windows:
javac -cp ".;h2.jar" *.java
For Linux/macOS:
javac -cp ".:h2.jar" *.java
Step 4
Run the application.
Windows:
java -cp ".;h2.jar" Main
Linux/macOS:
java -cp ".:h2.jar" Main


Sample Output
========== ONLINE SHOPPING SYSTEM ==========

1. Register
2. Login
3. View Products
4. Add Product to Cart
5. View Cart
6. Place Order
7. Exit

Enter your choice:


 License
This project is released for educational and learning purposes. You are free to use, modify, and improve it for academic or personal projects.
________________________________________
 Author
Elias Basha




