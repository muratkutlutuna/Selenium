package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        WebDriverManager.chromedriver().setup();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void tumSayfaScreenshot() throws IOException {
        TakesScreenshot tss = (TakesScreenshot)driver;
        String tarih = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File tumSayfa = new File("target/screenShot/tumsayfa"+tarih+".png");
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfa);
    }

    public void tumSayfaScreenshot(String name) throws IOException {
        TakesScreenshot tss = (TakesScreenshot)driver;
        String pathname = "target/screenShot/" + name + ".png";
        File tumSayfa = new File(pathname);
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfa);
    }

}
