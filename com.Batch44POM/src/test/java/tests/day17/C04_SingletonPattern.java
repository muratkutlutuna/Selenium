package tests.day17;

import org.testng.annotations.Test;

public class C04_SingletonPattern {
    @Test
    public void test01(){

        //singleton pattern bir class'tan birden fazla obje uretilmesine
        // izin vermeyen bir pattern olarak kabul gormustur

        //biz Driver class'ini driver uretmek uzere kullaniyoruz
        //ancak Driver class'oinda driver isminde bir instance variable da var
        //ve biz obje ureterek bu instance driver'a ulasabiliriz
//        Driver driver = new Driver();
//        Driver driver2 = new Driver();
//        Driver driver3 = new Driver();

        //singleton pattern kabul gormus bir patterndir
        //amac bir class'tan obje uretilmemesini saglamaktir
        //bunun icin singleton pattern'de koruyacagimiz class'da
        //parametresiz bir constructor olusturur ve bu constructor'i
        // private yapariz


    }
}
