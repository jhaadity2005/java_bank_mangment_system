# Bank Management System

A comprehensive banking management system designed to handle core banking operations including account management, transactions, customer services, and administrative functions.

## 🏦 Features

- **Account Management**: Create, update, and manage different types of bank accounts
- **Customer Registration**: Customer onboarding and profile management
- **Transaction Processing**: Deposits, withdrawals, and fund transfers
- **Balance Inquiry**: Real-time account balance checking
- **Transaction History**: Detailed transaction logs and statements
- **Loan Management**: Loan applications and processing
- **Interest Calculation**: Automated interest computation
- **Admin Dashboard**: Administrative controls and system monitoring
- **Security Features**: Authentication, authorization, and audit trails
- **Report Generation**: Account statements and financial reports

## 🏗️ System Architecture

### Database Layer
- **Database Schema**: Normalized database design for accounts, customers, transactions, and loans
- **Model Classes**:
  - `Account` - Bank account information and details
  - `Customer` - Customer profile and personal information
  - `Transaction` - Financial transaction records
  - `User` - System users (customers, staff, admin)
  - `Loan` - Loan applications and records
  - `Branch` - Bank branch information

### Data Access Layer (DAO Pattern)
- **AccountDAO** - Account data operations and queries
- **CustomerDAO** - Customer data management
- **TransactionDAO** - Transaction processing and history
- **UserDAO** - User authentication and management
- **LoanDAO** - Loan data handling
- **DatabaseConnection** - Database connectivity and connection pooling

### Business Logic Layer
- **AccountService** - Account management business logic
- **TransactionService** - Transaction processing rules
- **LoanService** - Loan approval and management
- **InterestService** - Interest calculation algorithms
- **SecurityService** - Authentication and authorization
- **ReportService** - Report generation and analytics

### User Interface Layer
- **BankManagementUI** - Main application interface
- **AccountUI** - Account management interface
- **TransactionUI** - Transaction processing interface
- **CustomerUI** - Customer management interface
- **LoanUI** - Loan management interface
- **ReportsUI** - Reports and analytics dashboard

## 🛠️ Technologies Used

- **Programming Language**: Java 17+
- **Database**: MySQL 8.0 / PostgreSQL 13+
- **Framework**: Spring Boot 3.0
- **Frontend**: JavaFX (Desktop) or Angular/React (Web)
- **Security**: Spring Security
- **Build Tool**: Maven 3.8+
- **Testing**: JUnit 5, Mockito
- **Documentation**: JavaDoc

## 📋 Prerequisites

- Java Development Kit (JDK) 17 or higher
- MySQL Server 8.0+ or PostgreSQL 13+
- Maven 3.8+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)
- Git for version control

## 🚀 Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/bank-management-system.git
   cd bank-management-system
   ```

2. **Set up the database:**
   ```sql
   -- For MySQL
   CREATE DATABASE bank_management_db;
   USE bank_management_db;
   SOURCE database/schema.sql;
   SOURCE database/sample_data.sql;
   ```

3. **Configure database connection:**
   ```properties
   # Update src/main/resources/application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bank_management_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Build and run:**
   ```bash
   # Build the project
   mvn clean compile
   
   # Run tests
   mvn test
   
   # Start the application
   mvn spring-boot:run
   ```

5. **Access the application:**
   - Desktop App: Launch from your IDE or command line
   - Web App: Navigate to `http://localhost:8080`

## 📊 Database Schema

### Core Tables

**customers**
- customer_id (Primary Key)
- first_name, last_name
- email, phone, address
- date_of_birth, ssn
- created_date, updated_date

**accounts**
- account_id (Primary Key)
- customer_id (Foreign Key)
- account_number (Unique)
- account_type (SAVINGS, CHECKING, FIXED_DEPOSIT)
- balance, interest_rate
- status (ACTIVE, CLOSED, SUSPENDED)
- created_date, updated_date

**transactions**
- transaction_id (Primary Key)
- account_id (Foreign Key)
- transaction_type (DEPOSIT, WITHDRAWAL, TRANSFER)
- amount, balance_after
- description, reference_number
- transaction_date, created_by

**loans**
- loan_id (Primary Key)
- customer_id (Foreign Key)
- loan_type, principal_amount
- interest_rate, tenure_months
- monthly_payment, status
- application_date, approval_date

**users**
- user_id (Primary Key)
- username, password_hash
- role (CUSTOMER, STAFF, ADMIN)
- customer_id (Foreign Key, nullable)
- is_active, last_login

## 🎯 Usage

### Customer Operations
- **Account Opening**: Create new savings or checking accounts
- **Deposits**: Add money to accounts
- **Withdrawals**: Remove money from accounts
- **Fund Transfers**: Transfer money between accounts
- **Balance Inquiry**: Check current account balance
- **Statement Generation**: View transaction history

### Staff Operations
- **Customer Management**: Add, update customer information
- **Account Administration**: Manage customer accounts
- **Transaction Processing**: Process deposits, withdrawals
- **Loan Processing**: Review and approve loan applications
- **Report Generation**: Generate various banking reports

### Admin Operations
- **User Management**: Manage system users and permissions
- **System Configuration**: Configure interest rates, fees
- **Audit Reports**: Generate audit trails and compliance reports
- **Branch Management**: Manage bank branches and staff

## 🔐 Security Features

- **Authentication**: Secure login with encrypted passwords
- **Authorization**: Role-based access control (RBAC)
- **Session Management**: Secure session handling
- **Audit Logging**: Complete transaction audit trails
- **Data Encryption**: Sensitive data encryption
- **Input Validation**: Protection against SQL injection and XSS

## 🧪 Testing

```bash
# Run unit tests
mvn test

# Run integration tests
mvn verify

# Generate test coverage report
mvn jacoco:report
```

## 📝 API Documentation

If using REST APIs, access documentation at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- API Docs: `http://localhost:8080/api-docs`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/account-management`)
3. Commit your changes (`git commit -m 'Add account management feature'`)
4. Push to the branch (`git push origin feature/account-management`)
5. Open a Pull Request

## 📁 Project Structure

```
bank-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/bank/
│   │   │   │   ├── model/
│   │   │   │   │   ├── Account.java
│   │   │   │   │   ├── Customer.java
│   │   │   │   │   ├── Transaction.java
│   │   │   │   │   └── User.java
│   │   │   │   ├── dao/
│   │   │   │   │   ├── AccountDAO.java
│   │   │   │   │   ├── CustomerDAO.java
│   │   │   │   │   └── TransactionDAO.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── AccountService.java
│   │   │   │   │   └── TransactionService.java
│   │   │   │   ├── ui/
│   │   │   │   │   ├── BankManagementUI.java
│   │   │   │   │   └── TransactionUI.java
│   │   │   │   └── config/
│   │   │   │       └── DatabaseConnection.java
│   │   │   └── Application.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
├── database/
│   ├── schema.sql
│   └── sample_data.sql
├── docs/
│   ├── user_guide.md
│   └── technical_specs.md
├── README.md
├── pom.xml
└── .gitignore
```

## 🔧 Configuration

### Application Properties
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/bank_management_db
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:password}

# Security Configuration
bank.security.jwt.secret=${JWT_SECRET:mySecretKey}
bank.security.session.timeout=30

# Business Rules
bank.interest.savings.rate=3.5
bank.interest.checking.rate=1.0
bank.transaction.daily.limit=10000
```





## 🏆 Acknowledgments

- Spring Boot team for the excellent framework
- MySQL community for the robust database system
- Contributors and testers who helped improve this system
