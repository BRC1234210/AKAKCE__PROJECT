package US106_MessageBoxCheck;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class T11 {
    public static void main(String[] args) {
        // 1.step
        WebDriver driver = BaseDriver.driver("https://www.akakce.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        // 2.step
        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/hesabim/giris')]")));
        signInBtn.click();

        // 3.step
        WebElement checkLogBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='new-email']")));
        Assert.assertTrue("Log-Box görüntülenmedi", checkLogBox.isDisplayed());

        //4.step
        final String email = "tavejif130@aiwanlab.com";
        final String password = "EDLnue7xKS7kiH6";

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='email']")));
        emailInput.sendKeys(email);

        // 5.step
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        // 6.step
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.sendKeys(password);

        BaseDriver.threadWait(3);

        // 7.step
        WebElement checkboxClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
        checkboxClick.click();

        // 8.step
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button"))).click();

        // 9.step
        WebElement loginDisplayed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='alertX t1']")));
        Assert.assertTrue("Başarıyla giriş görüntülenmedi", loginDisplayed.isDisplayed());

        // 10.step
        WebElement homePageCheck = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='H_a_v8']")));
        Assert.assertTrue("HomePage görüntülenmedi", homePageCheck.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='H_a_v8']"))).click();

        //11.step
        WebElement notificationVisible = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mi n']")));
        Assert.assertTrue("Notification button görüntülenmedi", notificationVisible.isDisplayed());

        // 12.step
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mi n']"))).click();

        // 13.step
        WebElement notificationCheck = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ntf-empty']")));
        Assert.assertTrue("Notification görüntülenmedi", notificationCheck.isDisplayed());

        driver.quit();
    }
}
