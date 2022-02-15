package tests.day20;

import org.apache.poi.ss.usermodel.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);

        //Biz FIS ile okudugumuz excel dosyasini projemiz icerisinde kullanabilmek icin
        //Apachi POI dependency yardimi ile bir Workbook olusturduk

        //Bu Workbook bizim projemizizin icerisinde ulkeler excelinin bir kopyasini kullanmamizi sagliyor

        //Excelin yapisi geregi bir hucreye(cell) ulasabilmek icin workbookdan baslayarak
        //sirasiyla sheet, row ve cell objeleri olusturmamisz gerekiyor

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(4);
        Cell cell = row.getCell(2);
        //String Andorra = workbook.getSheet("Sayfa1").getRow(4).getCell(2).toString();
        System.out.println("Andorra = " + cell);

        //indexi 4 olan satirdaki, indexi 2 olan hucrenin Andorra oldugunu test ediniz

        String expectedData = "Andorra";
        Assert.assertEquals(cell.getStringCellValue(), expectedData);

        //5.indexdeki satirin, 3.indexteki hucre bilgisini yazdiralim

        row = sheet.getRow(5);
        cell=row.getCell(3);
        System.out.println(cell);

    }



}
