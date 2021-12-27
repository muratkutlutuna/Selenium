package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
    /*
     * 1) Lambda "Functional Programming" "Functional Programming" de
     * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
     * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
     * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
     * code yazma acilarindan cok faydalidir. 4) Lambda sadece
     * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
     * map'lerde kullanılmaz. Lambda kullanmak hatasız code kullanmaktır.
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));
        printElStructured(list);// method call
        System.out.println();
        System.out.println("   ***   ");
        printElfunctional(list);// lambda expression
        System.out.println();
        System.out.println("   ***   ");
        printElfunctional1(list);// method reference
        System.out.println();
        System.out.println("   ***   ");
        printCiftElStructered(list);
        System.out.println();
        System.out.println("   ***   ");
        printCiftElFunctional(list);
        System.out.println();
        System.out.println("   ***   ");
        ciftKarePrint(list);
        System.out.println();
        System.out.println("   ***   ");
        tekKup1Fazla(list);
        System.out.println();
        System.out.println("   ***   ");
        ciftKarekok(list);
        System.out.println();
        System.out.println("   ***   ");
        enBuyukSayi(list);
    }

    //structured Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
    public static void printElStructured(List<Integer> list) { // 12 13 65 3 7 34 22 60 42 55
        for (Integer w : list) {
            System.out.print(w + " ");
        }
    }


    // Functional Programming ile list elemanlerinin tamamini aralarina bosluk
    // birakarak yazdiriniz
    public static void printElfunctional(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));// Lambda Expression :Lambda ifadesi
        // stream() : datalari yukaridan asagiya akis sekline getirir.
        // forEach() :datanin parametresine gore her bir elemanı isler
        // t-> : Lambda operatoru
        // Lambda Expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE
        // kullanilir
    }
    //Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile
    // ClassName::MethodName--> ez- ber- leeeeee

    public static void printEl(int t) {// refere eddilecek method create edildi
        System.out.print(t + " ");
    }

    public static void printElfunctional1(List<Integer> list) {
        list.stream().forEach(Lambda01::printEl);
    }

    //structered programing ile list elemanlarinin cift elemanlarini ayni satirda aralarinda bosluk birakarak yaziniz

    public static void printCiftElStructered(List<Integer> list) {
        for (Integer w : list) {
            if (w%2==0) {
                System.out.print(w+" ");
            }
        }
    }

    public static void printCiftElFunctional(List<Integer> list) {
        list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
        //filter() --> akisicerisindeki elemanlari istenen sarta gore filtreleme yapar
    }

    public static boolean ciftBul(int i) {//refere edilecek tohum method yaptik
        return i%2==0;
    }
    public static boolean altmisSiniri(int i) {
        return i<60;
    }
    //	public static void printCiftElFunctional2(List<Integer> list) {
//		list.stream().filter(t->t%2==0&&Lambda01::altmisSiniri).forEach(Lambda01::printEl);
//		//filter() --> akisicerisindeki elemanlari istenen sarta gore filtreleme yapar
//	}
//	public static void printCiftElFunctional3(List<Integer> list) {
//		list.stream().filter(Lambda01::ciftBul&&Lambda01::altmisSiniri).forEach(Lambda01::printEl);
//	}
    public static void printCiftElFunctional4(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);
    }
    public static void printCiftElFunctional5(List<Integer> list) {
        list.stream().filter(t->t%2==0&&t<60).forEach(Lambda01::printEl);
    }
    public static void printCiftElFunctional6(List<Integer> list) {
        list.stream().filter(t->t%2==1|t>20).forEach(Lambda01::printEl);
    }
    public static void ciftKarePrint(List<Integer> list) {
        list.stream().filter(t->t%2==0).map(t->t*t).forEach(Lambda01::printEl);
    }
    public static void ciftKarePrint1(List<Integer> list) {
        list.stream().filter(t->t%2==0).map(t->t*t).forEach(Lambda01::printEl);
    }
    public static void tekKup1Fazla(List<Integer> list) {
        list.stream().filter(t->t%2==1).map(t->t*t*t+1).forEach(Lambda01::printEl);
    }
    public static void ciftKarekok(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t->System.out.println(t+" "));
    }
    public static void enBuyukSayi(List<Integer> list) {
        Optional<Integer> maxEl=list.stream().reduce(Math::max);
        System.out.println(maxEl);
    }







}
