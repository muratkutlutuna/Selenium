package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void test(){
        int a = 10;
        int b = 20;
        int c = 30;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(a, a,"1.test failed");//failed
        softAssert.assertTrue(c > b,"2.test failed");//failed
        softAssert.assertTrue(a < c,"3.test failed");//passed
        softAssert.assertTrue(c > b,"4.test failed");//passed
        softAssert.assertTrue(b > a,"5.test failed");//failed
        //assertAll demezsek class calisir ve passed yazar , cunku aslinda raporlama yapmaz
        //sadece kodlar calismis olur
        softAssert.assertAll();
        System.out.println("eger soft assertlerden failed olan yoksa bu satir calisir");
    }
}
