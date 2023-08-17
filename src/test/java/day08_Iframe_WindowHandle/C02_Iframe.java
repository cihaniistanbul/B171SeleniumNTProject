package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void iframe() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String kalinYazi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(kalinYazi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        //driver.navigate().refresh();//-->sayfayı yeniler Ana sayfaya döner fakat frame içinde yapılan değişikliklerde ilk haline döner
        //driver.get(driver.getCurrentUrl());
        WebElement elementalSelenium = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertEquals("Elemental Selenium",elementalSelenium.getText());

    }
}
