package com.umit;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Map<Integer, Integer> sayiFrekanslari = new HashMap<>(); //hangi sayidan kac tane oldugunu tutacagiz.
        Random random = new Random();

        // 10,000 adet sayı üretiyoruz.
        for (int i = 0; i < 10_000; i++) {
            int uretilenSayi = random.nextInt(1,100);

            // Üretilen sayıyı sayıFrekanslari map inde güncelliyoruz.
            if (sayiFrekanslari.containsKey(uretilenSayi)){
                int value=sayiFrekanslari.get(uretilenSayi);
                sayiFrekanslari.replace(uretilenSayi,value+1);
            }else{
                sayiFrekanslari.put(uretilenSayi,1);
            }
        }
        sayiFrekanslari.forEach((x,y)-> System.out.println(x+" sayisindan " +y + " kadar var"));

        List<Integer> sayiListesi = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sayiFrekanslari.entrySet()) {
            int sayi = entry.getKey();
            int frekans = entry.getValue();

            for (int j = 0; j < frekans; j++) {
                sayiListesi.add(sayi);
            }
        }
        Collections.shuffle(sayiListesi); //sayi listesini shuffle ile karistirdik.
        System.out.println("sayi listesi= "+sayiListesi);
        System.out.println(sayiListesi.size()); //10_000 ciktisii gormek icin yaptik

        List<Integer> sansliSayilar = sayiListesi.subList(0, 10);

        System.out.println("Üretilen sayılar ve frekansları:");
        for (Map.Entry<Integer, Integer> entry : sayiFrekanslari.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Sanslı 10 sayı:");
        for (Integer sansliSayi : sansliSayilar) {
            System.out.print(sansliSayi+"  ");
        }
    }
}
