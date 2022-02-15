package tests.practise;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.WebTablePage;
import utilities.Driver;

public class P02_WebTableTest {
    /*
go to url : https://en.wikipedia.org/wiki/Dell
go to table which name is 'List of companies acquired by Dell Inc.'
print row 4 of the table on console
also print on console the 2nd and 3rd elements (middle 2 elements) in line 5
( 2nd and 3rd elements : November 2, Cloud integration leader)

url'ye gidin: https://en.wikipedia.org/wiki/Dell
'List of companies acquired by Dell Inc.' isimli tabloya gidin,
tablonun 4. satırını konsolda yazdırın
ayrıca 5. satırdaki 2. ve 3. öğeleri (ortadaki 2 öğe) konsola yazdırın
( 2nd and 3rd ogeler : November 2, Cloud integration leader)
*/
    @Test
    public void tableTest() {
        Driver.getDriver().get("https://en.wikipedia.org/wiki/Dell");
        WebTablePage wtp = new WebTablePage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", wtp.nameOfList);

        System.out.println("4.satir: " + wtp.fourthRow.getText());
        System.out.println("2. oge: " + wtp.secondElement.getText());
        System.out.println("3. oge: "+wtp.thirdElement.getText());

        Driver.closeDriver();


    }
}
