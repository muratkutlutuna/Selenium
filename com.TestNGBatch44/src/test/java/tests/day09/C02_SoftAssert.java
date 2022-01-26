package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssert {
    // Yeni bir Class Olusturun : C03_SoftAssert
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // 1. “http://zero.webappsecurity.com/” Adresine gidin
// 2. Sign in butonuna basin
// 3. Login kutusuna “username” yazin
// 4. Password kutusuna “password” yazin
// 5. Sign in tusuna basin
// 6. Pay Bills sayfasina gidin
// 7. “Purchase Foreign Currency” tusuna basin
// 8. “Currency” drop down menusunden Eurozone’u secin
// 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    @Test
    public void Test01() {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        Select select = new Select(driver.findElement(By.id("pc_currency")));
        select.selectByValue("EUR");
        SoftAssert softAssert = new SoftAssert();
        String actualChoice = select.getFirstSelectedOption().getText();
        String expectedChoice = "Eurozone (euro)";
        softAssert.assertEquals(actualChoice, expectedChoice, "Dropdown choosed not right");
        System.out.println("Hard asserton olsaydi ve ilk assertion failed olsaydi bu satir calismaz");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> optionList = select.getOptions();
        String actualOptionListStringVersion = "";
        for (WebElement each : optionList) {
            actualOptionListStringVersion += "\"" + each.getText() + "\", ";
        }
        actualOptionListStringVersion=actualOptionListStringVersion.trim();
        actualOptionListStringVersion=actualOptionListStringVersion.substring(0,actualOptionListStringVersion.length()-1);
        String expectedListString = "\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\", \"Switzerland (franc)\", \"China (yuan)\", \"Denmark (krone)\", \"Eurozone (euro)\", \"Great Britain (pound)\", \"Hong Kong (dollar)\", \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand (dollar)\", \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";
        softAssert.assertEquals(actualOptionListStringVersion,expectedListString);
        softAssert.assertAll();
        System.out.println("testlerden failed olan varsa soft assertion assertAll methodundan sonraki kodlar calismaz");
    }
}
