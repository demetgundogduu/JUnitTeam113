package day10_actionsClass_Fakers_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_DosyaYolunuDinamikYapma {




    @Test
    public void test01(){

        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
        //C:\Users\emre.cigit\Downloads\foto.png"
        //"C:\Users\Berke\Downloads\foto.png"
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\ user\Desktop\com.t113JUnit
        System.out.println(System.getProperty("user.home"));
        //C:\Users\ user





         /* biz Downloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz
            /Users/ahmetbulutluoz               /Downloads/foto.png
            herkesin bilgisayarinda farkli      herkeste ayni
            System.getProperty("user.home")     /Downloads/foto.png
         */


        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim = "/Downloads/foto.png";



        String dosyaYolu=dosyaYoluDegisenKisim+dosyaYoluherkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));





    }






































}
