package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void dropdownTesti() throws InterruptedException {
        //Dorpdown'da var olan seceneklerden birini secmek icin
        //1.adim dropdown web elementini locate edip bir degiskene atiyoruz
        driver.get("https://www.amazon.com");
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2.adim Select Class'indan bir obje olusturalim ve parametre olark locate ettigimiz webElementi yazalim
        Select select = new Select(dropdownElement);
        //3.adim select objesini kullanarak select class'indan vara olan uc secim method'undan
        //istedigimizi kullanarak dropdown'da var olan optionlardan birini secebiliriz
        //secim yapmamaiza yardim eden bu uc method void'dir dolayisiyla bize birsey dondurmazler

        select.selectByIndex(3);
        //System.out.println(select.selectByIndex(5));
        //eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption().getText());//Baby
        Thread.sleep(3000);
        select.selectByVisibleText("Deals");
        Thread.sleep(3000);
        select.selectByValue("search-alias=electronics-intl-ship");
        List<WebElement> optionList =select.getOptions();

        for (WebElement option : optionList) {
            System.out.print(option.getText());
        }

    }
}
