package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_Each;

import java.util.List;

public class C02_DropdownMenu extends TestBase_Each {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.id("dropdown"));
        Select selectDdm = new Select(ddm);
        selectDdm.selectByIndex(1);
        System.out.println(selectDdm.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        selectDdm.selectByValue("2");
        System.out.println(selectDdm.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        selectDdm.selectByVisibleText("Option 1");
        System.out.println(selectDdm.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        System.out.println(ddm.getText());

        //5. Dropdown’un boyutunun 4 olduğunu test edin
        List<WebElement> ddmOptionList = selectDdm.getOptions();
        Assertions.assertEquals(4,ddmOptionList.size());

    }

}
