package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPages;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDefinitions {

    AmazonPages aP = new AmazonPages();

    @Given("kullanici amazon sayfasina gider")
    public void kullanici_amazon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
    }
    @Given("iPhone icin arama yapar")
    public void i_phone_icin_arama_yapar() {
        aP.searchBoxElement.sendKeys("iphone"+ Keys.ENTER);
    }
    @Then("sonuclarin iphone icerdigini test eder")
    public void sonuclarin_iphone_icerdigini_test_eder() {
        Assert.assertTrue(aP.resultTextElement.getText().contains("iphone"));
    }
    @Given("tea pot icin arama yapar")
    public void tea_pot_icin_arama_yapar() {
        aP.searchBoxElement.sendKeys("tea pot"+ Keys.ENTER);
    }
    @Then("sonuclarin tea pot icerdigini test eder")
    public void sonuclarin_tea_pot_icerdigini_test_eder() {
        Assert.assertTrue(aP.resultTextElement.getText().contains("tea pot"));
    }
    @Given("flower icin arama yapar")
    public void flower_icin_arama_yapar() {
        aP.searchBoxElement.sendKeys("flower"+ Keys.ENTER);
    }
    @Then("sonuclarin flower icerdigini test eder")
    public void sonuclarin_flower_icerdigini_test_eder() {
        Assert.assertTrue(aP.resultTextElement.getText().contains("flower"));
    }
}
