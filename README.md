# eBay Mobile Phone Purchase Automation

A comprehensive Selenium TestNG framework that automates the mobile phone purchase flow on eBay.com as a guest user. This project demonstrates end-to-end testing automation following industry best practices.

## 🚀 Project Overview

This automation framework simulates a real user journey for purchasing mobile phones on eBay, including:
- Product search and filtering
- Product details validation
- Cart management
- Guest checkout process

## 🛠️ Technology Stack

- **Java** - Programming language
- **Selenium WebDriver** - Web automation framework
- **TestNG** - Testing framework
- **Maven** - Build automation and dependency management
- **Page Object Model (POM)** - Design pattern for maintainable test code

## 📋 Test Scenarios

### 1. Basic Navigation
- Launch Chrome browser
- Navigate to eBay.com
- Verify page URL

### 2. Category & Product Selection
- Navigate to Electronics → Cell Phones & Smartphones
- Apply screen size filters
- Browse product listings

### 3. Product Details & Cart Verification
- Select mobile phone from search results
- Capture and validate product details (name, price)
- Add product to cart
- Verify cart contents

### 4. Checkout Process
- Proceed to checkout as guest user
- Fill shipping information
- Complete guest checkout flow

## 🏗️ Project Structure

```
selenium-ebay-automation/
├── src/
│   ├── main/java/
│   │   ├── pages/
│   │   │   ├── HomePage.java
│   │   │   ├── CategoryPage.java
│   │   │   ├── ProductPage.java
│   │   │   ├── CartPage.java
│   │   │   └── CheckoutPage.java
│   │   ├── utils/
│   │   │   ├── DriverManager.java
│   │   │   └── TestUtils.java
│   │   └── base/
│   │       └── BaseTest.java
│   └── test/java/
│       ├── tests/
│       │   └── EbayPurchaseTest.java
│       └── resources/
│           └── testng.xml
├── pom.xml
└── README.md
```

## 🔧 Prerequisites

- **Java JDK 8+** installed
- **Maven** installed
- **Chrome Browser** installed
- **Git** installed

## ⚙️ Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/aakifahAsger/Selenium-mobile-phone-purchase-automation.git
   cd Selenium-mobile-phone-purchase-automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Download WebDriver**
   - ChromeDriver will be managed automatically via WebDriverManager dependency
   - No manual driver setup required

## 🚀 Running Tests

### Run all tests
```bash
mvn test
```


### Cross-browser testing
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
```

## 📊 Test Reports

TestNG generates detailed test reports:
- **HTML Report**: `target/surefire-reports/index.html`
- **XML Report**: `target/surefire-reports/testng-results.xml`

## 🏛️ Design Patterns Used

### Page Object Model (POM)
- Each web page is represented as a separate class
- Page elements and actions are encapsulated
- Improves maintainability and reusability

### Factory Pattern
- WebDriver initialization
- Cross-browser support

## 📝 Key Features

- ✅ **Page Object Model** implementation
- ✅ **TestNG annotations** for test organization
- ✅ **WebDriverWait** for stable element interactions
- ✅ **Cross-browser support** (Chrome, Firefox, Edge)
- ✅ **Parallel test execution**
- ✅ **Parameterized tests** with TestNG DataProvider
- ✅ **Comprehensive assertions** and validations
- ✅ **Detailed test reporting**

## 🧪 Test Data

Test data is managed through:
- TestNG DataProvider for parameterization
- Properties files for configuration

## 🔍 Key Test Validations

- Page URL verification
- Product name and price validation
- Cart item verification
- Checkout form validation
- Error handling and negative scenarios

## 🚫 Limitations

- Tests stop at login requirement (no account creation)
- Guest checkout only
- Chrome browser primary support
- Network-dependent test execution

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit changes (`git commit -am 'Add new feature'`)
4. Push to branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## 📞 Support

For questions or issues:
- Create an issue in the GitHub repository
- Contact: ahlak7981@gmail.com


## 🏷️ Version History

- **v1.0.0** - Initial release with core automation features
- **v1.1.0** - Added cross-browser support and parallel execution
- **v1.2.0** - Enhanced reporting and data parameterization

---

**Note**: This is an educational project for automation testing demonstration. Always respect website terms of service and implement appropriate delays to avoid overwhelming servers.
