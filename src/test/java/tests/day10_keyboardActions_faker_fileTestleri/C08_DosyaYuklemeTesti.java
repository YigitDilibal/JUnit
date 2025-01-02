package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C08_DosyaYuklemeTesti extends TestBase_Each {

    /*
        Bir websayfasina gidip
        o sayfaya upload etmek icin dosyaSec butonuna bastigimizda
        otomatik olarak bilgisayarimizdaki klasor yapisi aciliyor.

        Ancak selenium bilgisayarimizdaki dosyalara erisemez.
        secim icin selenium ozel bir yontem gelistirmis
        dosya secmek icin dosyaSec butonunu locate edip
        sendkeys ile dosya yolunu gondermemiz gerekir.
     */


    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        ReusableMethods.bekle(1);
        //2.chooseFile butonuna basalim
        //day10 package'i altindaki deneme dosyasini secelim.

        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.dir")+"/"+"src\\test\\java\\tests\\day10_keyboardActions_faker_fileTestleri\\deneme.txt";

        ReusableMethods.bekle(1);

        dosyaSec.sendKeys(dinamikDosyaYolu);

        ReusableMethods.bekle(1);

        //4.Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploaded = driver.findElement(By.xpath("//*[.='File Uploaded!']"));

        Assertions.assertTrue(fileUploaded.isDisplayed());

        ReusableMethods.bekle(1);


    }
}
