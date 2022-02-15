package tests.practise;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TutorialsNinjaPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class P03_TutorialTest {
    //~ url'ye gidin: "http://tutorialsninja.com/demo/index.php?route=common/home"
//~ Phones & PDAs e tıklayın
//~ telefonların marka adını al
//~ tüm elemanlar için ekle düğmesine tıklayın
//~ siyah toplam eklenen sepet düğmesine tıklayın
//~ listenin isimlerini sepetten al
//~ görüntülenen listeden ve sepet listesinden isimleri karşılaştırın
//~ goruntulenen listede toplam fiyatin $583.19 oldugunu test edin
    @Test
    public void test() {
        Driver.getDriver().get("http://tutorialsninja.com/demo/index.php?route=common/home");
        TutorialsNinjaPage tnp = new TutorialsNinjaPage();
        tnp.phonesPdasButton.click();
        List<String> phoneBrands = tnp.phoneList.stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));
        tnp.phoneListAddToChart.stream().forEach(WebElement::click);
        tnp.basket.click();
        List<String> phoneBrandsInBasket = tnp.phoneListInBasket.stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(phoneBrandsInBasket);
        Collections.sort(phoneBrands);
        Assert.assertEquals(phoneBrandsInBasket, phoneBrands);
        String expectedPrice = "$583.19";
        String actualPrice = tnp.totalPrice.getText();
        Assert.assertEquals(actualPrice, expectedPrice);
        Driver.closeDriver();
    }
}
