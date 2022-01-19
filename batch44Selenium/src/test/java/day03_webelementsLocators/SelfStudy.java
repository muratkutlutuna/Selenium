package day03_webelementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SelfStudy {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://mail.yandex.com/");//go to the address for new mail account
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/button"));
        driver.findElement(By.tagName("Create an account")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/main/div/div/div/form/div[1]/div[1]/span/input")).sendKeys("adfsdf");






    }
}
