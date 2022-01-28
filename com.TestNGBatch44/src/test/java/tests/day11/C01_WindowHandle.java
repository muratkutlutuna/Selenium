package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void handleWindows() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String windowHandle1 = driver.getWindowHandle();
        System.out.println("1st driver.getWindowHandle() = "+windowHandle1);
        driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencere acilir
        driver.get("https://www.bestbuy.com");
        String windowHandle2 = driver.getWindowHandle();
        System.out.println("2nd driver.getWindowHandle() = "+windowHandle2);
        Thread.sleep(2000);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
//        String windowHandle3 = driver.getWindowHandle();
//        System.out.println("3th driver.getWindowHandle() = " + windowHandle3);
        //amazon'un acik oldugu sayfaya gecin nutella icin arama yapin
        driver.switchTo().window(windowHandle1);
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(2000);
        //bestbuy acik olan sayfaya gecin ve title'in bestbuy icerdigini test edin
        driver.switchTo().window(windowHandle2);
        //Assert.assertTrue(driver.getTitle().contains("bestbuy"));
        //facebook'un acik oldugu sayfaya gecin
        //ve url'in https://www.facebook.com oldugunu test edin
        //eger acik olna pencerelerrden sadece bir tanesinin windowHandle degeroi bilinmiyorsa
        //once tum handle degerlerini bulup bir set'e koyariz
        windowHandles = driver.getWindowHandles();
        //Bu soru ici su anda set'te 3 window handle degeri var
        //1. ve 2. sayfanin window handle degerini biliyoruz
        //setimizde olup, ilk iki sayfa olmayan handle degeri 3. sayfanin handle degeri olacaktir.
        String windowHandle3 = "";
        for (String each : windowHandles) {
            if (!(each.equals(windowHandle2) || each.equals(windowHandle1))) {
                windowHandle3=each;
            }
        }
        System.out.println(windowHandle3);
        System.out.println(windowHandles);
        driver.switchTo().window(windowHandle3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Thread.sleep(2000);

    }
}
