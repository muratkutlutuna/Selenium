package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCWebTablePage {
    HMCWebTablePage hmcWebTablePage;
    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> headerFirstRowDatas;
    @FindBy(xpath = "//tbody")
    public WebElement allBodyWebElement;
    @FindBy(xpath = "//tbody//td")
    public List<WebElement> allBodyWebElementList;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> rowsList;

    public HMCWebTablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getRow(int rowNumber) {
        //2.satir'i yazdir //tbody//tr[2]
        //7.satir'i yazdir //tbody//tr[7]
        String rowDynamicXpath = "//tbody//tr[" + rowNumber + "]";
        WebElement rowElement = Driver.getDriver().findElement(By.xpath(rowDynamicXpath));
        return rowElement;
    }


    public String printCell(int rowNumber, int dataNumber) {
        String cellDynamicXpath = "//tbody//tr[" + rowNumber + "]//td[" + dataNumber + "]";
        WebElement cellElement = Driver.getDriver().findElement(By.xpath(cellDynamicXpath));
        return cellElement.getText();
    }

    public void printColumn(int columnNumber) {
        int rowNumber = rowsList.size();
        for (int i = 1; i <= rowNumber; i++){
            System.out.println(printCell(i,columnNumber));
        }
    }
}
