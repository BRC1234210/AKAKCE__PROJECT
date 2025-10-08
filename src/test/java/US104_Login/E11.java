package US104_Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class E11 {
    public static void main(String[] args) {

        //Geçersiz password girişi olduğunda
        WebDriver driver = BaseDriver.driver("https://www.akakce.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        WebElement signInBtn = driver.findElement(By.xpath("//a[contains(@href,'/hesabim/giris')]"));
        signInBtn.click();

        final String email = "tavejif130@aiwanlab.com";
        final String password = "12345";

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='email']")));
        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.sendKeys(password);

        BaseDriver.threadWait(3);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        WebElement warningText = driver.findElement(By.xpath("//div[@data-e='Lütfen şifrenizi kontrol edin.']"));

        Assert.assertTrue("Password uyarı yazısı görünmedi.", warningText.isDisplayed());

        driver.quit();
    }
}
