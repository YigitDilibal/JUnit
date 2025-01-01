package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C02_KontrolsuzAcilanWindowGecisleri extends TestBase_Each {









    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement openingNewWindow = driver.findElement(By.xpath("//*[.='Opening a new window']"));

        String expectedYazi = "Opening a new window";
        String actualYazi = openingNewWindow.getText();
        Assertions.assertEquals(actualYazi,expectedYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        Assertions.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        String eskiWhd = driver.getWindowHandle();

        Set<String> whdler = driver.getWindowHandles();

        String yeniSekme="";

        for (String each:whdler){

            if (!each.equals(driver.getWindowHandle())){
                yeniSekme=each;
            }
        }

        driver.switchTo().window(yeniSekme);

        String newActualTitle = driver.getTitle();
        String newExpectedTitle = "New Window";

        Assertions.assertEquals(newActualTitle,newExpectedTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement actualNewWindow = driver.findElement(By.className("example"));
        String expectedNewWindow = "New Window";

        Assertions.assertEquals(actualNewWindow.getText(),expectedNewWindow);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin


        driver.switchTo().window(eskiWhd);


        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";

        Assertions.assertEquals(actualTitle2,expectedTitle2);


    }


}
