package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    HotelmycampPage hotelmycampPage;
    @Test
    public void wrongUsernameTest(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.firstLoginLink.click();
        hotelmycampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        hotelmycampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelmycampPage.loginButton.click();
        Assert.assertTrue(hotelmycampPage.incorrectAccessText.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void wrongPasswordTest(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.firstLoginLink.click();
        hotelmycampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelmycampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelmycampPage.loginButton.click();
        Assert.assertTrue(hotelmycampPage.incorrectAccessText.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void wrongUsernamePasswordTest(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.firstLoginLink.click();
        hotelmycampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        hotelmycampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelmycampPage.loginButton.click();
        Assert.assertTrue(hotelmycampPage.incorrectAccessText.isDisplayed());
        Driver.closeDriver();
    }
    //1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    //                - yanlisSifre
    //                - yanlisKulllanici
    //                - yanlisSifreKullanici
    //test data yanlis username: manager1 , yanlis password : manager1
    //2) https://www.hotelmycamp.com adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et
}
