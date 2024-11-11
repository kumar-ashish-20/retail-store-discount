**Retail Discount Calculation System**
**Overview** :
The Retail Discount Calculation System is a Java Spring Boot application designed to calculate the net payable amount for retail customers based on user type and the items in their bill. The system follows object-oriented principles, ensuring clear separation of concerns and easy maintainability.

The application implements business rules for discounts:

Employees receive a 30% discount on non-grocery items.
Affiliates receive a 10% discount on non-grocery items.
Customers with over 2 years of loyalty receive a 5% discount on non-grocery items.
A flat $5 discount is applied for every $100 on the bill (applicable to all items).
Percentage-based discounts do not apply to grocery items.
Only one percentage-based discount can be applied per bill, based on the highest priority discount.
Features
Percentage Discount Calculation: Applies percentage discounts based on user type.
Flat Discount Calculation: Adds a $5 discount per $100 on the bill.
Configurable Discount Rates: Discount rates are stored in a properties file, allowing for easy adjustments.
RESTful API: Allows for calculating discounts through a POST endpoint.
Extensive Unit Testing: Provides unit tests with mocking for high test coverage.
Directory Structure
bash
Copy code
src
├── main
│   ├── java/com/example/retaildiscount
│   │   ├── config                   # Application configurations
│   │   ├── controllers              # REST controllers
│   │   ├── models                   # Models for Bill, LineItem, User
│   │   ├── services                 # Services for discount calculations
│   │   ├── utils                    # Utility classes for individual discount types
│   │   └── RetailDiscountApplication.java   # Main Spring Boot application class
└── test
├── java/com/example/retaildiscount  # Test cases for services
Getting Started
Prerequisites
Java 17 or higher
Maven 3.*+
Git
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/your-repo/retail-discount-calculator.git
cd retail-discount-calculator
Build the project:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
Configuration
The application uses properties defined in application.properties to set discount rates:

properties
Copy code
# application.properties

discount.employeeRate=0.30         # 30% for employees
discount.affiliateRate=0.10        # 10% for affiliates
discount.loyaltyRate=0.05          # 5% for loyal customers (over 2 years)
discount.flatDiscountPer100=5      # $5 discount per $100
server.port=8080
API Usage
Endpoint
URL: POST /api/discount/calculate

Content-Type: application/json

Request Body Example:

json
Copy code
{
"user": { "type": "Employee", "yearsOfLoyalty": 3 },
"bill": {
"items": [
{ "type": "Non-Grocery", "amount": 100.0 },
{ "type": "Grocery", "amount": 100.0 }
]
}
}
User Type:
Employee: 30% discount on non-grocery items
Affiliate: 10% discount on non-grocery items
Customers with loyalty over 2 years receive a 5% discount.
Expected Response:

json
Copy code
{
"finalAmount": 160.0
}
Explanation
The finalAmount is the total payable amount after applying the highest-priority discount (based on user type and loyalty) and the flat $5 discount for every $100 on the bill.

Running Tests
Unit Tests
Unit tests are available to validate the discount calculations. Mocking is used to isolate individual classes for testing.

Run the tests and generate a code coverage report:

bash
Copy code
mvn test
Code Coverage
The code coverage report will be available in the target/site/jacoco/index.html file. Open this file in a browser to view the test coverage.

Scripts for Code Quality
Static Code Analysis with SonarQube
SonarQube can be used to run static code analysis. To generate a report:

Start SonarQube and ensure it is running.
Add the following Maven command to analyze code quality:
bash
Copy code
mvn sonar:sonar
View the report in the SonarQube dashboard.
Linting with Checkstyle
Run Checkstyle to ensure code quality:

bash
Copy code
mvn checkstyle:check
Checkstyle reports are available in the target/checkstyle-report.html.

Example Calculation Logic
To clarify, here’s an example calculation based on the given rules.

Example Bill: Total bill with two items:
Item 1: Non-Grocery, $100
Item 2: Grocery, $100
User Type: Employee
Discount Calculations:
Percentage Discount: 30% of non-grocery amount ($100), giving a $30 discount.
Flat Discount: $5 for each $100 on the total bill ($200), giving a $10 discount.
Total Calculation:
Total Amount = $200
After percentage discount = $200 - $30 = $170
After flat discount = $170 - $10 = $160
Final Payable Amount: $160
Future Enhancements
Add more user roles with different discount rates.
Enhance discount rules for specific product categories.
Integrate with external payment APIs for a seamless checkout process.
Troubleshooting
If tests fail, ensure that the properties in application.properties are correctly set.
For SonarQube, verify that it is running and accessible before using the mvn sonar:sonar command.
