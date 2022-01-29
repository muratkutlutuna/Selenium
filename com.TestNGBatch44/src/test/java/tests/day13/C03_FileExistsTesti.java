package tests.day13;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistsTesti {
    @Test
    public void test01(){
        //projemizde pom.xml oldugunu test edin

        String pomPath = System.getProperty("user.dir") + "\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));
    }

}
