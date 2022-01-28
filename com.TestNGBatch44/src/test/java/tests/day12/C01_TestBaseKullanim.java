package tests.day12;

import org.testng.annotations.Test;
import tests.day10.C01_Alerts;
import utilities.TestBase;

public class C01_TestBaseKullanim {
    @Test
    public void test01() {
        //projeniz icerisindeki herhangi bir class'tan obje olusturabilir ve o obje sayesinde ait oldugu class'daki tum variable ve method'lara (accessModifier izin verdigi surece) ulasabilirim

        C01_Alerts obj = new C01_Alerts();

        //eger proje kapsaminda bir class'tan obje olusturulmasini engellemek istersek
        // 1- o class'in constructor'ini private yaparsiniz
        // 2- class'in kendisini abstract yapabiliriz.
        // 1.method cok tercih edilmez, cunku OOP konsept'e uymaz(cok sinirli sayida kullanimi vardir)
        // 2.method'u kullanabiliriz boylece o class'taki abstract olmayan (concrete) methodlari override etmek mecburiyeti olmadan kullanabiliriz ama obje olusturamayiz

        //ornegin biz TestBase class'ini abstract yaptigimizdan obje olusturamayiz ama child class'lardan TestBase'deki setUp() ve tearDown() methodlarini kullanabiliriz
        //TestBase obj1 = new TestBase();
    }

}
