package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaPage {
    public DemoqaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='rt-tr']")
    public WebElement thead;

    @FindBy(xpath = "//div[@class='rt-th rt-resizable-header -cursor-pointer']")
    public List<WebElement> theadWebElementList;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    public WebElement bodyOnlyWebElement;

    @FindBy(xpath = "//div[@class='rt-td']")
    public List<WebElement> tableData;

    @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List<WebElement> allRowsWebElementList;

    public void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void printColumn(int column) {
        //((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[2]
        int rowNumber = allRowsWebElementList.size();
        String dynamicXpath="";
        WebElement tempElement = null;
        System.out.print(theadWebElementList.get(column-1).getText()+" ");
        for (int i = 1; i <= rowNumber; i++) {
            dynamicXpath = "((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+column+"]";
            tempElement = Driver.getDriver().findElement(By.xpath(dynamicXpath));
            System.out.print(tempElement.getText()+" ");
        }
    }


    public void nameToSalary(String name) {
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        int rowNumber = allRowsWebElementList.size();
        String dynamicXpath="";
        String nameInRow = "";
        String salary = "";
        for (int i = 1; i<=rowNumber; i++) {
            dynamicXpath = "((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+1+"]";
            nameInRow = Driver.getDriver().findElement(By.xpath(dynamicXpath)).getText();
            dynamicXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+5+"]";
            salary = Driver.getDriver().findElement(By.xpath(dynamicXpath)).getText();
            if (nameInRow.equals(name)) {
                System.out.println(name+"\'s salary = "+salary);
            }
        }

    }

    public void printCell(int row, int column) {
        String dynamicXpath = "((//div[@class='rt-tr-group'])[" + row + "]//div[@class='rt-td'])[" + column + "]";
        System.out.println(Driver.getDriver().findElement(By.xpath(dynamicXpath)).getText());
    }
}
