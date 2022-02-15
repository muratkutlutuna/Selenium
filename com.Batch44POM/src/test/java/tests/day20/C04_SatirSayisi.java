package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_SatirSayisi {
    @Test
    public void test01() throws IOException {
        //ulkeler excelindeki sayfa1 ve sayfa2'deki satir sayilarini
        //ve kullanilan satir sayilarini bulun

        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        int sayfa1SatirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();//index ile hesaplanir
        int sayfa1FizikiKullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();//normal sayma sayisi ile hesaplanir
        System.out.println("1.sayfa satir sayisi : " + sayfa1SatirSayisi);//190
        System.out.println("1.sayfa fiziki kullanilan satir sayisi = " + sayfa1FizikiKullanilanSatirSayisi);//191

        int sayfa2SatirSayisi = workbook.getSheet("Sayfa2").getLastRowNum();//index ile hesaplanir
        int sayfa2FizikiKullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();//normal sayma sayisi ile hesaplanir
        System.out.println("2.sayfa satir sayisi : " + sayfa2SatirSayisi);//190
        System.out.println("2.sayfa fiziki kullanilan satir sayisi = " + sayfa2FizikiKullanilanSatirSayisi);//191

    }
}
