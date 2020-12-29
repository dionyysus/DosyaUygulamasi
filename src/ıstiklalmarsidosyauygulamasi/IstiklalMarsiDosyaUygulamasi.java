package ıstiklalmarsidosyauygulamasi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class IstiklalMarsiDosyaUygulamasi {

    
    public static void main(String[] args) {
        int toplamKarakterSayisi = 0;
        int toplamKelimeSayisi = 0;
        int toplamSatirSayisi = 0;
        HashMap<String,Integer> kelimeTekrarSayisi = new HashMap<>();
        try(BufferedReader okuyucu = new BufferedReader(new FileReader("istiklal.txt"))) {
            String oankiSatir = okuyucu.readLine();
            
            while(oankiSatir!=null)
            {
                toplamSatirSayisi+=1;
                
                String[] satirdakiKelimeDizisi = oankiSatir.toLowerCase().split(" ");
                toplamKelimeSayisi+=satirdakiKelimeDizisi.length;
                oankiSatir = okuyucu.readLine();
                 for (String kelime:satirdakiKelimeDizisi)
                 {
                     if(kelimeTekrarSayisi.containsKey(kelime))
                     {
                        kelimeTekrarSayisi.put(kelime, toplamKelimeSayisi);
                     }
                     else
                     {
                         kelimeTekrarSayisi.put(kelime, 1);
                     }
                     toplamKarakterSayisi+=kelime.length();
                 }
            }
            System.out.println("Toplam Satir Sayisi: "+toplamSatirSayisi);
            System.out.println("Toplam Satir Sayisi: "+toplamKelimeSayisi);
            System.out.println("Toplam Satir Sayisi: "+toplamKarakterSayisi);
            System.out.println(kelimeTekrarSayisi);
            int tekrarSayisi = 0;
            String encokTekrarEdenkelime = null;
            for(Map.Entry<String,Integer> temp: kelimeTekrarSayisi.entrySet())
            {
                if(temp.getValue()>tekrarSayisi)
                {
                    encokTekrarEdenkelime = temp.getKey();
                    tekrarSayisi = temp.getValue();
                }
            }
            System.out.println("En cok tekrar eden kelime: " + encokTekrarEdenkelime + "tekrar sayisi: "+ tekrarSayisi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
}
