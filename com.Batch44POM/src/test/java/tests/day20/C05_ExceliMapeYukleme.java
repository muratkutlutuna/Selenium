package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExceliMapeYukleme {
    @Test
    public void test01() {
        //dosya yolu ve sayfa ismi verilen bir excel sheet'i map olarak kaydeden
        //reusable bir method olusturalim

        String path = "src/test/java/resources/ulkeler.xlsx";
        String sayfaAdi = "Sayfa1";
        System.out.println(ReusableMethodsExcel.mapOlustur(path, sayfaAdi));

        //olusturdugumuz map'i kullanarak ulke ismi Turkey 'in bilgilerini yazdirin
        Map<String,String> ulkelerMap = ReusableMethodsExcel.mapOlustur(path, sayfaAdi);
        System.out.println("Turkey = " + ulkelerMap.get("Turkey"));
        //listede Netherland oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Netherlands"));

    }
}
