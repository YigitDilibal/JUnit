package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.security.Key;

public class C02_FormDoldurmaTesti extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim

        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin

        driver.findElement(By.xpath("(//*[.='Account'])[1]")).click();

        //3- Sign Up linkine basalim

        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        driver.findElement(By.id("firstName")).click();

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.sendKeys("Yigit")
                .sendKeys(Keys.TAB)
                .sendKeys("Dilibal")
                .sendKeys(Keys.TAB)
                .sendKeys("archery10@outlook.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345678")
                .sendKeys(Keys.TAB)
                .sendKeys("12345678").perform();

        ReusableMethods.bekle(1);

        driver.findElement(By.id("btn-submit-form")).click();



        //5- Kaydin olusturuldugunu test edin

        String expectedURL = "https://www.testotomasyonu.com/customer-login";
        String actualURL = driver.getCurrentUrl();

        Assertions.assertEquals(expectedURL,actualURL);


    }
}
