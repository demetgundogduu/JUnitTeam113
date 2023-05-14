package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {




    @Test
    public void test01(){


        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openıngYazısı= driver.findElement(By.tagName("h3"));
        String expectedIcerık="Opening a new window";
        String actualIcerık=openıngYazısı.getText();
        Assert.assertEquals(expectedIcerık,actualIcerık);
        String ılkSayafanınWHD=  driver.getWindowHandle();





        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


        //● Click Here butonuna basın.
        WebElement clickButonu= driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        clickButonu.click();



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        Set<String> whDegeriSet=driver.getWindowHandles();
        String ıkıncıSayfaWHD="";
        for (String eachWHD:whDegeriSet
        ) {
            if (!eachWHD.equals(ılkSayafanınWHD)){
                ıkıncıSayfaWHD=eachWHD;

            }

        }

        driver.switchTo().window(ıkıncıSayfaWHD);


        String expectedNewTitle="New Window";
        String actualNewTitle=driver.getTitle();
        Assert.assertEquals(expectedNewTitle,actualNewTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement newWindowyaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi = "New Window";
        String actualYazi = newWindowyaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın


        driver.switchTo().window(ılkSayafanınWHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);




















    }











































}
