package tests.practise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class Q07 extends TestBase {
    @Test
    public void test01(){
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button1")).click();
        String popupText = driver.switchTo().alert().getText();
        String expectedText = "I am an alert box!";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(popupText,expectedText);
        driver.switchTo().alert().accept();
        softAssert.assertAll();
    }

    @Test(dependsOnMethods="test01")
    public void test02(){
        driver.navigate().to("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button4")).click();
        Alert alert = driver.switchTo().alert();
        String popupText = alert.getText();
        String expectedText = "Press a button!";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(popupText,expectedText);
        alert.dismiss();
        //driver.switchTo().alert().dismiss();
        softAssert.assertTrue(driver.findElement(By.id("confirm-alert-text")).isDisplayed());

        softAssert.assertAll();
    }
    // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
    // 2. CLICK ME of JavaScript Alert e tıklayın
    // 3. pop up text i alın
    // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
    // 5. pop up i kabul edin
    // Yine ayni class da baska test methodu olusturun
    // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
    // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
    // 3.  pop up text i alın
    // 4. Mesajın "Press a button!" olduğunu doğrulayın
    // 5. Açılır pencereyi kapat
    // 6. pop up i iptal edin,
    // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
    // 8. alert1'e göre dependsOnMethods kullanın
}
