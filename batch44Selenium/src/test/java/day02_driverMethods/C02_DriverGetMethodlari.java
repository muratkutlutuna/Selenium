package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println("title im "+driver.getTitle());
        System.out.println("internet adresi "+driver.getCurrentUrl());
        System.out.println("tek window handle "+driver.getWindowHandle());
        System.out.println("bir suru window handle "+driver.getWindowHandles());

        System.out.println(driver.getPageSource());
    }
}
