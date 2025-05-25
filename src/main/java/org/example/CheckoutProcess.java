package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutProcess {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakifah Asger\\IdeaProjects\\chromedriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.get("https://www.ebay.com/");
            driver.manage().window().maximize();

            driver.findElement(By.linkText("Electronics")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cell Phones & Accessories"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cell Phones & Smartphones"))).click();

            WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".brwr__all-filters")));
            filterButton.click();
            System.out.println("Clicked on 'All Filters' successfully.");

            WebElement screenSizeFilter = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".seo-accordion:nth-child(8) .seo-accordion__title")));
            screenSizeFilter.click();

            WebElement checkboxLabel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='4.0 - 4.4 in']/ancestor::label")));
            checkboxLabel.click();
            System.out.println("Chosen screen size filter: 4.0 - 4.4 inches.");

            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".btn-submit")));
            applyButton.click();
            System.out.println("Filters applied - displaying updated search results.");

            WebElement selectItem1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".brwrvr__item-card:nth-child(1) .bsig__title .textual-display")));
            String itemName = selectItem1.getText();
            selectItem1.click();
            System.out.println("Selected a mobile phone from the filtered list.");

            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"mainContent\"]/div[1]/div[3]/div/div/div/span")));
            String itemPrice = priceElement.getText();

            System.out.println("Item Name: " + itemName);
            System.out.println("Item Cost: " + itemPrice);

            driver.findElement(By.cssSelector("#atcBtn_btn_1 .ux-call-to-action__text")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gh-cart__icon"))).click();

            WebElement totalPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".total-row:nth-child(2) > .text-display-span > span > span")));
            String totalPrice = totalPriceElement.getText();
            System.out.println("Estimated Checkout Total: " + totalPrice);

            driver.findElement(By.cssSelector(".btn--large")).click();
            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userid")));
            email.click();
            driver.findElement(By.name("userid")).sendKeys("aakifahasger902@gmail.com");
            driver.findElement(By.id("signin-continue-btn")).click();
            System.out.println("Guest email entered, proceeding to shipping form...");

            // You can add shipping info form filling here if needed

        } catch (Exception e) {
            System.out.println("Something went wrong during checkout: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Test completed and browser closed.");
        }
    }
}
