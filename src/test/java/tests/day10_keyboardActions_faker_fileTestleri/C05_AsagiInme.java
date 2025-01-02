package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_AsagiInme extends TestBase_Each {


    @Test
    public void test01(){

        //1- https://html.com/tags/iframe/ sayfasina gidelim

        driver.get("https://html.com/tags/iframe/");

        //2- video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //3- videoyu izlemek icin Play tusuna basin
        WebElement iFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrame);

        WebElement video0 = driver.findElement(By.xpath("//*[@aria-label='Play']"));
        actions.click(video0).perform();
        ReusableMethods.bekle(1);

        //4- videoyu calistirdiginizi test edin

        WebElement video = driver.findElement(By.xpath("//*[@data-sessionlink='feature=player-button']"));

        Assertions.assertTrue(video.isDisplayed());




    }
}
