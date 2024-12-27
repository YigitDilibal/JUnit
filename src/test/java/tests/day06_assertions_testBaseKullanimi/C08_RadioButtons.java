package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C08_RadioButtons extends TestBase_All {

    //a. Verilen web sayfasına gidin.
    //      https://testotomasyonu.com/form
    // b. Cinsiyet Radio button elementlerini locate edin
    // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    @Test
    public void radioButtonTesti(){

        driver.get("https://testotomasyonu.com/form");
        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        erkekButton.click();

        Assertions.assertTrue(erkekButton.isSelected());
        Assertions.assertFalse(kadinButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());

    }

    @Test
    public void yazidanRadioButtonTesti(){

        driver.get("https://testotomasyonu.com/form");
        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        WebElement erkekYazi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));

        erkekYazi.click();

        Assertions.assertTrue(erkekButton.isSelected());
        Assertions.assertFalse(kadinButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());




    }

}
