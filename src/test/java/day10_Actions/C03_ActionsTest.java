package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {
    @Test
    public void actions1() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);

        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        /*
            Sayfanın ortalarındaki bir webelementi locate etmek istediğimizde driver sayfayı açtığı zaman
         webelementi göremediği için bazen sayfayı az bir aşağıya doğru scroll yapmamız gerekebilir. Bunun
         için yukarıdaki örnekteki gibi Page_Down ile bunu gerçekleştirebiliriz.
            Sayfadaki bir webelementi locate ettiğimiz halde nosuchelementexception alıyorsak;
                1-Locate'i tekrar kontrol ederiz buna rağmen aynı hatayı alıyorsak;
                2-Webelementin iframe içinde olup olmadığına bakarız. Yine aynı hatayı alıyorsak;
                3-Driver webelementi göremiyordur, dolayısıyla actions class'ı kullanarak scroll yapıp
                elementin görünür olmasını sağlarız.
         */
    }

    @Test
    public void actions2() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();//-->Sayfanın en altına scroll yapar
        bekle(2);

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();//-->Sayfanın en üstüne scroll yapar


    }

    @Test
    public void actions3() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Events yazısına kadar scroll yapalım
        WebElement eventsYazisi = driver.findElement(By.xpath("(//h2)[1]"));
        new Actions(driver).scrollToElement(eventsYazisi).build().perform();//-->Locate'ini aldığımız webelemente kadar scroll yapar
        bekle(2);
    }
}
