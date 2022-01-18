package day03_webelementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementGetMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://a.testaddressbook.com");
        WebElement signInLinki = driver.findElement(By.id("sign-in"));
        System.out.println("Size: "+signInLinki.getSize());
        System.out.println("Aria role: "+signInLinki.getAriaRole());
        System.out.println("Accessible name: "+signInLinki.getAccessibleName());
        System.out.println("Id attribute value\'su: " + signInLinki.getAttribute("id"));
        System.out.println("Location: "+signInLinki.getLocation());
        System.out.println("Genislik: "+signInLinki.getRect());
        System.out.println("Rengi: "+signInLinki.getCssValue("color"));
        driver.quit();
    }
}
