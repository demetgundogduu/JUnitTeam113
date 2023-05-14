package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionsClass extends TestBase {



    @Test
    public void test01() throws InterruptedException {



        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //3- Cizili alan uzerinde sag click yapin
        WebElement altıCızılıKutu= driver.findElement(By.id("hot-spot"));
        Actions actions =new Actions(driver);
        actions.contextClick(altıCızılıKutu).perform();


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlerYazısı="You selected a context menu";
        String actualAlertYazısı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlerYazısı,actualAlertYazısı);



        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();


        //6- Elemental Selenium linkine tiklayalim
        //linki tıkladıgımızda yenı window  acıldıgından
        //tıklamadan once ılk wındow un WHDalmamız gerekıyor
        String IlkwindowhandleDegerı=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        // ikinci sayfa biz newWindow() demeden acildigindan
        // ikinciWindow'un WHD'ini Java kullanarak bulmaliyiz

        String ıkıncıWHD="";
        Set<String> windowhandleDegerlerı=driver.getWindowHandles();
        for (String  eachWHD:windowhandleDegerlerı
        ) {
            if (!IlkwindowhandleDegerı.equals(ıkıncıWHD)){
                ıkıncıWHD=eachWHD;
            }

        }
        driver.switchTo().window(ıkıncıWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim//

        String expectedYazi="Elemental Selenium";
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String actualYazi= yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(5000);































    }





































}
