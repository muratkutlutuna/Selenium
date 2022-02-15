package tests.day19;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebtablesHomework {
    //Bir Class olusturun D19_WebtablesHomework
    @Test(groups = {"smoke", "miniRegression"})
    public void test01() throws InterruptedException {
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));
        DemoqaPage demoqaPage = new DemoqaPage();
        //  2. Headers da bulunan department isimlerini yazdirin
        // normalde//thead//tr `olurdu ancak bu tablo class isimleri organize edilmis
        System.out.print("table head = "+demoqaPage.thead.getText().replaceAll("\n",", "));
        //ikinci bir yontem olarak basliklari bir listeye koyabilirim
        //theadWebElementList
        //  3. sutunun basligini yazdirin
        System.out.println("\n\n3.Column header = "+demoqaPage.theadWebElementList.get(2).getText());
        //  4. Tablodaki tum datalari yazdirin
        System.out.print("\nbodyOnlyWebElement = " + demoqaPage.bodyOnlyWebElement.getText().replaceAll("\n",", "));
        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("\n\nall element number = " + demoqaPage.tableData.size());
        //  6. Tablodaki satir sayisini yazdirin
        System.out.print("\nAll rows element list = ");
        demoqaPage.allRowsWebElementList.forEach(t-> System.out.print(t.getText().replaceAll("\n",", ")+" "));
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("\n\ncolumn number = "+(demoqaPage.tableData.size() / demoqaPage.allRowsWebElementList.size()));
        //  8. Tablodaki 3.kolonu yazdirin
        System.out.print("\nprint column = ");
        demoqaPage.printColumn(3);
        //((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[2]
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("\n");
        demoqaPage.nameToSalary("Kierra");
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.print("\nprint row 2 column 3 of the cell = ");
        demoqaPage.printCell(2,3);
        Driver.closeDriver();
    }
}
