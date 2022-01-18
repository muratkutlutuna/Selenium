package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       //1. Yeni bir class olusturun (TekrarTesti)
       //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        // doğrulayın (verify), eğer değilse doğru başlığı(Actual Title)
        // konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("youtube")) {
            System.out.println("title verified");
        } else {
            System.out.println("title is not verified");
            System.out.println("Actual title = "+driver.getTitle());
        }
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın,
        // içermiyorsa doğru URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("youtube")) {
            System.out.println("title contained at Url");
        } else {
            System.out.println("title is not contained at Url");
            System.out.println("Actual URL = "+driver.getCurrentUrl());
        }
       //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
       //5. Youtube sayfasina geri donun
        driver.navigate().back();
       //6. Sayfayi yenileyin
        driver.navigate().refresh();
       //7. Amazon sayfasina donun
        driver.navigate().forward();
       //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
       //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.
        actualTitle = driver.getTitle();
        if (actualTitle.equals("Amazon")) {
            System.out.println("title contained");
        } else {
            System.out.println("title is not contained");
            System.out.println("Actual title = "+driver.getTitle());
        }
       //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın,
        // degilse doğru URL'yi yazdırın
        actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals("https://www.amazon.com/")) {
            System.out.println("Url verified");
        } else {
            System.out.println("title is not verified");
            System.out.println("Actual Url = "+driver.getCurrentUrl());
        }
       //11.Sayfayi kapatin
        driver.quit();
    }


}
