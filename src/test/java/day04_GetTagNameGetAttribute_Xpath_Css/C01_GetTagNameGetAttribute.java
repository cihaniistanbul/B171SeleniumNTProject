package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //<input id="searchHeaderInput" type="text" class="form-input" placeholder="Search Program">
        //Arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));

        //arama kutusunun tag name'inin input olduğunu test edelim
        System.out.println("Arama Kutusu WebElementi Tag Name'i : "+aramaKutusu.getTagName());//-->input
        String gercekTagName = aramaKutusu.getTagName();
        String beklenenTagname = "input";
        if (gercekTagName.equals(beklenenTagname)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //arama kutusunun class attribütunun değerinin form-input olduğunu test ediniz
        String gercekAttributeName = aramaKutusu.getAttribute("class");//-->form-input
        System.out.println("Class Attribute Değeri : "+gercekAttributeName);
        String istenenAttributeDegeri = "form-input";
        if (gercekAttributeName.equals(istenenAttributeDegeri)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //sayfayı kapatınız
        driver.close();
    }
}
