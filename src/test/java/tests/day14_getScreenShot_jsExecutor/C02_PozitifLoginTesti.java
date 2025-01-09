package tests.day14_getScreenShot_jsExecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_PozitifLoginTesti extends TestBase_Each {

    @Test
    public void pozitifLoginTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        // account linkine tiklayin
        driver.findElement(By.xpath("(//*[.='Account'])[1]")).click();

        // kullanici adi olarak wise@gmail.com

        driver.findElement(By.id("email")).click();
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.sendKeys("wise@gmail.com").sendKeys(Keys.TAB).perform();

        // password olarak 12345 girin

        actions.sendKeys("12345").perform();

        // submit butonuna basin

        driver.findElement(By.id("submitlogin")).click();

        // giris yapilabildigini test edin

        WebElement logOut = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logOut.isDisplayed());

        // tum sayfa screenshot alin

        ReusableMethods.bekle(1);

        ReusableMethods.isimliTumSayfaScreenshot(driver, "day14_C02");

        logOut.click();



    }


}
