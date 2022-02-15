package tests.day22;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_FacebookTesti extends TestBaseRapor {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("facebook","fake isim ile facbook sayfasina kayit olundu");
        Driver.getDriver().get("https://www.facebook.com");
        extentTest.info("facebook sayfasina gidildi");
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookies.click();
        extentTest.info("cookies halledildi");
        Faker faker = new Faker();
        facebookPage.mailTel.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        facebookPage.signInButton.click();
        extentTest.info("facebook giris bilgileri faker ile yapildi");
        Assert.assertTrue(facebookPage.incorrectText.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.pass("girilmedigi test edildi");
    }
}
