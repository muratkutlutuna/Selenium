package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        1-C01_TekrarTesti isimli bir class olusturun
//        2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
//        3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();
//        4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedOutput = "Google";
        String actualOutput = driver.gettitle1();
        if (actualOutput.contains(expectedOutput)) {
            System.out.println("title1 contains PASS");
        } else {
            System.out.println("title1 is not contain FAILED");
        }
//        5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Nutella"+ Keys.ENTER);
//        6-Bulunan sonuc sayisini yazdirin
        WebElement resultElement = driver.findElement(By.id("result-stats"));
        System.out.println(resultElement.getText());
//        7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String result = resultElement.getText();
        String[]resultWords = result.split(" ");
        int resultNum = Integer.parseInt(resultWords[1].replaceAll("\\D",""));
        if (resultNum > 10000000) {
            System.out.println("10000000 Test PASS");
        } else {
            System.out.println("10000000 Test FAILED");
        }
//        8-Sayfayi kapatin
        driver.quit();
    }
}
