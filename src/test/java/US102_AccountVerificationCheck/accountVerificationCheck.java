package US102_AccountVerificationCheck;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class accountVerificationCheck {
    public static void main(String[] args) {
        WebDriver chromeDriver=new ChromeDriver();
        chromeDriver.get("https://www.akakce.com/");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait=new WebDriverWait(chromeDriver,Duration.ofSeconds(30));

        final String email="i.ahmedkoc@gmail.com";
        final String password="Maykop0101";
        final String expectedUserName="Ismail Ahmed";

        WebElement girisyapBtn=chromeDriver.findElement(By.xpath("//div[@class='g-3_v8 hm_hp_v8']/div/a"));
        wait.until(ExpectedConditions.elementToBeClickable(girisyapBtn));
        girisyapBtn.click();

        WebElement emailInput=chromeDriver.findElement(By.xpath("//input[@class='email']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='email']")));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys(email);

        WebElement devametBtn=chromeDriver.findElement(By.xpath("//div[@class='bc']/button/b"));
        wait.until(ExpectedConditions.elementToBeClickable(devametBtn));
        devametBtn.click();

        WebElement passwordInput=chromeDriver.findElement(By.xpath("//input[@type='password']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.click();
        passwordInput.sendKeys(password);
        passwordInput.click();

        WebElement parolagosterBtn=chromeDriver.findElement(By.xpath("//i[@class='e']"));
        parolagosterBtn.click();

        WebElement girisYapBtn2=chromeDriver.findElement(By.xpath("//div[@class='bc']/button"));
        girisYapBtn2.click();

        WebElement userNameText=chromeDriver.findElement(By.xpath("//div/a/i"));
        wait.until(ExpectedConditions.visibilityOf(userNameText));

        final String actualText=userNameText.getText();

        Assert.assertEquals("Username uyumsuz!",expectedUserName,actualText);

        chromeDriver.quit();




    }
}
