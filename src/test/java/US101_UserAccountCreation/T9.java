package US101_UserAccountCreation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class T9 {
    public static void main(String[] args) {


        // 1. ve 2. step
        WebDriver driver = BaseDriver.driver("https://www.akakce.com/");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));


        // 3.step
        WebElement homePageText = driver.findElement(By.xpath("//a[@id='H_c_v8']"));

        final String expectedHomePage = "Kategoriler";
        final String actualHomePage = homePageText.getText();

        Assert.assertEquals("Home Page acılmadı", expectedHomePage,actualHomePage);

        // 4.step

        WebElement accountBtn =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Hesabım']")));
        accountBtn.click();

        // 5.step

        WebElement enterBtn = driver.findElement(By.xpath("//div[@class='wbb_v8 lp n']/button"));
        enterBtn.click();

        // 6.step
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#new-email")));

        emailInput.sendKeys("kemepi4496@arqsis.com");

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bc']/button/b")));
        continueBtn.click();


        // 7.step
        WebElement loginPage = driver.findElement(By.cssSelector(".log-box"));
        Assert.assertTrue("Login Page gorunmedi", loginPage.isDisplayed());

        // 8.step
        WebElement nameInput = driver.findElement(By.cssSelector("input[id='name']"));
        WebElement surnameInput = driver.findElement(By.cssSelector("input[id='surname']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[id='umpc']"));

        nameInput.sendKeys("Test");
        surnameInput.sendKeys("Tester");
        passwordInput.sendKeys("pass123");

        WebElement checkBox = driver.findElement(By.cssSelector("input[name='rnufpca']")) ;
        checkBox.click();

        WebElement incorrectPasswordText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='input-wrapper er']")));
        Assert.assertFalse("Şifre basarıyla girildi", incorrectPasswordText.isDisplayed());

        driver.quit();



    }
}
