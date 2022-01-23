package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {
    WebDriver driver;
    @Test
    public void test01() {
        //amazon.com'a gidelim, title'in amazon icerdigini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";

        /*if (actualTitle.equals(expectedTitle)) {
            System.out.println("amazon test PASSED");
        } else {
            System.out.println("amazon test FAILED");
        }*/
    }
    @Test
    public void test02() {
        //google.com'a gidelim ve basligin "google" icerdigini test edelim
        System.out.println("2.test method'u calisti");
    }

    @Before
    public void ayarlariDuzenle (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void ortaligiTopla() {
        driver.quit();
    }
}
