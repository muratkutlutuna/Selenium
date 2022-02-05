package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelmycampPage;
import utilities.Driver;

public class C01_WebTableDinamikLocate {
    //3 test method'u olusturalim
    HMCWebTablePage hmcWebTablePage;
    HotelmycampPage hotelmycampPage;

    @Test
    public void printRowTest() {
        //1.method : satir numarasi verdiginde bana o satirdaki datalari yazdirsin

        //2.satir'i yazdir //tbody//tr[2]
        //7.satir'i yazdir //tbody//tr[7]

        hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.girisYap();
        hmcWebTablePage = new HMCWebTablePage();
        WebElement secondRow = hmcWebTablePage.getRow(2);
        System.out.println("secondRow = " + secondRow.getText());
        WebElement seventhRow = hmcWebTablePage.getRow(7);
        Driver.closeDriver();
    }

    @Test
    public void getCellTest() {
        //2.method : satir no ve data numarasi girdigimde verdigim datayi yazdirsin
        hotelmycampPage = new HotelmycampPage();
        hmcWebTablePage = new HMCWebTablePage();
        hotelmycampPage.girisYap();
        //2.satirin 4.datasi //tbody//tr[2]//td[4]
        System.out.println(hmcWebTablePage.printCell(2, 4));
        Driver.closeDriver();
    }
    @Test
    public void printColumnTest(){
        hotelmycampPage = new HotelmycampPage();
        hmcWebTablePage = new HMCWebTablePage();
        hotelmycampPage.girisYap();
        //3.method : sutun numarasi verdigimde bana tum sutunu yazdirsin
        hmcWebTablePage.printColumn(3);
        Driver.closeDriver();
    }
}
