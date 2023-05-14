package day09_switchingWindow_actionsClass;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {





    /*

    Eger driver.switchTo().newWindow() kullanılırsa
    driver otomatık olarak acılan yenı sayfaya gecer

    eger gorevımızde yenı wındowa gıttıkten sonra eskı wındowlar arası gecıs
    ıslemı varsa
     uzerınde calıstıgımız wındowsların wındowahndle degerlerını alıp
      kayıt etmekte fayda var

     */




        @Test
        public void test01() throws InterruptedException {

            //amazon ana sayfaya gidelim
            //gereklı ayarlamaları yapıp
            //  amazon sayfasına gidin
            driver.get("https://www.amazon.com");
            String ilksayfaWindowhandleDegerı=driver.getWindowHandle();
            //title ın amazon kelımesi içerdiğini test edin
            String expecetdTitle="Amazon";
            String actualTitle=driver.getTitle();
            Assert.assertTrue(actualTitle.contains(expecetdTitle));
            // yenı bır tab acarak wisequarter ana sayfaya gıdın

            driver.switchTo().newWindow(WindowType.TAB);
            Thread.sleep(1000);


            // ve URLın wise quarter ıcerdıgınedın
            driver.get("https://www.wisequarter.com");
            String ıkıncıWindowhandleDegerı=driver.getWindowHandle();

            String expectedicerıl="wisequarter";
            String actualıcerık=driver.getCurrentUrl();
            Assert.assertTrue(actualıcerık.contains(expectedicerıl));

            //tekrar amazon'un acık oldugu sayfaya gecın
            // ve URL ın amazon ıcerdıgını test edın


            driver.switchTo().window(ilksayfaWindowhandleDegerı);

            expectedicerıl="amazon";
            actualıcerık=driver.getCurrentUrl();
            Assert.assertTrue(actualıcerık.contains(expectedicerıl));






        }




































    }
