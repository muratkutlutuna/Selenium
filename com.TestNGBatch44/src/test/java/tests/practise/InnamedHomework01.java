package tests.practise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class InnamedHomework01 extends TestBase {
    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
    @Test
    public void test() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='shelf-item']"));
// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        System.out.print("sitede "+allElements.size()+" urun var, ");
        List<WebElement> allElementTitles = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        for (int i = 1; i <= allElementTitles.size(); i++) {
            System.out.print(i+".urun = "+allElementTitles.get(i).getText()+"  ");
        }
        System.out.println();
// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        ArrayList<String> allElementTitlesString = new ArrayList<>();
        allElementTitles.forEach(t->allElementTitlesString.add(t.getText()));
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        Thread.sleep(1000);
        Faker faker = new Faker();
        String dynamicXpathAddToChart, dynamicXpathItemName, dynamicXpathPrice = "";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        List<Double>priceList=new ArrayList<Double>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<Integer> intContainerList = new ArrayList<>();
        int randomNumber;
        for (int i = 1; i <= 5; i++) {
            // (Her ürün 1 defadan fazla eklenemez!)
            do {
                randomNumber = faker.random().nextInt(1, 16);
                intContainerList.add(randomNumber);
            }while (!intContainerList.contains(randomNumber));
            dynamicXpathAddToChart = "(//div[@class='shelf-item__buy-btn'])["+randomNumber+"]";
            Thread.sleep(1000);
            jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicXpathAddToChart)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpathAddToChart)));
            Thread.sleep(1000);
            jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(dynamicXpathAddToChart)));
            Thread.sleep(1000);
            dynamicXpathItemName = "(//p[@class='shelf-item__title'])[" + randomNumber + "]";
            System.out.println(randomNumber+".item = " + driver.findElement(By.xpath(dynamicXpathItemName)).getText());
            dynamicXpathPrice = "(//div[@class='val'])["+randomNumber+"]";
            priceList.add(Double.parseDouble(driver.findElement(By.xpath(dynamicXpathPrice)).getText().replace("$","").replaceAll("\\s+","")));
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();
            Thread.sleep(1000);
        }
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        Double expectedPriceSum = priceList.stream().reduce(0.0, Double::sum);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='bag bag--float-cart-closed']")).click();
        Thread.sleep(1000);
        Double actualPriceSum = Double.parseDouble(driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText().replace("$","").replaceAll("\\s+",""));
        Assert.assertEquals(actualPriceSum,expectedPriceSum,"sum is not right!!!!");
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        System.out.println("Test PASS!");
// 7.Checkout'a tıklayın
        driver.findElement(By.xpath("//div[@class='buy-btn']")).click();


    }
}
