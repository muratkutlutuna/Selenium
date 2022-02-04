package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class Q06 extends TestBase {
    //    go to url :http://demo.automationtesting.in/Alerts.html
    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[.='Alert with OK ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        //    accept Alert(I am an alert box!) and print alert on console
        w.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();///////////////
        System.out.println("Alert text = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//a[.='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
//        Actions actions=new Actions(driver);
//        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//a[.='Alert with Textbox ']")).click();
        w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='btn btn-info']"))));
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys(Keys.BACK_SPACE+"Kutlu Tuna");
        driver.switchTo().alert().accept();
        //    finally print on console this message "Hello TechproEducation How are you today"
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='demo1']")));
        WebElement resultElement = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println("resultElement = " + resultElement);
    }
}
