package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsTest extends TestBase {
    @Test
    public void actions() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        iframe çıktığı için driver'i iframe'e geçirmem gerekir
         */
        frameIndex(0);//-->TestBase'de method ile iframe'e geçiş yaptık
        bekle(2);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();//-->Drag webelementini alıp Drop webelementinin üzerine bırakır

    }

    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        frameIndex(0);//-->TestBase'de method ile iframe'e geçiş yaptık
        bekle(2);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Drag webelementini tut ve bekle
                moveToElement(drop).//-->Drag webelementini tutup drop webelementinin üzerine götürür
                release().//-->Basılı tuttuğumuz webelementi serbest bırakır
                perform();//-->Action'ı işleme aldık
    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        frameIndex(0);//-->TestBase'de method ile iframe'e geçiş yaptık
        bekle(2);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        //WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(105,25).release().perform();

        //ÖDEV : Drag webelementinin drop webelementinin üzerine bırakıldığını test edin

    }
}
