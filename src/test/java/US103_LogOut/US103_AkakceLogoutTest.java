package US103_LogOut;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
public class US103_AkakceLogoutTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BaseDriver.driver("https://www.akakce.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String email = "golicok298@aiwanlab.com";
        String password = "Abcd1234";

        WebElement GIRIS_YAP_BUTTON = driver.findElement(By.xpath("//div[@id='H_rl_v8']/a[text()='Giriş Yap' or contains(@href,'girisi')]"));
        wait.until(ExpectedConditions.elementToBeClickable(GIRIS_YAP_BUTTON));
        GIRIS_YAP_BUTTON.click();

        WebElement EMAIL_INPUT = driver.findElement(By.xpath("//input[@id='new-email']"));
        wait.until(ExpectedConditions.elementToBeClickable(EMAIL_INPUT));
        EMAIL_INPUT.click();
        EMAIL_INPUT.sendKeys(email);

        WebElement DEVAM_ET_BUTTON = driver.findElement(By.cssSelector("div.bc > button"));
        wait.until(ExpectedConditions.visibilityOf(DEVAM_ET_BUTTON));
        DEVAM_ET_BUTTON.click();

        WebElement PASSWORD_INPUT = driver.findElement(By.xpath("//input[@type='password']"));
        wait.until(ExpectedConditions.visibilityOf(PASSWORD_INPUT));
        PASSWORD_INPUT.sendKeys(password);

        WebElement GIRIS_YAP_BUTTON2 = driver.findElement(By.xpath("//div[@class='bc']/button"));
        GIRIS_YAP_BUTTON2.click();

        WebElement PROFILE_MENU = driver.findElement(By.xpath("//a[@title='Hesabım']"));
        wait.until(ExpectedConditions.visibilityOf(PROFILE_MENU));
        System.out.println("Giriş Başarılı");

        PROFILE_MENU.click();

        WebElement cikisYapButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href,'Çık')]")));
        Assert.assertTrue("Çıkış yap linki görünür olmalı", cikisYapButton.isDisplayed());

        WebElement CIKISYAP = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href,'Çık')]")));
        Assert.assertTrue("Çıkış yap linki görünür olmalı", CIKISYAP.isDisplayed());
        cikisYapButton.click();
        System.out.println("Çıkış işlemi tamamlandı");

        Thread.sleep(2000);
        driver.navigate().back();
        WebElement GirisMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='H_rl_v8']/a[text()='Giriş Yap' or contains(@href,'girisi')]")));
        Assert.assertTrue("Ana Menüye Geçilemedi",GirisMenu.isDisplayed());

        System.out.println("Ana Menüye Geçiş Yapıldı");

        driver.quit();

    }


}
