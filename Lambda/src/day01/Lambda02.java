package day01;

import java.util.*;


public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, -3, 7, 34, 22, -60, 42, 55));
//        ciftKare(list);
//        elamanlariTopla(list);
//        elamanlariTopla2(list);
//        carpCiftEl1(list);
//        carpCiftEl2(list);
//        enKucuk(list);
        buyuk15KucukTekSayi(list);
        tekKareBygKck(list);
    }

    // List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
    public static void ciftKare(List<Integer> list) {
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce(Math::max) da kullanilir ancak daha spesifik oldugu icin spesifik oldugu icin hizli calisir
        System.out.println("Cift Sayilarin Karesi ==> " + maxEl);
        // reduce() return edilen eleman null ya da int'dan buyuk olur ihtimali icin Java guvenlik olarak
        // handle ederek Optional class'i gerekli/sart kosuyor
    }

    //  List 'teki tum elemanlari toplamini yazdiriniz
    // Lambda Experrision
    public static void elamanlariTopla(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce((x, y) -> x + y);
        System.out.println("Eleman sayilarinin toplam  ==> " + toplam);
        /*
         x degiskeni her zaman ilk degerini atanan degerden alir
         y her zaman degerini list.stream()'den yani akis'dan alir
         x ilk degerden sonraki degerlerini islemden alir
         */
    }

    //  List 'teki tum elemanlari toplamini yazdiriniz
    // Method reference

    public static void elamanlariTopla2(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce(Integer::sum);
        Optional<Integer> toplam1 = list.stream().reduce(Math::addExact);
        System.out.println("Eleman sayilarinin toplam 2 ==> " + toplam1);
        System.out.println(toplam);
        /*
         x degiskeni her zaman ilk degerini atanan degerden alir
         y her zaman degerini list.stream()'den yani akis'dan alir
         x ilk degerden sonraki degerlerini islemden alir
         */
    }

    //List'teki cift elemanlarin  yazdiriniz.
//Method Reference...
    public static void carpCiftEl1(List<Integer> list) {
        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        System.out.println(carp);
    }

    public static void carpCiftEl2(List<Integer> list) {
        Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x * y));
        //pozitif deger uretiniz
        Integer carpPoz = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> (x * y));

        System.out.println(carp);
        System.out.println(carpPoz);
    }

    //list'teki elemanlarin en kucugunu 4 farkli yontem ile yazdiriniz
    public static void enKucuk(List<Integer> list) {
        Optional<Integer> enKucuk1 = list.stream().reduce(Integer::min);
        Optional<Integer> enKucuk2 = list.stream().reduce(Math::min);
        Optional<Integer> enKucuk4 = list.stream().sorted().findFirst();
        Integer enKucuk5 = list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);


        System.out.println(enKucuk1);
        System.out.println(enKucuk2);
        System.out.println(enKucuk4);
        System.out.println(enKucuk5);

    }

    //List'teki 15;ten buyuk en kucuk tek sayiyi yazdiriniz

    public static void buyuk15KucukTekSayi(List<Integer>list) {
        System.out.println(list.stream().filter(t ->t%2==1).filter(t -> t>15).reduce(Integer::min));
    }
    public static void tekKareBygKck(List<Integer> list){
        list.
                stream().
                filter(t->t%2!=0).
                map(t->t*t).
                sorted(Comparator.reverseOrder()).//akısa giren elelmanlar ters siralanir
                forEach(Lambda01::printEl);//144 484 1156 1764 3600

    }

}
