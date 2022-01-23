package day06_Junit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homework {
    static WebDriver driver;
    static String []resultNumberString;
    static int result;
    static List<WebElement> categories = new ArrayList<WebElement>();
    static String []allResult;
    static boolean flag;
    @Test
    public void test01() {
//● https://www.amazon.com/ adresine gidin.
//            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin
        categories = driver.findElements(By.xpath("//select[@id=\"searchDropdownBox\"]/option"));
        result = categories.size();
        if (result == 45) {
            System.out.println("Category Number PASSED");
        } else {
            System.out.println("Category Number FAILED");
        }
    }
    @Test
    public void test02() {//-Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin
        driver.findElement(By.xpath("//option[@value=\"search-alias=stripbooks-intl-ship\"]")).click();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
        resultNumberString = driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText().split(" ");
        result = Integer.parseInt(resultNumberString[3].replaceAll("\\D",""));
        System.out.println(result);
        for (String s : resultNumberString) {
            if (s.contains("Java")) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("result contains Java PASSED");
        } else {
            System.out.println("result contain not Java FAILED");
        }
    }
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']")).click();
    }
    @AfterClass
    public static void afterClass() {
        driver.quit();
    }


}
