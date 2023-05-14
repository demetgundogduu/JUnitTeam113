package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {




    @Test
    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        //menunun ustune gelmesı ıcın bızım uc adımı olusturmamız gerekıyor
        //1. adım actıon objesı olusturmak
        Actions actions=new Actions(driver);
        // 2.menuyu locate edecegız
        WebElement accountvelıstMenuElementı= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        //3. adım actıon objesını kullanrak ıstedıgım metodu secıp perform tıklayacagım
        actions.moveToElement(accountvelıstMenuElementı).perform();
        //  /3- “Create a list” butonuna basin
        WebElement createLıstElementı= driver.findElement(By.xpath("//*[text()='Create a List']"));
        createLıstElementı.click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin//
        WebElement yourListElementı= driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedYazı="Your Lists";
        String actualYazı=yourListElementı.getText();
        Assert.assertEquals(expectedYazı,actualYazı);









    }






































}
