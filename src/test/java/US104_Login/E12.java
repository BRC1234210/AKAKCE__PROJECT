package US104_Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class E12 {
    public static void main(String[] args) {
        //Geçersiz email girişi olduğunda
        WebDriver driver = BaseDriver.driver("https://www.akakce.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        WebElement signInBtn = driver.findElement(By.xpath("//a[contains(@href,'/hesabim/giris')]"));
        signInBtn.click();

        final String email = "tavejif130@aiwancom";
        final String password = "EDLnue7xKS7kiH6";

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='email']")));
        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        BaseDriver.threadWait(3);

        WebElement warningText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-e='Lütfen geçerli bir e-posta adresi yazın.']")));
        Assert.assertTrue("Email uyarı yazısı görünmedi.", warningText.isDisplayed());

        driver.quit();
    }
}
