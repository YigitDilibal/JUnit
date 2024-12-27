package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class C05_Assertions {

    //a. Verilen web sayfasına gidin.
    //     https://testotomasyonu.com/form
    // b. Sirt Agrisi ve Carpinti checkbox’larini secin
    // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin


    @Test
    public void hastalikTesti(){

        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://testotomasyonu.com/form");

            driver.findElement(By.id("gridCheck4")).click();
            driver.findElement(By.id("gridCheck5")).click();

        Assertions.assertTrue(driver.findElement(By.id("gridCheck4")).isSelected());
        Assertions.assertTrue(driver.findElement(By.id("gridCheck5")).isSelected());

        Assertions.assertFalse(driver.findElement(By.id("hastalikCheck2")).isSelected());
        Assertions.assertFalse(driver.findElement(By.id("hastalikCheck7")).isSelected());

        driver.quit();


    }



}
