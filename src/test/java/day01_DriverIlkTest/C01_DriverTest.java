package day01_DriverIlkTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_DriverTest {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://techproeducation.com");
        /*
            POM.xml dosyasına driver sürücüleri için yüklediğimiz webDriverManager dependency sayesinde
        yukarıdaki örnekteki bilgisayarımızda mevcut olan başka bir browser ile driver'imizi oluşturabiliriz
        Yine bu projede ki gibi pom.xml dosyasına yüklediğimiz selenium-java dependency sayesinde get() methodu
        ile string olarak belirtmiş olduğumuz istediğimiz bir url'e gidebiliriz.
         */
    }
}
