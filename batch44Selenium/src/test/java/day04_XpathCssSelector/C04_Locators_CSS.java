package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_Locators_CSS {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        1 ) Bir class oluşturun : Locators_css
//        2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.
//        a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
//        b. Locate email textbox
        WebElement emailTextbox = driver.findElement(By.cssSelector("#session_email"));//xpath //input[@id='session_email']
        //# sadece id ler icin gecerli
//        c. Locate password textbox ve
        WebElement passwordTextbox = driver.findElement(By.cssSelector("input[id='session_password']"));//xpath //input[@id='session_password']
//        d. Locate signin button
        WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit']"));//xpath //input[@name='commit']
//        e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        emailTextbox.sendKeys("testtechproed@gmail.com");
        passwordTextbox.sendKeys("Test1234!");
        signInButton.click();
//        i. Username : testtechproed@gmail.com
//        ii. Password : Test1234!
//                NOT: cssSelector kullanarak elementleri locate ediniz.
    }
}
