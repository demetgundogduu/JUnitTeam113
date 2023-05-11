package day06_JunitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {

      /*
        Bu class icerisinde 3 test calistiralim
        1- google anasayfaya gidip, url'in google icerdigini test edin
        2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
     */
    /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test method'larinin bagimsiz olarak calistirilabilmesini saglayan
        @Test notasyonudur.
        Junit ile class level'dan birden fazla test method'u calistirirsak
        hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz
     */



    WebDriver driver;




    @Test
    public void googleTest(){
        //1- google anasayfaya gidip, url'in google icerdigini test edin
        mahserın4Atlısı();
        driver.get("https://www.google.com");
        String expectedIcerık="google";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerık)){
            System.out.println("GOOGLE testi PASSED");
        }else {
            System.out.println("Url google ıcermıyor,testı FAILED");
        }
        driver.close();

    }


    @Test
    public void  wiseTest(){
        //  2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        mahserın4Atlısı();
        driver.get("https://www.wisequarter.com");
        String expectedWiseIcerık="wisequarter";
        String actualWise=driver.getCurrentUrl();
        if (actualWise.contains(expectedWiseIcerık)){
            System.out.println("WİSE testi PASSED");
        }else {
            System.out.println("Url  içermiyor , testi FAİLED");
        }
        driver.close();

    }


    @Test
    public void amazon(){
        // 3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserın4Atlısı();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));

        if (amazonLogoElementi.isDisplayed()){
            System.out.println("Amozon testi PASSED");
        }else {
            System.out.println("amazon logosu gorunmuyor, Amazon FAILED");
        }

        driver.close();


    }

    public void mahserın4Atlısı(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

































}
