package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın Konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanın ölçüleri : "+ driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        driver.manage().window().maximize();

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Sayfanın Konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanın ölçüleri : "+ driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Sayfanın Konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanın ölçüleri : "+ driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi kapatin
        driver.close();
    }
}
