package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_ManageWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        1. Yeni bir Class olusturalim.C06_ManageWindow
//        2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//        3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("defaultken; sayfanin konumu = "+driver.manage().window().getPosition()+" sayfanin boyutu "+driver.manage().window().getSize());
//        4. Sayfayi simge durumuna getirin
        Thread.sleep(1000);
        driver.manage().window().minimize();
        Thread.sleep(1000);
        System.out.println("minimizeken; sayfanin konumu = "+driver.manage().window().getPosition()+" sayfanin boyutu "+driver.manage().window().getSize());
//        5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(1000);
        driver.manage().window().maximize();
//        6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Maximizeken; sayfanin konumu = "+driver.manage().window().getPosition()+" sayfanin boyutu "+driver.manage().window().getSize());
//        7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
//        8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Full Screenken; sayfanin konumu = "+driver.manage().window().getPosition()+" sayfanin boyutu "+driver.manage().window().getSize());
//        8. Sayfayi kapatin
        driver.quit();

    }
}
