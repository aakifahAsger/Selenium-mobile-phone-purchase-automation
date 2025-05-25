package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestNGClass {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakifah Asger\\IdeaProjects\\chromedriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        String baseUrl = "https://www.ebay.com/";
        driver.get(baseUrl);

        if (driver.getCurrentUrl().equals(baseUrl)) {
            System.out.println("Successfully launched eBay.");
        } else {
            System.out.println("Failed to load correct URL.");
        }
    }

    @Test
    public void executePurchaseFlow() {
        try {
            // Navigate to Electronics > Cell Phones
            driver.findElement(By.linkText("Electronics")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cell Phones & Accessories"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cell Phones & Smartphones"))).click();

            // Filter: Screen size 4.0 - 4.4 in
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".brwr__all-filters"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".seo-accordion:nth-child(8) .seo-accordion__title"))).click();
            WebElement screenSizeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='4.0 - 4.4 in']/ancestor::label")));
            screenSizeCheckbox.click();
            System.out.println("4.0-4.44 applied.");
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-submit"))).click();
            System.out.println("Screen size filter applied.");

            // Select first listed item
            WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".brwrvr__item-card:nth-child(1) .bsig__title .textual-display")));
            String itemName = firstItem.getText();
            firstItem.click();

            // Get product price
            WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[3]/div/div/div/span")));
            String itemPrice = price.getText();

            System.out.println("Item name: " + itemName);
            System.out.println("Item cost: " + itemPrice);

            // Add to cart
            driver.findElement(By.cssSelector("#atcBtn_btn_1 .ux-call-to-action__text")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".gh-cart__icon"))).click();

            // Get total price from cart
            WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".total-row:nth-child(2) > .text-display-span > span > span")));
            String totalCartPrice = total.getText();
            System.out.println("Total in cart: " + totalCartPrice);

            // Proceed to checkout
            driver.findElement(By.cssSelector(".btn--large")).click();

            // Login email field
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userid")));
            if (emailField.isDisplayed()) {
                System.out.println("Reached login page. Test will stop here as login is required.");
            }

        } catch (Exception ex) {
            System.out.println("Error during test execution: " + ex.getMessage());
        }
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Test completed and browser closed.");
    }
}
