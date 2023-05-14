package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {




    @Test
    public void test01() throws InterruptedException {


        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElementi= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drapHereElementi=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions action=new Actions(driver);
        action.dragAndDrop(dragMeElementi,drapHereElementi).perform();
        Thread.sleep(4000);


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin//
        WebElement dropyazıelemtı=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expecetdYazı="Dropped!";
        String actualYazı=dropyazıelemtı.getText();
        Assert.assertEquals(expecetdYazı,actualYazı);





















    }

























}
