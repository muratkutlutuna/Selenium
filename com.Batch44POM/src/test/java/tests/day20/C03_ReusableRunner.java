package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner {
    @Test
    public void test01() {
        //sayfa1'de  12.satirda 3.sutundaki hucreyi test et
        String path = "src/test/java/resources/ulkeler.xlsx";
        String expectedData = "Azerbaycan";
        String actualData = ReusableMethodsExcel.hucreGetir(path,"Sayfa1",11,2).toString();
        Assert.assertEquals(actualData, expectedData);




    }
}
