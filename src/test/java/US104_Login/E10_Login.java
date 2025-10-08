package US104_Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class E10_Login {
    public static void main(String[] args) {
        // Doğru email ve password girişi olduğunda
        WebDriver driver =BaseDriver.driver("https://www.akakce.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        WebElement signInBtn = driver.findElement(By.xpath("//a[contains(@href,'/hesabim/giris')]"));
        signInBtn.click();

        final String email = "tavejif130@aiwanlab.com";
        final String password = "EDLnue7xKS7kiH6";

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='email']")));
        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.sendKeys(password);

        BaseDriver.threadWait(3);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        WebElement homePageTitle = driver.findElement(By.xpath("//a[@title='Kategoriler']"));

        Assert.assertTrue("HomePage açılmadı", homePageTitle.isDisplayed());

        driver.quit();

    }
}
