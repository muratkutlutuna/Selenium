package tests.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class E03 extends TestBase {
    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(100);
        deleteButtonsAndValidate();
    }

    public static void createButtons(int num) {
        WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i < num; i++) {
            button.click();
        }
    }


    public static void deleteButtonsAndValidate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter a number to delete element : ");
        int num = scan.nextInt();
        List<WebElement> deletes = driver.findElements(By.xpath("//Button[@class='added-manually']"));
        int deletesSize = deletes.size();
        int i = 0;
        if (num > deletes.size())
            num = deletes.size();
        while (i < num) {
            deletes.get(i).click();
            deletes.remove(i);
            i++;
        }
        int expectedDeletedNum = deletesSize-deletes.size();
        int actualDeletedNum = deletesSize-driver.findElements(By.xpath("//Button[@class='added-manually']")).size();
        Assert.assertEquals(actualDeletedNum, expectedDeletedNum, "deleted Number is not correct");
        System.out.println("Test PASSED");

    }
}


