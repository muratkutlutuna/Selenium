package tests.day22;

public class C00 {
    //-XML:HTML gibi data transfer formatidir.

    //-TestNG ile XML dosya kullanmamizin sebebi : toplu dosya calistirmak istedigimizde,
    //       hangi dosyalarin calismasini veya calismamasini istedigimizi TestNG'ye
    //       XML dosyalar ile iletebiliriz

    //-XML dosyalar sayesinde istedigimiz level'daki testlerimizi toplu olarak
    //      calistirabiliriz, bunun icin suite'den baslayara, testlerimizi sectigimiz
    //      level'a kadar sirasiyla (hiyerarsik olarak) tag'lari olusturmaliyiz

    //-Eger birden fazla hiyerarsiye ihtoiyac varsa ayrilma level'ini iyi tespit edip,
    //      o noktadan itibaren birden fazla hiyerarsi olusturabiliriz

    //-Eger bir test olustururken farkli package veya class'lardan test methodlari calistiracaksak
    //      hiyerarsik olarak her bir methdo'a ulasmak zahmetli olacaktir

    //      bu durumda groups devreye girer, istedigimiz test method'una istedigimiz kadar groups atayabiliriz.
    //      ve bu groups'lari istedigimiz zaman calistirabiliriz.

    //      group secimi yapilirken herzaman iki hiyerarsi olusturulur. Birincisi
    //      calisacak ve calismayacak groups'lari belirlerken, ikincisi bu groups'larin
    //      nerede aranacagini belirler

    //      groups olarak XML'den calistirdigimizda include ve exclude sayesinde
    //      group'lari istedigimiz sekilde organize edebiliriz

    //







}
