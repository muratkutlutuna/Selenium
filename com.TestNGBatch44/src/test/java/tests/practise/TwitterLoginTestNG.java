package tests.practise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Locale;

public class TwitterLoginTestNG extends TestBase {
    @Test
    public void testLogin() throws Exception {
        //twitter sitesine gittim
        driver.get("https://www.twitter.com");
        //giris yap butonuna tikla
        driver.findElement(By.xpath("//div[@class='css-901oao r-1awozwy r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']")).click();
        Faker faker = new Faker(new Locale("tr"));






    }


}
