package tests.day18;

public class C00 {
    //POM:Page Object Model : Kabul gormus bir framework dizayn pattern'idir
    //Temel Amaci :

    //- Maintenance'i kolaylastirmak,
    //- tekrar eden kodlari tekrar tekrar yyazmaktan kurtulmak,
    //- faydali ve kullanilabilir method'lar olusturup bunu framework'un tamaminda
    //- Test datalarini tek merkezden kontrol edebilmek,
    //- Sonradan projeye katilanlarin framework'un kolayca anlayabilmesini saglamak
    //- Dinamik test method'lari yazabilmek.


    //POM:Page Object Model : Kabul gormus bir framework dizayn pattern'idir
    //Temel Class'lar :

    //1- Pages :  Locate'ler ve faydala reusable method'lar
    //2- Driver : static method'larla ulasilacak sekilde organize ettik,
    // tek bir browser'a bagimli olmaktan kurtulduk, getDriver() ve
    // closeDriver() method'lari sayesinde istedigimiz yerde driver acmak
    // veya kapatmak elimizde

    //Driver class'ini farkli objeler olusturulmamasi icin singleton pattern'e
    // uygun olarak duzenledik.

    //configuration.properties : test datalarimizi tutmak icin kullandigimiz
    // dosyadir.
    //Key=value seklinde ikililerden olusur. Key'ler unique olmak zorundadir
    //Config.properties dosyasindaki test datalarini alabilmek icin
    // olusturdugumuz class'tir. Java'daki Properties class'i sayesinde
    // bizim gonderdigimiz key'e ait value'yu configuration.properties'ten
    // bize geri getirir.

}
