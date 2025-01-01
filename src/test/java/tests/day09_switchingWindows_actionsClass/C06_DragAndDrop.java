package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/droppable adresine gidelim

        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement acceptable = driver.findElement(By.id("draggable2"));
        WebElement dropHere = driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(acceptable,dropHere).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String actualDroppableYazisi = dropHere.getText();
        String expectedDroppableYazisi = "Dropped!";

        Assertions.assertEquals(actualDroppableYazisi,expectedDroppableYazisi);

        //4- Sayfayi yenileyin

        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement nonAcceptable = driver.findElement(By.id("draggable-nonvalid2"));
        dropHere = driver.findElement(By.id("droppable2"));

        ReusableMethods.bekle(1);

        actions.dragAndDrop(nonAcceptable ,dropHere).perform();
        ReusableMethods.bekle(1);


        //6- “Drop Here” yazisinin degismedigini test edin

        dropHere = driver.findElement(By.id("droppable2"));

        actualDroppableYazisi = dropHere.getText();
        expectedDroppableYazisi = "Drop Here";

        Assertions.assertEquals(actualDroppableYazisi,expectedDroppableYazisi);


    }

}
