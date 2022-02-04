package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Locale;

//1. Tests packagenin altına class olusturun: CreateHotel
//2. Bir metod olusturun: createHotel
//3. https://www.hotelmycamp.com adresine git.
//4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
//    a. Username : manager
//    b. Password  : Manager1!
//5. Login butonuna tıklayın.
//6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
//7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
//8. Save butonuna tıklayın.
//9. “Hotel was inserted successfully” textinin göründüğünü test edin.
//10. OK butonuna tıklayın.
public class C01_CreateHotel {
    @Test
    public void testCreateHotel(){
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.girisYap();
        hotelmycampPage.wait(3);
        hotelmycampPage.hotelManagement.click();
        hotelmycampPage.hotelList.click();
        hotelmycampPage.addHotel.click();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker(new Locale("de-CH"));
        actions.click(hotelmycampPage.addHotelCodeBox).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.PAGE_DOWN).perform();
        Select select = new Select(hotelmycampPage.addHotelDropdown);
        select.selectByVisibleText("Hotel Type2");
        hotelmycampPage.addHotelSaveButton.click();
    }
}
