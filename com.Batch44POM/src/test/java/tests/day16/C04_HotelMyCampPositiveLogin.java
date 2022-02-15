package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin {
    @Test(groups = {"miniRegression","smoke"})
    public void positiveLogin(){  //1 ) Bir Class olustur : PositiveTest
        //2) Bir test method olustur positiveLoginTest()
        //        https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        //        login butonuna bas
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.firstLoginLink.click();
        //    test data username: manager ,
        hotelmycampPage.usernameBox.sendKeys("manager");
        //    test data password : Manager1!
        hotelmycampPage.passwordBox.sendKeys("Manager1!");
        //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelmycampPage.loginButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("UserAdmin"));
        Driver.closeDriver();
    }
}
