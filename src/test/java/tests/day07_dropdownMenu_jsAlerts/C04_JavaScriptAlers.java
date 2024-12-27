package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C04_JavaScriptAlers extends TestBase_Each {

    //3 test method'u olusturup asagidaki gorevi tamamlayin


    @Test
    public void alertTesti(){

        //1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        // - Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // - OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();

    }

    @Test
    public void alertConfirmTesti(){
        //2.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        // - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void alertPromptTesti(){
        //3.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        // - Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        // - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim

        String expectedSonucYazisi = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.id("result")).getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));
    }

}
