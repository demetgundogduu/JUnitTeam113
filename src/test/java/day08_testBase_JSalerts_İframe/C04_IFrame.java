package day08_testBase_JSalerts_İframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {



    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement ıframeyazısıElementı= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(ıframeyazısıElementı.isEnabled());
        System.out.println(ıframeyazısıElementı.getText());
        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementıı= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementıı);

        WebElement textBoxElementı= driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(1000);
        textBoxElementı.clear();
        textBoxElementı.sendKeys("Merhaba Dunya!");
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin//
        /*
        ıframe'e gecıs yapılınca
        driver 'ı oradan çıkıs yaptırana kadar driver iframe 'in içinde kalır

         driver.switchTo().parentFrame() --   Icice birden fazla iframe varsa, bir ust
                                                 iframe’e cikmak icin

         driver.switchTo().defaultContent()  - Direk anasayfaya gecis yapmak icin

         */
        driver.switchTo().defaultContent();
        WebElement elementalSelenıum= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenıum.isDisplayed());
        System.out.println(elementalSelenıum.getText());


    }








































}
