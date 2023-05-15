package day10_actionsClass_Fakers_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUpLoadTesti extends TestBase {





    @Test
    public void test01() throws InterruptedException {


         /*
            driver ile gittigimiz bir websayfasinda
            bilgisayarimizdaki bir dosyayi upload etmek istersek
            bilgisayarimizdaki klasorlere erismemiz gerekir
            Selenium webdriver bilgisayardaki dosyalara erisemez
            bunun yerine 3 adimla su islemleri yapariz
            1- choose file  butonunu locate edelim
            2- bilgisayarimizdan yuklemek istedigimiz dosyanin dosya yolunu olusturalim
               (Mumkunse dinamik dosya yolu olsun)
            3- chooseButonu.sendkeys(dosyaYolu) ile dosya yolunu sisteme tanitalim
         */



        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        String herkesteFarklıOlan=System.getProperty("user.dir");
        String herkesteAynıOlan="/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        String dosyaYolu=herkesteFarklıOlan+herkesteAynıOlan;
        chooseFileButonu.sendKeys(dosyaYolu);
        // chooseFile butonunu kullanarak

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();



        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUplodedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUplodedElementi.isDisplayed());
        Thread.sleep(10000);














    }



















































}
