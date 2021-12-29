package day01;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    public static void main(String[] args) {
        TechPro trGunduz = new TechPro("yaz", "TR gunduz", 97, 124);
        TechPro engGunduz = new TechPro("kis", "ENG gunduz", 95, 131);
        TechPro trGece = new TechPro("bahar", "TR gece", 98, 143);
        TechPro engGece = new TechPro("sonbahar", "ENG gece", 93, 151);

        List<TechPro> list = new ArrayList<TechPro>(Arrays.asList(trGunduz, engGunduz, trGece, engGece));
        //bu class'da agirlikli return type calisacagiz

//        System.out.println(batchOrt92Byk(list));
//        System.out.println(hicbiri110danAzDegil(list));
//        System.out.println(baharVarMi(list));
//        System.out.println(ogrSayisinaGoreSirala(list));
//        getBatchBatchOrtaGore(list);
//        System.out.println(ogrcSayEnAz2inciYaz(list));
//        System.out.println(ogrcSayisi95tenbykOgrcSayiTopla(list));
        System.out.println(ogrcSayilari130danBuyukBatchOrt(list));


    }
    //task 01--> batch ort'larinin 92 den buyuk oldg kontrol eden pr create ediniz.
    public static boolean batchOrt92Byk(List<TechPro> list) {
        return list.stream().allMatch(t -> t.getBatchOrt() > 92);
    }
    //task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean hicbiri110danAzDegil(List<TechPro> list) {
        return list.stream().noneMatch(t -> t.getOgrcSayisi()<110);
    }
    //task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean baharVarMi(List<TechPro> list) {
        return list.stream().anyMatch(t -> t.getBatch().equalsIgnoreCase("Bahar"));
    }
    //task 04-->batch'leri ogr sayilarina gore b->k siralayiniz.
    public static List<TechPro> ogrSayisinaGoreSirala(List<TechPro> list) {
        List<TechPro> collect = list.stream().sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).collect(Collectors.toList());
        return collect;
    }
    //task 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.
    public static void getBatchBatchOrtaGore(List<TechPro> list) {
        System.out.println(list.stream().sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).limit(3).collect(Collectors.toList()));
        //digerini getirdim ==>
        System.out.println(list
                .stream()
                .sorted(Comparator.comparing(TechPro::getBatchOrt))
                .limit(1)
                .sorted(Comparator.comparing(TechPro::getBatchOrt).reversed())//bunu yapmaya gerek yok
                .collect(Collectors.toList())
        );
    }
    //task 05--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.
    public static List<TechPro> ogrcSayEnAz2inciYaz(List<TechPro> list) {
        List<TechPro> collect = list.stream().sorted(Comparator.comparing(TechPro::getOgrcSayisi)).limit(2).skip(1).collect(Collectors.toList());
        return collect;
    }
    //task 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz
    public static int ogrcSayisi95tenbykOgrcSayiTopla(List<TechPro> list) {
        System.out.println(list.stream().filter(t -> t.getBatchOrt() > 95).mapToInt(t->t.getOgrcSayisi()).sum());
        System.out.println(list.stream().filter(t -> t.getBatchOrt() > 95).map(TechPro::getOgrcSayisi).reduce(0, (x, y) -> x + y));
        return list.stream().filter(t -> t.getBatchOrt() > 95).map(TechPro::getOgrcSayisi).reduce(0,Integer::sum);
    }
    //task 08--> ogrc sayilari 130 dan buyuk olan batch'lerin batch ort bulunuz
    public static double ogrcSayilari130danBuyukBatchOrt (List<TechPro> list){
        return list.stream().filter(x -> x.getOgrcSayisi() > 130).mapToInt(TechPro::getBatchOrt).average().getAsDouble();
    }

}
