package tests.day08_BasicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C03_iFrame extends TestBase_Each {



    @Test
    public void test01(){

        driver.get("https://demoqa.com/frames");

        WebElement sampleIFrame = driver.findElement(By.xpath("//*[@id='frame1']"));

        driver.switchTo().frame(sampleIFrame);

        WebElement sample = driver.findElement(By.id("sampleHeading"));

        Assertions.assertTrue(sample.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement framesYaziElementi = driver.findElement(By.xpath("//*[.='Frames']"));

        Assertions.assertTrue(framesYaziElementi.isDisplayed());





    }

}
