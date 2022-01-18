package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        //normalde selenium'un kendi ide si de var fakat biz daha kullanisli oldugu icin
        //      intellij kullaniyoruz
        //intellij'de yeni bir proje actigimizda oncelikle selenium kutuphanelerini
        //      projeye eklememiz gerekir
        //biz en ilkel haliyle projemize kutuphaneleri jar dosyalari alarak yukledik
        //bu ekledigimiz dosylarla artik driver'imizin ayarlarini yapabiliriz

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        //setPropert methodu iki oarametre ister
        // ilki kullanacaginiz browser'a ait drivver
        //ikinci parametre ise selenim itesinden indirip projemize ekledigimiz chromedriver'in path'i
        //winfows kullanicilari sona .exe eklerken' apple kullananlar .exe eklenmemeli
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.twitter.com");

        Thread.sleep(5000);
        //java'dan gelir,icine yazilan milisaniye kadar kodlarin calismasini durdurur

        driver.close();
        //driver.close class'in sonuna yazilir. cunku bu kod caloisinca driver'imiz kapanir
        // bu koddan sonra yeniden bir browser acmak istiyorsak driver'a yeni deger atamamiz gerekir

        driver = new ChromeDriver();




    }

}
