# sprite-cloud-assignment Test Automation Framework

## Overview
SpriteCloudAssignment is a test automation framework designed to verify the functionality of web applications. This project follows the Page Object Model (POM) design pattern and includes both UI and API test automation components to ensure comprehensive test coverage.

## Project Structure

### 1. Base Layer
This layer contains core files responsible for managing base test classes and utilities:
- **BaseAPITest.java**: Foundation for API test execution.
- **BaseUITest.java**: Foundation for UI test execution.
- **UtilHelper.java**: Common utility functions.

### 2. Page Object Model (POM) Layer
This layer contains classes that represent web pages and their functionality:
- **LoginPage.java**: Handles login page elements and actions.
- **ItemSearchPage.java**: Handles item search page elemnts and actions.
- **CheckoutPage.java**: Handles checkout page elements and actions.

### 3. Function Layer
Contains business logic implementations:
- **LoginFunction.java**: Implements Login functionality.
- **ItemSearchFunction.java**: Implements search functionality.
- **CheckoutFunction.java**: Implements checkout functionality.

### 4. API Test Layer
Contains API test implementations:  
- **DelayAPITest.java**: Tests Delay API response times  
- **LoginRelatedTest.java**: Tests login-related APIs  
- **NegativeAPITest.java**: Tests negative scenarios  
- **UserRelatedAPITest.java**: Tests user management APIs  

### 5. UI Test Layer
Contains UI test implementations:  
- **DescendingOrderTest.java**: Tests sorting functionality  
- **LoginAndCheckoutTest.java**: Tests end-to-end login and checkout  
- **ValidateLoginFailureTest.java**: Tests login failure scenario  

### 6. Configuration and Resources
- **log4j2.xml**: Logging configuration  
- **payloads/**: Contains JSON payloads for API tests  
  - **login_payloads.json**  
  - **update_payloads.json**  

### 7. Constants
- **Constants.java**: Contains the test data  

## Technologies Used

- **Programming Language**: Java  
- **Test Framework**: TestNG  
- **Build Tool**: Maven  
- **Logging**: Log4j2  
- **Design Patterns**: Page Object Model (POM), Layered Architecture  
- **API Testing**: REST Assured (implied by structure)  

## Setup Instructions

### Prerequisites

Ensure you have the following installed on your system:  
1. **Java JDK 8+**  
2. **Maven**  
3. **TestNG**  
4. **Allure** (for Reporting)  
5. **IDE** (IntelliJ IDEA recommended)  

### Installation Steps

1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/SpriteCloudAssignment.git

2. Navigate to the project directory:
   ```sh
   cd SpriteCloudAssignment
   
3. Install dependencies:
   ```sh
   mvn clean install

### Reporting

Allure Reporting use for the report generations
![image](https://github.com/user-attachments/assets/9b19f102-57d0-4c2e-88cf-57e650de9648)
![image](https://github.com/user-attachments/assets/ce181d54-c1a9-4555-ac32-0f307c91d2a6)



### Running Tests 

1. To execute API tests, use:
   ```sh
   mvn -Dtest=UserRelatedAPITest test
   
   mvn -Dtest=NegativeAPITest test

   mvn -Dtest=LoginRelatedTest test

   mvn -Dtest=DelayAPITest test 
   


2.  To execute UI tests, use:
   ```sh
   mvn -Dtest=LoginAndCheckoutTest test

   mvn -Dtest=DescendingOrderTest test

   mvn -Dtest=ValidateLoginFailureTest test
