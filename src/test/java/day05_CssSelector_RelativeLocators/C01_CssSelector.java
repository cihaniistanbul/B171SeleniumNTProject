package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();
        Thread.sleep(3000);

        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
        if (deleteButton.isDisplayed()){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //Delete tusuna basin
        deleteButton.click();
        Thread.sleep(3000);

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement = driver.findElement(By.cssSelector("h3"));
        if (addRemoveElement.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //sayfayı kapatınız
        driver.close();
        /*
        CssSelector kullanmak için ilk olarak tagname sonrasında köşeli parentez içinde attribüte ve değeri yazılır
        SYNTAX:
                tagname[attribüteName='attribüteDeğeri']

             XPATH İLE CSSSELECTOR arasındaki fark
             1-xpath ile bir webelement için birden fazla sonuç verirse index ile bunu tek'e düşürebiliriz.
             Fakat cssSelector ile index kullanamayız.
             2-xpath ile bir tag'a sahip webelementin text'ini locate elebiliriz. Fakat css ile bunu yapamayız
             3-cssSelector xpath'e göre daha hızlı çalışır
         */
        /*
        ÖDEV:
        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        Add Element butonuna basin 100 kez basınız
        Delete butonuna 90 kez basınız
        Ve 90 kez basıldığını doğrulayınız
         */
    }
}
