package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class E06 extends TestBase {

    //   ...Exercise6...
    @Test
    public void test01() {
// 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");
        //    kategorilerin hepsini konsola yazdiralim
        Select select = new Select(driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']")));
        List<WebElement> options = select.getOptions();
        System.out.println("options = " + options);
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Miserables" + Keys.ENTER);
        // 4. Sonuc sayisini ekrana yazdiralim.
        WebElement resultTest = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("sonuc yazisi" + resultTest.getText());
        // 5. Sonucların Les Miserables i icerdigini assert edelim
        Assert.assertTrue(resultTest.getText().contains("Miserables"));

    }


}
