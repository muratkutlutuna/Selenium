package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelmycampPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class C02_Webtables {
    HotelmycampPage hotelmycampPage;
    HMCWebTablePage hmcWebTablePage;
    @Test(priority =0)
    public void test01(){
        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //            ○ Username : manager
        //            ○ Password : Manager1!
        hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.girisYap();

    }
    @Test(priority =1)
    public void loginT(){
        //● table( ) metodu oluşturun
        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // thead/tr[1]//th
        hmcWebTablePage = new HMCWebTablePage();

        List<WebElement> headerDataList = hmcWebTablePage.headerFirstRowDatas;
        System.out.println("headerDataListSize = " + headerDataList.size());
        System.out.println(hmcWebTablePage.allBodyWebElement.getText());
        List<WebElement> allBodyWebElementList = hmcWebTablePage.allBodyWebElementList;
        System.out.println("allBodyWebElementList.Size = " + allBodyWebElementList.size());

    }

        @Test(priority =2)
    public void printRows(){
            //● printRows( ) metodu oluşturun //tr
            //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
            //   //tbody//tr
            hmcWebTablePage = new HMCWebTablePage();
            System.out.println(hmcWebTablePage.rowsList.size());
            //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            List<WebElement>rowsWebElementsList = hmcWebTablePage.rowsList;
            System.out.println();
            rowsWebElementsList.forEach(t-> System.out.println(t.getText()));
            System.out.println();
            for (WebElement w : rowsWebElementsList) {
                System.out.println(w.getText());
            }
            System.out.println();
            //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
            System.out.println("4.satir : "+rowsWebElementsList.get(3).getText());
            //table//td o aman hepsini gosterir
        }
}
