package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
// amazon anasayfaya gidin
// sag ustte hello,signIn elementinin uzerinde mouse'u bekletin
// acilan menude new list linkine tiklayin
// ve new list sayfasinin acildigini test edin
public class C02_MouseActions extends TestBase {
    @BeforeMethod
    public void setUpMethod() {
        driver.get("http://www.amazon.com");
    }
    @Test
    public void amaonList() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement helloElement = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(helloElement).perform();
        WebElement createAListElement = driver.findElement(By.xpath("(//a[@class='nav-link nav-item'])[1]"));
        //actions.click(createAListElement).perform();
        actions.click(createAListElement).perform();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Your List";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        softAssert.assertAll();
    }

}
