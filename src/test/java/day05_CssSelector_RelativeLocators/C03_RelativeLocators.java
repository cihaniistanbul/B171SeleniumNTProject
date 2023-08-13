package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_RelativeLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //Berlin’i 3 farkli relative locator ile locate edin
        WebElement NYCWebElement = driver.findElement(By.xpath("//*[@id='pid3_thumb']"));
        WebElement bayAreaWebElement = driver.findElement(By.xpath("//*[@id='pid8_thumb']"));
        WebElement berlinWebElement = driver.findElement(with(By.tagName("img")).below(NYCWebElement).toLeftOf(bayAreaWebElement));
        berlinWebElement.click();


        //Relative locator’larin dogru calistigini test edin
        String actualIdDegeri = berlinWebElement.getAttribute("id");
        String expectedIdDegeri = "pid7_thumb";
        if (actualIdDegeri.equals(expectedIdDegeri)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //sayfayı kapatınız
        driver.close();
        /*
        RELATIVE LOCATOR
            -Bir web sayfasında benzer tag'lara sahip webelementlerin olduğu durumlarda kullanılabilir.
        Örneğin bir webelementini locate ettiniz ve o elementin altındaki bir webelemente ulaşmak için önündeki
        başka bir webelementi kapatmanız gerekiyor(reklam gibi) bu gibi durumlarda relative locator ile o elementin
        locate'ini almadan yukarıdaki örnekteki gibi handle edebilirisiniz
            Relative Locator ile kullanılan methodlar;
            above() --> Belirtilen elementin üstünde olan elementi seçer
            below() --> Belirtilen elementin altında olan elementi seçer
            to_left_of() --> Belirtilen elementin solunda olan elementi seçer
            to_right_of() --> Belirtilen elementin sağında olan elementi seçer
            near() --> Belirtilen elementin yanında/yakınında olan elementi seçer

         */


    }
}
