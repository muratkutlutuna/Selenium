package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {
    //1) com.techproed altinda bir package olustur : smoketest
    //2) Bir Class olustur : PositiveTest
    //3) Bir test method olustur positiveLoginTest()
    @Test
    public void positiveLoginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.firstLoginLink.click();
        hotelmycampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelmycampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelmycampPage.loginButton.click();
        Assert.assertTrue(hotelmycampPage.basariliGirisYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
    //         https://www.hotelmycamp.com adresine git
    //        login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
}
