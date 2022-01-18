package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class C05_NavigationMethods {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");

//        1. Yeni bir Class olusturalim.C02_NavigationMethods
//        2. Youtube ana sayfasina gidelim . https://www.youtube.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
//        3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
//        4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
//        5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
//        6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
//        7. Sayfayi tam ekran yapalim
        driver.manage().window().maximize();
//        8. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();// quit varsa acik olan tum sayfalari kapatir
                      // close ise sadece driver'in o anki sayfasini kapatir
    }
}
