package day03_webelementsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class HomeworkEdited {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        Thread.sleep(1000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(1000);
//        2.  Bir mail adersi giriniz
        driver.findElement(By.id("email")).sendKeys("asdfg@heroku.com");
//        3.  Bir password giriniz
        driver.findElement(By.id("password")).sendKeys("asdf1234..");
//        4.  Login butonuna tiklayiniz
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
//        5.  "There was a problem with your login." texti gorunur ise
//        6.  "kayit yapilamadi" yazdiriniz
//        8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        if (driver.findElement(By.xpath("//div[text()='There was a problem with your login.']")).isDisplayed()) {
            System.out.println("kayit yapilamadi");
        } else {
            System.out.println("Kayit yapilamadi");
        }
//        9.  Tum sayfalari kapatiniz
        driver.quit();
    }
}
