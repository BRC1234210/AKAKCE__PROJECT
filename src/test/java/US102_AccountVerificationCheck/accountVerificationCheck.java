package US102_AccountVerificationCheck;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class accountVerificationCheck {
    public static void main(String[] args) {

        WebDriver driver= BaseDriver.driver("https://www.akakce.com/");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        final String email="i.ahmedkoc@gmail.com";
        final String password="Maykop0101";
        final String expectedUserName="Ismail Ahmed";

        WebElement girisyapBtn=driver.findElement(By.xpath("//div[@class='g-3_v8 hm_hp_v8']/div/a"));
        girisyapBtn.click();

        BaseDriver.threadWait(3);

        WebElement emailInput=driver.findElement(By.xpath("//input[@class='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys(email);

        WebElement devametBtn=driver.findElement(By.xpath("//div[@class='bc']/button/b"));
        devametBtn.click();

        WebElement passwordInput=driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys(password);

        WebElement girisYapBtn2=driver.findElement(By.xpath("//div[@class='bc']/button"));
        girisYapBtn2.click();

        WebElement userNameText=driver.findElement(By.xpath("//div[@class='g-3_v8 hm_hp_v8']/div/a/i"));
        wait.until(ExpectedConditions.visibilityOf(userNameText));

        final String actualText=userNameText.getText();

        Assert.assertEquals("Username uyumsuz!", expectedUserName, actualText);

        driver.quit();


    }
}



