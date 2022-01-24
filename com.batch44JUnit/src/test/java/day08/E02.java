package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E02 {
    //  ...Exercise2...
//  1-driver olusturalim
//  2-java class'imiza chromedriver.exe'yi tanitalim
//  3-driver'in tum ekrani kaplamasini saglayalim
//  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
//    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
//  5-"sahibinden.com" adresine gidelim
//  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
//  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
//  8-Ardindan "gittigidiyor.com" adresine gidelim
//  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
//    kontrol edelim
//  10-Bi onceki web sayfamiza geri donelim
//  11-sayfayi yenileyelim
//  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
//  13-En son adim olarak butun sayfalarimizi kapatmis olalim
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sahibinden.com/");
        String url1 = driver.getCurrentUrl();
        String title1 = driver.getTitle();
        if (title1.contains("oto")) {
            System.out.println("title1 test PASED");
        } else {
            System.out.println("title1 test FAILED");
        }
        if (url1.contains("oto")) {
            System.out.println("url test PASSED");
        } else {
            System.out.println("url test FAILED");
        }
        driver.navigate().to("https://www.gittigidiyor.com/");
        boolean isTrue = driver.getTitle().contains("Sitesi");
        if (isTrue) {
            System.out.println("title2 test PASED");
        } else {
            System.out.println("title2 test FAILED");
        }
        String title = driver.getTitle();
        System.out.println("title = " + title);
        System.out.println(title.contains("Sitesi")?"PASS":"FAIL");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        
        driver.close();
        driver.quit();
    }
}
