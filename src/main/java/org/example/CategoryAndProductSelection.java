package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryAndProductSelection {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakifah Asger\\IdeaProjects\\chromedriver\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an explicit wait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Select 'Electronics' from the top menu bar
            driver.findElement(By.linkText("Electronics")).click();

            // Wait and select 'Cell Phones & Accessories' category
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cell Phones & Accessories"))).click();

            // Wait and select 'Cell Phones & Smartphones' subcategory
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cell Phones & Smartphones"))).click();

            // Wait for the filter button (sidebar) to be clickable and click it
            WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".brwr__all-filters")));
            filterButton.click();
            System.out.println("Opened the filter options successfully.");

            // Expand the 'Screen Size' filter in the sidebar
            WebElement screenSizeFilter = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".seo-accordion:nth-child(8) .seo-accordion__title")));
            screenSizeFilter.click();

            // Select a specific screen size checkbox (e.g., 4.0 - 4.4 in)
            WebElement checkboxLabel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='4.0 - 4.4 in']/ancestor::label")));
            checkboxLabel.click();
            System.out.println("Selected '4.0 - 4.4 in' screen size.");

            // Apply the selected filter
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".btn-submit")));
            applyButton.click();
            System.out.println("Filter applied successfully.");
        } catch (Exception e) {
            // Handle any exception that occurs during execution
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Quit the browser in any case (success or failure)
            driver.quit();
        }
    }
}
