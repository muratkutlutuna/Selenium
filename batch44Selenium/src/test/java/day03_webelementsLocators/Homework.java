package day03_webelementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Homework {
    public static void main(String[] args) throws InterruptedException {
        //2-java class'imiza chromedriver.exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        //1-driver olusturalim
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

//add key and value to map as follow to switch off browser notification
//Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 2);

//Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

// set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);

//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        WebDriver driver = new ChromeDriver(options);
        //3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //4-https://github.com/ adresine gidelim
        driver.get("https://github.com/");
        //5-Ardindan https://www.hepsiburada.com/ adrsine gidelim
        driver.navigate().to("https://www.hepsiburada.com/");
        //6-Title ve url console da yazdirin ve yine title ve url in "burada" kelimesini icerip icermedigini kontrol edelim
        String expectedContainedText = "burada";
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedContainedText) && actualUrl.contains(expectedContainedText)) {
            System.out.println("URL and Title contain \"" + expectedContainedText + "\" text = PASSED");
        } else {
            System.out.println("URL and Title do not contain \"" + expectedContainedText + "\" text = FAILED");
        }
        //7-Sonrasinda https://github.com/ adresine geri donelim ve  sayfayi yenileyelim
        //driver.manage().deleteAllCookies();
        while (driver.getCurrentUrl().equals("https://www.hepsiburada.com/")) {
            driver.navigate().back();
        }
        driver.navigate().refresh();
        //8-Son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
