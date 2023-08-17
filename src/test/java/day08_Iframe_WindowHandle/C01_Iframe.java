package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String text = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(text.contains("black border"));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//-->Index ile 1. frame'e geçiş yaptık
        WebElement aplicationListsWE = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals("Applications lists",aplicationListsWE.getText());

        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().defaultContent();//-->Ana sayfaya geçiş yaptık
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("iframe",iframeYazisi.getText());
    }
    /*
        Bir HTML dökümanının içine yerleştirilmiş başka bir HTML dökümanına inline Frame(iframe) denir.
    Sayfadaki bir webelementi locate ettiğimizde nosuchelementexception alıyorsak önce locate'i kontrol ederiz,
    ve yine aynı hatayı alıyorsak locate etmek istediğimiz webelement iframe içinde olabilir. Dolayısıyla
    iframe içindeki bir webelementi locate etmek için driver'imizi iframe geçirmemiz gerekir.
        Alert'ten de bildiğimiz aynı geçiş komutu olan switchTo() methodunu kullanarak frame() methodu ile
    iframe'e geçiş yaparız. frame() methodu bizden parametre olarak hangi frame geçileceğini ister.
        driver.switchTo.frame(1.sayfadaki iframe'in Index'i(index 0'dan başlar))
        driver.switchTo.frame(2.<iframe> tag'ındaki id/name attribute değeri)
        driver.switchTo.frame(3.iframe'in locate'i)
        Bu 3 yöntem ile Iframe'e geçiş yapabiliriz.
        Tekrar ana sayfaya geçmek istersek defaultContent() methodu ile iframe'den çıkıp anasayfaya geçeriz.
    Eğer içi içe iframe'lere geçiş yaptıysak ve bir üst frame tekrar driver'i taşımak istersek
    parentFrame() methodu ile bir üst frame'e geçiş yapabiliriz.


     */
}
