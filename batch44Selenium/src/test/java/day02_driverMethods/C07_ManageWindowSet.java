package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ManageWindowSet {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        1. Yeni bir Class olusturalim.C07_ManageWindowSet
//        2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
//        3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("sayfanin konumu = "+driver.manage().window().getPosition()+" sayfanin boyutu "+driver.manage().window().getSize());
//        4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(300,300));
        driver.manage().window().setSize(new Dimension (500,500));
//        5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        if (x == 300 && y == 300 && width == 516 && height == 500) {
            System.out.println("olceklendirme testi PASS");
        } else {
            System.out.println("olceklendirme testi FAILED");
            System.out.println("x="+x+" y="+y+" width="+width+" height="+ height);
        }
//        8. Sayfayi kapatin
        driver.close();
    }
}
