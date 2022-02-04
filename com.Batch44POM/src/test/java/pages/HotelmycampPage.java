package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelmycampPage {
    public HotelmycampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement firstLoginLink;

    @FindBy(id = "UserName")
    public WebElement usernameBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Try again please']")
    public WebElement incorrectAccessText;

    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath="//a[@id=\"menuHotels\"]")
    public WebElement hotelManagement;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelList;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoom;

    @FindBy(xpath = "//a[@href='/admin/HotelReservationAdmin']")
    public WebElement hotelReservations;

    @FindBy(xpath = "//div[@class='actions']")
    public WebElement addHotel;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement addHotelCodeBox;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement addHotelDropdown;

    @FindBy(xpath="//button[@id='btnSubmit']")
    public WebElement addHotelSaveButton;

    public void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void girisYap(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        firstLoginLink.click();
        usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginButton.click();
    }

}
