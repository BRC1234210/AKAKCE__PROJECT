package US107_DeleteAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import javax.swing.*;
import java.time.Duration;

public class deleteAccount {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BaseDriver.driver("https://www.akakce.com/");
        driver.manage().window().maximize();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        final String userNamee= "wociwi2270@ampdial.com";
        final String password= "Hifamm2028.";

        WebElement girisyapBtn=driver.findElement(By.xpath("//div[@class='g-3_v8 hm_hp_v8']/div/a"));
        girisyapBtn.click();
        Thread.sleep(3000);


        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='email']")));
        emailInput.sendKeys(userNamee);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();
        Thread.sleep(3000);


        WebElement devamEtBtn= driver.findElement(By.xpath("//div[@class='bc']/button['Devam Et']"));
        devamEtBtn.click();
        Thread.sleep(3000);


        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.sendKeys(password);

        WebElement girişYapBtn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button[@id='update']")));
        girişYapBtn.click();

       WebElement hesabımBtn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='g-3_v8 hm_hp_v8']/div[@id='HM_v8']")));
       hesabımBtn.click();

       WebElement kişiselBilgilerimBtn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mnu']/a")));
       kişiselBilgilerimBtn.click();

       WebElement güncelleBtn= driver.findElement(By.xpath("//div[@class='bc']/button"));
       js.executeScript("arguments[0].scrollIntoView(true)",güncelleBtn);

        BaseDriver.threadWait(3);

       WebElement hesabımıSilBtn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc w']/button['Hesabımı Sil']")));
       hesabımıSilBtn.click();

        WebElement silmeyeDevamEtBtn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc del-ac-btn']/button[@type='submit']")));
        js.executeScript("arguments[0].scrollIntoView(true)",silmeyeDevamEtBtn);
        silmeyeDevamEtBtn.click();

        Thread.sleep(3000);

        WebElement diğerBtn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='del-ac-op']/label[3]")));
        diğerBtn.click();

        Thread.sleep(3000);

        WebElement sonHesabımıSilBtn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc del-ac-btn']/button")));
        sonHesabımıSilBtn.click();

        Thread.sleep(4000);

        driver.quit();






    }



}
