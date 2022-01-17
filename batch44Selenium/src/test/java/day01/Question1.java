package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle().equals("YouTube")?"correct title":"incorrect title");
        driver.quit();
        System.out.println("Test completed");

    }

}
