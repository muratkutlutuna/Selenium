package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_XpathText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
//        3- Delete butonu’nun gorunur oldugunu test edin
        if (driver.findElement(By.xpath("//button[text()='Delete']")).isDisplayed()) {
            System.out.println("Delete element has displayed PASS");
        } else {
            System.out.println("Delete element has not displayed FAILED");
        }
//        4- Delete tusuna basin
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
//        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement elementSample = driver.findElement(By.tagName("h3"));
        if (driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']")).isDisplayed()) {
            System.out.println("\'Add/Remove Elements\' text has displayed PASS");
        } else {
            System.out.println("\'Add/Remove Elements\' text has not displayed FAILED");
        }


    }
}
