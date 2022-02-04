package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageIlkClass {
    //Amazon'a gidelim
    //arama kutusuna Nutella yazip aratalim
    //arama sonuclarinin Nutella icerdigini test edelim

    //PageObjectModel POM de farkli class'larda farkli sekilde ulasoilmasi benimsenmistir
    //Driver class'i icin static yontemi kullaniyoruz
    //Page Class'lari icin ise obje uzerinden kullanilmasi tercih edilmistir

    @Test
    public void test01(){
        //Amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //arama kutusuna Nutella yazip aratalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edelim
        String actualSonucStr = amazonPage.sonucYazisiElementi.getText();
        Assert.assertTrue(actualSonucStr.contains("Nutella"));
        Driver.closeDriver();

    }
    @Test
    public void test02(){
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //java icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Java" + Keys.ENTER);
        //sonucun java icerdigini test edelim
        String sonucYazisiStr = amazonPage.sonucYazisiElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Java"));
        Driver.closeDriver();


    }

}
