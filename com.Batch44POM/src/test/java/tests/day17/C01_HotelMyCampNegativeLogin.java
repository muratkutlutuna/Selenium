package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.Driver;

public class C01_HotelMyCampNegativeLogin {
    @Test
    public void NegativeLoginTest(){
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //         https://www. hotelmycamp.com/ adresine git
        //        login butonuna bas
        //    test data username: manager1 ,
        //    test data password : manager1!
        //    Degerleri girildiginde sayfaya girilemedigini test et
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.firstLoginLink.click();
        hotelmycampPage.usernameBox.sendKeys("manager1");
        hotelmycampPage.passwordBox.sendKeys("manager1!");
        hotelmycampPage.loginButton.click();
        //Assert.assertFalse(Driver.getDriver().getCurrentUrl().contains("UserAdmin"));
        Assert.assertTrue(hotelmycampPage.incorrectAccessText.isDisplayed());
        Driver.closeDriver();

    }
}
