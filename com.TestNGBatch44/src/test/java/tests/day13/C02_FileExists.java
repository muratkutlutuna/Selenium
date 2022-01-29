package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));//C:\Users\T450s

        //masaustundeki deneme klasorunun path'ini
        //"C:\Users\T450s\Desktop\deneme\selenium.ods"

        //yani dinamik olarak masaustundeki deneme klasorunun path'ini yazmak istersem

        String path = System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.ods";
        System.out.println("path = " + path);
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        //Masaustunde deneme klasoru icerisinde selenium.ods isminde bir dosya oldugunu test edin
        //*************masaustunuzde demen klasoru ve icinde selenium.ods olmazsa calismaz
        //1- once bu dosyaya ulasmak icin gerekli dinamik path olusturulmali

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\deneme\\selenium.ods";

        System.out.println("Files.exists(Paths.get(dosyaYolu)) = " + Files.exists(Paths.get(dosyaYolu)));

        //projemize pom.xml oldugunu test edin
        //C:\Users\T450s\Desktop\git-github\Selenium\com.TestNGBatch44\pom.xml

        String pomPath = System.getProperty("user.dir");
        path = pomPath + "pom.xml";
        System.out.println("Files.exists(Paths.get(projectPath)) = " + Files.exists(Paths.get(pomPath)));
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));


    }
}
