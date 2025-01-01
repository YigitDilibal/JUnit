package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C08_Odev extends TestBase_Each {

    @Test
    public void banaOdev(){

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin

        WebElement hoverFirst = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.moveToElement(hoverFirst).perform();

        ReusableMethods.bekle(1);

        //3- Link 1" e tiklayin

        driver.findElement(By.xpath("(//a[.='Link 1'])[1]")).click();
        ReusableMethods.bekle(1);

        //4- Popup mesajini yazdirin

        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin

        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);

        //6- “Click and hold" kutusuna basili tutun

        WebElement clickBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickBox).perform();
        ReusableMethods.bekle(1);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(clickBox.getText());

        //8- “Double click me" butonunu cift tiklayin

        WebElement doubleClick = driver.findElement(By.className("div-double-click"));

        actions.doubleClick(doubleClick).perform();

        ReusableMethods.bekle(1);

    }
}
