package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C04_UrlIleWindowGecis extends TestBase_Each {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.

        WebElement addRemove = driver.findElement(By.tagName("h2"));
        String expected = "Add/Remove Elements";

        Assertions.assertEquals(addRemove.getText(),expected);

        //● Sayfa başlığının(title) “Test Otomasyonu” icerdigini doğrulayın.

        String actualTitle = driver.getTitle();
        String expectedTitle = "Test Otomasyonu";

        Assertions.assertTrue(actualTitle.contains(expectedTitle));

        //● ’Please click for Electronics Products’ linkine tiklayin.

        driver.findElement(By.xpath("//*[.='Electronics Products']")).click();

        //● Electronics sayfasinin acildigini test edin

        ReusableMethods.titleIleWindowGecisi(driver,"Test Otomasyonu - Electronics");

        Assertions.assertEquals(driver.getTitle(),"Test Otomasyonu - Electronics");

        //● Bulunan urun sayisinin 16 olduğunu test edin

        List<WebElement> yenisayfadaUrunler = driver.findElements(By.className("prod-img"));

        Assertions.assertEquals(16, yenisayfadaUrunler.size());

        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun

        ReusableMethods.titleIleWindowGecisi(driver,"Test Otomasyonu");

        //● Url’in addremove icerdigini test edin

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "addremove";

        Assertions.assertTrue(actualTitle.contains(expectedTitle));

    }
}
