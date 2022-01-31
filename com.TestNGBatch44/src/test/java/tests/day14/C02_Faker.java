package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class C02_Faker extends TestBase {
    @Test
    public void facebookKayitTesti() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']")).click();
       Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement element = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions = new Actions(driver);
        Random random = new Random();
        int birthDay = random.nextInt(1,29);
        int birthMonth = random.nextInt(1,12);
        int birthYear = random.nextInt(1950,2004);
        LocalDate birthDate = LocalDate.of(birthYear,birthMonth,birthDay);
        System.out.println("birthDate = " + birthDate);
        DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMM");
        String facebookMonth = monthFormat.format(birthDate);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);
        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);
        String mail = faker.internet().emailAddress(firstName.toLowerCase()+lastName.toLowerCase());
        System.out.println("mail = " + mail);
        String password = faker.internet().password(7,10,true,true,true);
        System.out.println("password = " + password);
        actions.click(element)
                .sendKeys(firstName)
                .sendKeys(Keys.TAB).sendKeys(lastName)
                .sendKeys(Keys.TAB).sendKeys(mail)
                .sendKeys(Keys.TAB).sendKeys(mail)
                .sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(facebookMonth)
                .sendKeys(Keys.TAB).sendKeys("15")
                .sendKeys(Keys.TAB).sendKeys("2000")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(4000);
        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin
    }
    @AfterClass
    public void tearDown(){

    }
}
