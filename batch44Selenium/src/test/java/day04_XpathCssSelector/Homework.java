package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Homework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/driver/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.  https://app.hubspot.com/login sayfasina gidin
        driver.get("https://app.hubspot.com/login");
        Thread.sleep(6000);
        //2.  Bir mail adersi giriniz
        WebElement mail = driver.findElement(By.xpath("//input[@id='username']"));
        mail.sendKeys("abcdefgh@gmail.com");
        //3.  Bir password giriniz
        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
        pwd.sendKeys("123456,.aA");
        //4.  Login butonuna tiklayiniz
        WebElement loginBtn = driver.findElement(By.id("loginBtn"));
        loginBtn.click();
        //5.  "That email address doesn't exist." texti gorunur ise
        //6.  "kayit yapilamadi" yazdiriniz
        //8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        WebElement notExistAlert = driver.findElement(By.xpath("//h5[@class='Heading-nhr39c-0 H5-xrl7qn-0 hdtmNA private-alert__title']"));
        if (notExistAlert.isDisplayed()) {
            System.out.println("Kayit yapilmadi");
        } else {
            System.out.println("Kayit yapildi");
        }
        //9.  Tum sayfalari kapatiniz
        driver.quit();
    }
}
