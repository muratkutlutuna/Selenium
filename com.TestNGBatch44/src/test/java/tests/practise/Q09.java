package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q09 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
//        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
//        Actions actions = new Actions(driver);
//
//        List<WebElement> dragableelement = driver.findElements(By.xpath("//div[@dragableelement]"));
//        dragableelement.sort();
//        System.out.println("dragableelement.size() = " + dragableelement.size());
//        System.out.println("dragableelement = " + dragableelement);
//        List<WebElement> dragableBoxRight = driver.findElements(By.className("dragableBoxRight"));
//        System.out.println("dragableBoxRight.size() = " + dragableBoxRight.size());
//        dragableBoxRight.forEach(WebElement::getText);
//        System.out.println("dragableBoxRight = " + dragableBoxRight);
//        for (int i = 0; i < dragableBoxRight.size(); i++) {
//            actions.dragAndDrop(dragableelement.get(i*2), dragableBoxRight.get(i)).perform();
//        }
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //capitals
        WebElement oslo  = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement stockholm  = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement washington  = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement copenhagen  = driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement seoul  = driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement rome  = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement madrid  = driver.findElement(By.xpath("//div[@id='box7']"));
        //country
        WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
        WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
        WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
        WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
        WebElement korea = driver.findElement(By.xpath("//div[@id='box105']"));
        WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
        WebElement unitedState = driver.findElement(By.xpath("//div[@id='box103']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(oslo,norway)
                .dragAndDrop(stockholm,sweden)
                .dragAndDrop(washington,unitedState)
                .dragAndDrop(copenhagen,denmark)
                .dragAndDrop(seoul,korea)
                .dragAndDrop(rome,italy)
                .dragAndDrop(madrid,spain).perform();
        Thread.sleep(4000);
        // Fill in capitals by country.




    }

}
