# Coupon Management System

A simple and clean **Coupon Management System** built for an e-commerce use case.  
This project provides APIs to **create coupons** and **find the best applicable coupon** based on user and cart details.

---

## 🚀 Tech Stack
- **Java 17**
- **Spring Boot**
- **Spring Web**
- **In-Memory Storage** (No database)
- **Postman** for testing

---

## 📌 Features
### 1️⃣ Create Coupon API  
Allows admins to create coupons with:
- Unique coupon code  
- FLAT or PERCENT discount  
- Validity dates (startDate, endDate)  
- Optional usage limits  
- Eligibility rules (user + cart based)

### 2️⃣ Best Coupon API  
Given:
- User Context  
- Cart Items  

This API:
- Filters valid coupons  
- Checks eligibility  
- Calculates discount  
- Returns the **BEST coupon** (max discount)
- 
---

## 🧪 How to Run the Project

### Prerequisites
- Java 17 installed  
- Maven installed (optional, wrapper included)

### Steps

### ✔ **POST /api/coupons/best**
Returns best coupon for given user + cart.

---

## 📝 AI Usage Note

This project was developed with assistance from AI tools for:
- Structuring code  
- Designing eligibility logic  
- Formatting the README  

All API logic and implementation were written manually by me.

---

## 👤 Author  
**Ranjit Kumar**  
Java Backend Developer  


---

## 📦 Project Structure

