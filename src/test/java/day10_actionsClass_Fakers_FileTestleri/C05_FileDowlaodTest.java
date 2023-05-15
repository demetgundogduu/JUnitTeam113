package day10_actionsClass_Fakers_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDowlaodTest extends TestBase {




    @Test
    public void test01() throws InterruptedException {

        //1.
        //2. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.get("https://the-internet.herokuapp.com/download");
        //3. loto.png dosyasını indirelim
        WebElement fotoElemtı= driver.findElement(By.linkText("img.png"));
        fotoElemtı.click();
        Thread.sleep(3000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu="C:/Users/user/Desktop/img.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // dosya Dowland Klosorune ındırecek

        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
        //C:\Users\emre.cigit\Downloads\foto.png"
        //"C:\Users\Berke\Downloads\foto.png"
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

















    }































}
