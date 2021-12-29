package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("mehmet" ,
                "emre" ,
                "nilgun" ,
                "yildiz" ,
                "kader" ,
                "emine" ,
                "islam" ,
                "suleyman" ,
                "kokorec"));

//        List<Integer> list2 = new ArrayList<>(Arrays.asList(12, 13, 65, -3, 7, 34, 22, -60, 42, 55));
//        bykHrfTkrrszSira(list);
//        System.out.println();
//        tekrarsizKrkSysTersSiraliYaz(list);
//        System.out.println();
//        krkSaysBuyktnKucgeYaz(list);
//        sonHarfineGoreTersSiraliYaz(list);
//        ciftElKarTekBuyKucYaz1(list2);
//        ciftElKarTekBuyKucYaz2(list);
//        elKarkSay7ve7denAzOlma(list);
//        wmi(list);
//        krkEnBuy(list);
        ilkHaricSonHarfeGoreYaz(list);
    }
    //List elemanlarini alfbetik buyuk ve tekrarsiz yazdiriniz
    public static void bykHrfTkrrszSira(List<String> list ) {
        //list.stream().map(String::toUpperCase).map(t->t.concat(" ")).sorted().distinct().forEach(System.out::print);
        list.stream().map(String::toUpperCase).sorted().distinct().forEach(t->System.out.print(t+" "));
        //list.stream().map(t->t.toUpperCase()).sorted().distinct().forEach(System.out::print);
    }

    //list elemanlarinin karakter sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void tekrarsizKrkSysTersSiraliYaz(List<String> list) {
        list.stream().map(t->t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(System.out::print);
    }

    //List elemanlarini karakter sayisina gore buyukten kucuge yazdir
    public static void krkSaysBuyktnKucgeYaz(List<String> list) {
        list.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).forEach(System.out::println);//tersten yapmak icin toString() yazip bir tazeletmek gerekiyor
    }

    //list elelmanlarinin son harfine gore ters sirali yazdiriniz
    public static void sonHarfineGoreTersSiraliYaz(List<String> list) {
        list.stream().sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).reversed()).forEach(System.out::println);
        System.out.println();
        //list.stream().sorted(Comparator.comparing(t->t.substring(t.length()-1)).reversed()).forEach(System.out::println);

    }

//Cift sayili elemanlarin karelerini hesaplayan, tekrarli olanlari sadece bir kere buyukten kucuge dogru
//yazdiran bir program yaziniz.
//    public static void ciftElKarTekBuyKucYaz1(List<Integer> list) {
//        list.stream().filter(t->t%2==0).map(t->Math.pow(2,t)).sorted(Comparator.reverseOrder()).distinct().forEach(System.out::print);
//    }
    public static void ciftElKarTekBuyKucYaz2(List<String> list) {
        list.stream().map(t->t.length()*t.length()).filter(t->t%2==0).distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
    public static void elKarkSay7ve7denAzOlma(List<String> list) {
        boolean b = list.stream().allMatch(t -> t.length() <= 7);
        if (b) {
            System.out.println("List elemanlari 7 harften buyuk degil");
        }else {
            System.out.println("List elemanlari 7 harften buyuk");
        }

    }

    //List elelmanlarinin "W" ile baslamasını kontrol ediniz
    public static void wmi (List<String> list){
        System.out.println(list.stream().noneMatch(t->t.startsWith("w"))?"hicbiri W ile baslamiyor":"birileri W ile basliyor");
        System.out.println(list.stream().allMatch(t->t.startsWith("w"))?"hepsi W ile baslamiyor":"hicbiri W ile baslamiyor");
        System.out.println(list.stream().anyMatch(t->t.startsWith("w"))?"herhangibiri W ile basliyor":"hicbiri W ile baslamiyor");
    }

    //karakter sayisi en buyuk elemani yaziniz
    public static void krkEnBuy(List<String> list){
        System.out.println(list.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst());
        System.out.println(list.stream().reduce("",(x, y)->x.length()>y.length()?x:y));
        System.out.println(list.stream().reduce((x, y)->x.length()>y.length()?x:y));
        System.out.println(list.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).findFirst());
        System.out.println(list.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).limit(1));
        Stream<String> sonIsim = list.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).limit(1);
        System.out.println(Arrays.toString(sonIsim.toArray()));
        //  limit(a) akisdan cikan elemanlari a parametresine gore ilk a elemani alir
    }

    public static void ilkHaricSonHarfeGoreYaz(List<String> list){
        Stream<String> skip = list.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).skip(1);
        System.out.println(skip.toString());//referansi yaziyor
        System.out.println(Arrays.toString(skip.toArray()));
    }



}
