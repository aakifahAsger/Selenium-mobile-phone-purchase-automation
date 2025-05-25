package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsAndCartVerification {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakifah Asger\\IdeaProjects\\chromedriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.navigate().to("https://www.ebay.com/");
            driver.manage().window().maximize();

            // Navigate through the electronics category
            driver.findElement(By.linkText("Electronics")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cell Phones & Accessories"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cell Phones & Smartphones"))).click();

            // Open filter panel
            WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".brwr__all-filters")));
            filterButton.click();
            System.out.println("Opened the filter options successfully.");

            // Expand Screen Size filter group
            WebElement screenSizeFilter = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".seo-accordion:nth-child(8) .seo-accordion__title")));
            screenSizeFilter.click();

            // Choose a specific screen size
            WebElement checkboxLabel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='4.0 - 4.4 in']/ancestor::label")));
            checkboxLabel.click();
            System.out.println("Screen size 4.0–4.4 inches selected.");

            // Apply the selected filters
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".btn-submit")));
            applyButton.click();
            System.out.println("Filter criteria confirmed and applied.");

            // Pick the first listed phone
            WebElement selectItem1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".brwrvr__item-card:nth-child(1) .bsig__title .textual-display")));
            String itemName = selectItem1.getText();
            selectItem1.click();
            System.out.println("Chosen the first mobile from the filtered results.");

            // Get and display item price
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[3]/div/div/div/span")));
            String itemPrice = priceElement.getText();

            System.out.println("Item Selected: " + itemName);
            System.out.println("Item Cost: " + itemPrice);

            // Add the item to cart
            driver.findElement(By.cssSelector("#atcBtn_btn_1 .ux-call-to-action__text")).click();
            System.out.println("Item added to shopping cart.");

            // Go to the cart
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gh-cart__icon"))).click();
            System.out.println("Navigated to the cart to verify item details.");
        } catch (Exception e) {
            System.out.println("Something went wrong during the process: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
