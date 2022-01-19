package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
//        3- Delete butonu’nun gorunur oldugunu test edin
        if (driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).isDisplayed()) {
            System.out.println("Delete element has displayed PASS");
        } else {
            System.out.println("Delete element has not displayed FAILED");
        }
//        4- Delete tusuna basin
        driver.findElement(By.xpath("//button[@class='added-manually']")).click();
//        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement elementSample = driver.findElement(By.tagName("h3"));
        WebElement elementSample2 = driver.findElement(By.tagName("//h3[text()='Add/Remove Elements']"));
        if (driver.findElement(By.xpath("//h3")).isDisplayed()) {
            System.out.println("\'Add/Remove Elements\' text has displayed PASS");
        } else {
            System.out.println("\'Add/Remove Elements\' text has not displayed FAILED");
        }


    }
}
