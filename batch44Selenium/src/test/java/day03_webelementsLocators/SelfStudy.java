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
        driver.findElement(By.xpath("//a[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-action button2_type_link HeadBanner-Button with-shadow']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("adfsdf");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("qwerty");
        driver.findElement(By.id("login")).sendKeys("adfsdfqwerty");
        driver.findElement(By.id("password")).sendKeys("123456.adfsdfqwerty");
        driver.findElement(By.id("password_confirm")).sendKeys("123456.adfsdfqwerty");







    }
}
