package day01;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println(topla(10));
        System.out.println("   ***   ");
        System.out.println(topla1(10));
        System.out.println("   ***   ");
        System.out.println(topla2(10));
        System.out.println("   ***   ");
        System.out.println(toplaCift(10));
        System.out.println("   ***   ");
        System.out.println(toplaCift1(10));
        System.out.println("   ***   ");
        System.out.println(toplaIlkTek(10));
        System.out.println("   ***   ");
        ikiIlkXkuvvet(10);
        System.out.println("   ***   ");
        istenenSayIlkXKuvvet(10,5);
        System.out.println("   ***   ");
        System.out.println(istenenSayininFaktoriyeliniHesapla(5));
        System.out.println("   ***   ");
        System.out.println(istenenSayininFaktoriyeliniHesapla2(5));
        System.out.println("   ***   ");
        System.out.println(istenenSayininXincikuvvet(10, 5));
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
    //Structured Programming
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }
    //Functional Programming
    public static int topla1(int x) {

        return IntStream.range(1, x + 1).//1 2 3 ... x elemanarinin akısı --> 1 dahil x+1 hariç
                sum();
    }
    public static int topla2(int x) {

        return IntStream.rangeClosed(1, x).//1 2 3 ... x --> 1 ve x dahil
                sum();
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
    public static int toplaCift(int x) {

        return IntStream.rangeClosed(1, x).//1 2 3 ... x elemanarinin akısı
                //filter(Lambda01::ciftBul).//2 4 6 ... elaman akısı
                        filter(t -> t % 2 == 0).//2 4 6 ... elaman akısı
                        sum();
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
    public static int toplaCift1(int x) {

        return IntStream.iterate(2, t -> t + 2).//2 4 6 ... x elemanarinin akısı
                limit(x).
                sum();
    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
    public static int toplaIlkTek(int x) {

        return IntStream.iterate(1, t -> t + 2).//1 3 5 ... x elemanarinin akısı
                limit(x).//akısdaki ilk x elamanı verir
                sum();//akısdaki ilk x elamanı toplar
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void ikiIlkXkuvvet(int x) {

        IntStream.iterate(2, t -> t * 2).//2 4 8 16 32 x elemanarinin akısı
                limit(x).//akısdaki ilk x elamanı verir
                forEach(Lambda01::printEl);
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void istenenSayIlkXKuvvet(int a, int x){
        IntStream.iterate(a,t->t*a).//
                limit(x).
                forEach(Lambda01::printEl);
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
    public static OptionalInt istenenSayininFaktoriyeliniHesapla(int x) {
        return IntStream.rangeClosed(1,x).reduce(Math::multiplyExact);
    }
    public static int istenenSayininFaktoriyeliniHesapla2(int x) {
        return IntStream.rangeClosed(1,x).reduce(1,(t,u)->t*u);
    }
    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi yaziniz
    public static IntStream istenenSayininXincikuvvet(int a, int x) {

        return IntStream.iterate(a, t -> t * a).//a a^2 a^3 a^4... x elemanarinin akısı
                limit(x).//akısdaki ilk x elamanı verir
                // reduce(0,(t,u)->u).
                        skip(x-1);
    }




}
