package tests.practise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoGuru99;
import utilities.Driver;

public class P01_DemoGuruTest {
    /*
    http://demo.guru99.com/test/drag_drop.html url e git
    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
    Perfect butonun goruntulendigini dogrulayin
     */
    @Test
    public void test01() {
        Driver.getDriver().get("http://demo.guru99.com/test/drag_drop.html");
        DemoGuru99 dg = new DemoGuru99();
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dg.bankButton, dg.debitAccountArea)
                .dragAndDrop(dg.salesButton, dg.creditAccountArea)
                .dragAndDrop(dg.first5000Button, dg.debitAmountArea)
                .dragAndDrop(dg.second5000Button, dg.creditAmountArea)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Assert.assertTrue(dg.perfectButton.isDisplayed());
        Driver.closeDriver();
    }
}
//● Exact Text Belirli bir text) ile element bulma:
//○ //tagname[.='text name'] Belirli bir tagname , herhangi bir attribute, belirli bir text
//○ //*[.='text name'] Herhangi bir tag, belirli bir text.
//○ //*[(text()='exact text with extra space and all')] Herhangi bir tag, belirli bir text
//● Belirli bir metni içeren bir öğeyi bulmak için şunları kullanabiliriz:
//○ //*[contains(text(),'piece of text')]