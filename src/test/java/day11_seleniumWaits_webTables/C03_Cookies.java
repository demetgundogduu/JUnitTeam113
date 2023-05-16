package day11_seleniumWaits_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){


        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet =driver.manage().getCookies();
        System.out.println(cookiesSet);
        int sıraNo=1;
        for (Cookie  eachCookie:cookiesSet
        ) {
            System.out.println(sıraNo+"-----------"+eachCookie);

            sıraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int expecetdMinCookieSayısı=5;
        int actualMinCookiSayısı=cookiesSet.size();
        Assert.assertTrue(actualMinCookiSayısı>expecetdMinCookieSayısı);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue =driver.manage().getCookieNamed("i18n-prefs").getValue();
        String  expecetdCokieValue="USD";
        Assert.assertEquals(expecetdCokieValue,actualCookieValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie

        Cookie eklenecekCookie= new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(eklenecekCookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        sıraNo=1;
        cookiesSet = driver.manage().getCookies();

        String enSevdigimCookieValue = "";
        for (Cookie eachCookie : cookiesSet
        ) {
            System.out.println(sıraNo+"------" + eachCookie);
            if (eachCookie.getName().equals("en sevdigim cookie")){
                enSevdigimCookieValue = eachCookie.getValue();
            }
            sıraNo++;
        }


        //7 - ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        sıraNo=1;
        cookiesSet = driver.manage().getCookies();
        String flag = "skin isminde bir cookie yok";
        for (Cookie eachCookie : cookiesSet
        ) {
            System.out.println(sıraNo+"------" + eachCookie);
            if (eachCookie.getName().equals("skin")){
                flag="skin isminde cookie bulundu";
            }
            sıraNo++;
        }

        Assert.assertTrue(flag.equals("skin isminde bir cookie yok"));


        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();
        Assert.assertEquals(cookiesSet.size(), 0);

















    }




















}
