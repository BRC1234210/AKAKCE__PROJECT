package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /** Bu bölüm ilk kullandigimiz sitede cikan cookies icindi, ortak her siteye uymadigi
          icin yoruma aldik */
        try {
            WebElement element =
                    driver.findElement(By.xpath("//div[@class='fc-footer-buttons']/button[1]"));

            element.click();
            throw new NoSuchElementException("Element sayfada yok");

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Bilinmiyen bir hata olustu");
        }

            return driver;
    }

    public static void threadWait(int second) {
        try {
            Thread.sleep(second*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
