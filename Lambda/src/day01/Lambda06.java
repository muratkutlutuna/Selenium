package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.
                lines(Paths.get("src\\day01\\haluk.txt")).//file e erisip file satirlari akisa alindi
                forEach(System.out::println);//akistaki elemanlar yazildi
        System.out.println(Files.lines(Path.of("src/day01/haluk.txt")));//referansini verir
        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.
                lines(Paths.get("src\\day01\\haluk.txt")).//file e erisip file satirlari akisa alindi
                map(String::toUpperCase).//akisdaki satirlarin byk harf ile update edildi
                forEach(System.out::println);//akistaki elemanlar yazildi
        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.
                lines(Paths.get("src\\day01\\haluk.txt")).//file e erisip file satirlari akisa alindi
                limit(1).//ilk satir alindi
                map(String::toLowerCase).//harfler kucultuldu
                forEach(System.out::println);//akistaki elemanlar yazildi
        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectigini yazdiriniz -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).//file e erisip file satirlari akisa alindi
                filter(t -> t.contains("basari")).//basari icerme sarti
                count());//akistaki elemanlar -> satirlar sayildi
        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).//file e erisip file satirlari akisa alindi
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).//Arrays classindan stream() ile array
                distinct().
                toList());
        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).//file e erisip file satirlari akisa alindi
                        map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                sorted().//Arrays classindan stream() ile array
                toList());
        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).
                        map(t->t.split(" ")).
                        flatMap(Arrays::stream).//file e erisip file satirlari akisa alindi
                        filter(t -> t.equalsIgnoreCase("basari")).//basari icerme sarti
                        count());//akistaki elemanlar -> satirlar sayildi
        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).
                map(t->t.split("")).
                flatMap(Arrays::stream).//file e erisip file satirlari akisa alindi
                filter(t -> t.equalsIgnoreCase("a")).//basari icerme sarti
                count());//akistaki elemanlar -> satirlar sayildi
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).
                map(t->t.split(" ")).
                flatMap(Arrays::stream).//file e erisip file satirlari akisa alindi
                filter(t -> t.contains("a")).//basari icerme sarti
                toList());//akistaki elemanlar -> satirlar sayildi//.collect(Collectors.toList()
        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).
                map(t->t.replaceAll("\\s++","").split("")).
                flatMap(Arrays::stream).//file e erisip file satirlari akisa alindi
                distinct().
                count());//akistaki elemanlar -> satirlar sayildi
        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\day01\\haluk.txt")).
                map(t->t.trim()
                        .split("\\s++")).
                flatMap(Arrays::stream).//file e erisip file satirlari akisa alindi
                distinct().
                count());//akistaki elemanlar -> satirlar sayildi


    }
}
