package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C01_TekrarTesti {
    public static void main(String[] args) {
//        1. Bir class oluşturun : AmazonSearchTest
//        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        a.google web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//        b. Search(ara) “city bike”
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("city bike"+ Keys.ENTER);
//        c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        //WebElement count = driver.findElement(By.className("a-section"));
        WebElement count = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base']"));
        System.out.println(count.getText());
//        d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        /*WebElement firstProductPicture = driver.findElement(By.className("s-image"));
        firstProductPicture.click();*/
        //sadece click() yapmak gibi basit bir islemde kullanacagimiz web elementler icin
        //variable olusturmadan direk locate edip istedigimiz islmei yapabiliriz
        driver.findElement(By.className("s-image")).click();
    }
}
