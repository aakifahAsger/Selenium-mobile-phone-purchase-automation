package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BasicNavigation {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver","C:\\Users\\Aakifah Asger\\IdeaProjects\\chromedriver\\chromedriver-win64\\chromedriver.exe" );

        WebDriver driver = new ChromeDriver();

        String url = "https://www.ebay.com/";

        driver.get(url);
        driver.manage().window().maximize();

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url))
        {
            System.out.println("Verification Successful - The correct Url is opened.");
        }
        else
        {
            System.out.println( "Verification Failed - An incorrect Url is opened." );

            System.out.println( "Actual URL is : " + actualUrl );
            System.out.println( "Expected URL is : " + url );
        }
        driver.quit();
    }
}