package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

public class E01 extends TestBase {
    /*
   ...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
*/
    @BeforeMethod
    public void setUp2() {
        driver.get("http://www.bestbuy.com");
    }

    @Test
    public void test01() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "titel is not contain \'best\'");
    }

    @Test
    public void Test02() {
        WebElement helloWord = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloWord));
        Assert.assertTrue(logo.isDisplayed(), "logo is not displayed");
    }

    @Test
    public void test03() {
        WebElement usaFlagLink = driver.findElement(By.xpath("(//a[@class='us-link'])[1]"));
        WebElement mexicoFlagLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usaFlagLink));
        Assert.assertTrue(mexicoFlagLink.isDisplayed(), "link is not displayed");
    }


}
