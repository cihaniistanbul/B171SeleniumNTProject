package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String amazonUrl = "https://amazon.com";
        String techproUrl = "https://techproeducation.com";

        //Amazon sayfasina gidelim
        driver.get(amazonUrl);

        //Sayfa başlığını konsola yazdıralım
        String actualTitle = driver.getTitle();//-->getTitle() methodu gidilen sayfanın başlığını verir.
        System.out.println("Amazon Sayfası Başlığı :"+actualTitle);

        //Sayfanın Url'ini konsola yazdırınız
        String actualUrl = driver.getCurrentUrl();//-->getCurrentUrl() methodu gidilen sayfanın url'ini verir
        System.out.println("Amazon Sayfası Url'i :"+actualUrl);

        //Techproeducation sayfasına gidelim
        driver.get(techproUrl);

        //Sayfa başlığını konsola yazdıralım
        String techProactualTitle = driver.getTitle();//-->getTitle() methodu gidilen sayfanın başlığını verir.
        System.out.println("TechPro Sayfası Başlığı :"+techProactualTitle);

        //Sayfanın Url'ini konsola yazdırınız
        String techProactualUrl = driver.getCurrentUrl();//-->getCurrentUrl() methodu gidilen sayfanın url'ini verir
        System.out.println("TechPro Sayfası Url'i :"+techProactualUrl);
    }
}
