package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesFirstClass {
    @Test
    public void positiveLoginTesti(){
        //HotelMyCamp sitesini POM a uygun olarak test ediniz
        //https://www. hotelmycamp.com/ adresine git
        //Driver.getDriver().get("buraya properties dosyasina git HMCUrl'w karsilik gelen degeri getir");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //        login butonuna bas
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.firstLoginLink.click();
        //    test data username: manager ,
        hotelmycampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        //    test data password : Manager1!
        hotelmycampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelmycampPage.loginButton.click();
        Assert.assertTrue(hotelmycampPage.basariliGirisYaziElementi.isDisplayed());
        hotelmycampPage.wait(3);
        Driver.closeDriver();
    }

}
