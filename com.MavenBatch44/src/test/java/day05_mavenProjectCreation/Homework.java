package day05_mavenProjectCreation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Homework {
    public static void main(String[] args) throws InterruptedException {
        //1. Bir class oluşturun: LocatorsIntro
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        // b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[@id='sign-in']")).click();
        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement email = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        WebElement password = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        String username = "testtechproed@gmail.com";
        email.sendKeys(username);
        // ii.Password : Test1234!
        password.sendKeys("Test1234!");
        signInButton.click();
        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String currentUser = driver.findElement(By.xpath("//span[@data-test='current-user']")).getText();
        if (currentUser.equals(username)) {
            System.out.println("username is VERIFIED");
        } else {
            System.out.println("username is FAILED");
        }
        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses = driver.findElement(By.xpath("//a[text()='Addresses']"));
        if (addresses.isDisplayed()) {
            System.out.println("Address display is VERIFIED");
        } else {
            System.out.println("Address display is FAILED");
        }
        WebElement signOut = driver.findElement(By.xpath("//a[text()='Sign out']"));
        if (signOut.isDisplayed()) {
            System.out.println("Sign out display is VERIFIED");
        } else {
            System.out.println("Sign out display is FAILED");
        }
        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println(linkList.size()+" adet link vardir");
        //4.Linklerin yazisini nasil yazdirabiliriz
        System.out.print("\nLinklerin yazilari ==> ");
        for (WebElement link : linkList) {
            System.out.print(link.getText()+" ");
        }
        //5. driver i kapatin
        driver.quit();
    }
}
