package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    //kimse Driver driver = new Driver(); deyip yeni bir driver uretemesin diye constructor'umu private yaptim
    private Driver(){}
    //kimse driver variable ima ulasamasin, belki hatta degistiremesin diye driver'i da private yaptim
    private static WebDriver driver;
    private static Map<String,Object> prefs = new HashMap<String,Object>();
    private static ChromeOptions chromeOpt;
    private static ProfilesIni profile;
    private static FirefoxProfile testprofile;
    public static WebDriver getDriver() {
        if (driver == null) {//bu if sayesinde kod calisirken bir kere new keyword ile driver olusturulunca
            // bir daha yeni driver olusturmayacak
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    chromeOpt = new ChromeOptions();
                    chromeOpt.setExperimentalOption("prefs", prefs);
                    chromeOpt.addArguments("start-maximized");
                    chromeOpt.addArguments("disable-infobars");
                    chromeOpt.addArguments("--disable-extensions");
                    chromeOpt.addArguments("--disable-notifications");
                    driver = new ChromeDriver(chromeOpt);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    profile = new ProfilesIni();
                    testprofile = profile.getProfile("default");
                    testprofile.setPreference("dom.webnotifications.enabled", false);
                    testprofile.setPreference("dom.push.enabled", false);
                    driver = new FirefoxDriver((Capabilities) testprofile);
                    break;
                case "opera":
                    WebDriverManager.chromedriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.chromedriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }



}
