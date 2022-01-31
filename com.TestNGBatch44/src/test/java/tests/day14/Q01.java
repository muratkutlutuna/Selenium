package tests.day14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Q01 {
    @Test(priority = 3000)
    public void b() {
        System.out.println("b");
    }

    @Test(priority = 2001, enabled = false)
    @Ignore
    public void a() {
        System.out.println("a");
    }

    @Test(priority = 2000)
    public void c() {
        System.out.println("c");
    }

    @Test
    public void Test1() {
        System.out.println("Test1....");
    }

    @Test
    public void Test2() {
        System.out.println("Test2....");
    }

    @Test
    public void Test3() {
        System.out.println("Test3....");
    }

    @Test(enabled = false)
    public void Test4() {
        System.out.println("Test4....");
    }

    @Test(enabled = false)
    public void Test5() {
        System.out.println("Test5....");
    }

    @Test
    public void Test6() {
        System.out.println("Test6....");
    }


}