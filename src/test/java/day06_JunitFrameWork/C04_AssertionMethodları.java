package day06_JunitFrameWork;

import org.junit.Assert;

public class C04_AssertionMethodları {



    public void test01(){

        int sayı1=20;
        int sayı2=10;
        int sayı3=30;


        /*
        Eger testın sonucunu turkce olarak olumlu bır cumle ile sorduysa assertTRUE
        olumsuz cumle kullanılmıssa
        asserfalse kullanılır

         */


        // sayı1 ın sayı2 den buyuk  oldugunu test edin
        Assert.assertTrue(sayı1>sayı2);   //     sayı1>sayı2  //PASSED




        // sayı 1 ın sayı3 ten buyuk olmadıgını test edin
        Assert.assertFalse(sayı1>sayı3);

        // sayı1 ın sayı3 ten kucuk oldugunu test edın

        Assert.assertTrue(sayı1<sayı3);










    }
































}
