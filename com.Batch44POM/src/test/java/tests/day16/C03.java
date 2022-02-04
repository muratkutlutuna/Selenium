package tests.day16;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03 {
    //1 - https://www.facebook.com/ adresine gidin
    @Test
    public void test01(){
        Driver.getDriver().get("https://www.facebook.com");
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookies.click();
        Faker faker = new Faker();
        facebookPage.mailTel.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        facebookPage.signInButton.click();
        Assert.assertTrue(facebookPage.incorrectText.isDisplayed());
        Driver.closeDriver();
    }
    //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
    //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
    //4- Basarili giris yapilamadigini test edin
}
