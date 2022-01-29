package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        //Upload butonuna basalim.
        //“File Uploaded!” textinin goruntulendigini test edelim
        driver.get("https://the-internet.herokuapp.com/upload");
        String path = System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.ods";
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(path);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='uploaded-files']")).isDisplayed());
    }
}
