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
git clone https://github.com/kumar-ashish-20/retail-store-discount.git
cd retail-store-discount
Build the project:

Configuration
The application uses properties defined in application.properties to set discount rates:

properties

# application.properties

discount.employeeRate=0.30         # 30% for employees
discount.affiliateRate=0.10        # 10% for affiliates
discount.loyaltyRate=0.05          # 5% for loyal customers (over 2 years)
discount.flatDiscountPer100=5      # $5 discount per $100
server.port=9090
API Usage
Endpoint
URL: POST /api/discount/calculate

Content-Type: application/json

Request Body Example:

json
Copy code
{
"user": { "type": "Affiliate", "yearsOfLoyalty": 3 },

"items": [
{ "type": "Non-Grocery", "amount": 100.0 },
{ "type": "Grocery", "amount": 100.0 }
]

User Type:
Employee: 10% discount on non-grocery items
Affiliate: 10% discount on non-grocery items
Expected Response:

json
Copy code
{
"finalAmount": 180.0
}

