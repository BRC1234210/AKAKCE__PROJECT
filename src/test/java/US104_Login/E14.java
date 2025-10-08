package US104_Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class E14 {
    public static void main(String[] args) {
        //email ve password'e herhangi bir giris yapilmadiğinda
        WebDriver driver = BaseDriver.driver("https://www.akakce.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        WebElement signInBtn = driver.findElement(By.xpath("//a[contains(@href,'/hesabim/giris')]"));
        signInBtn.click();

        final String email = "";

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='email']")));
        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        BaseDriver.threadWait(3);

        WebElement warningText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-e='Lütfen e-posta adresinizi yazın.']")));
        Assert.assertTrue("Uyarı yazısı görünmedi.", warningText.isDisplayed());

        driver.quit();
    }
}
