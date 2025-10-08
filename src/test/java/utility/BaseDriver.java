package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BaseDriver {

    public static WebDriver driver(String url) {
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        try{
            WebElement shadowHost = driver.findElement(By.cssSelector("efilli-layout-dynamic"));
            SearchContext shadowRoot = shadowHost.getShadowRoot();
            WebElement kabulEt = shadowRoot.findElement(By.cssSelector("div[data-name='kabul et']"));
            kabulEt.click();
            throw new java.util.NoSuchElementException("Cookies Elementi Sayfada Yok!");
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Bilinmeyen bir hata olustu");
        }

        return driver;
    }
    public static void threadWait(int second){
        try{
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}