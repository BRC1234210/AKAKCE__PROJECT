package US105_OrderListCheck;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class OrderListCheck {
    public static void main(String[] args) {

        //Step 1:Siteye git
        WebDriver driver = BaseDriver.driver("https://www.akakce.com/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //Step2:Giriş yap butonuna tıkla
        WebElement signBtn = driver.findElement(By.xpath("//a[@href='/hesabim/giris/']"));
        signBtn.click();

        //Step 3: E-mail adresini gir

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='email']")));
        final String email = "vekekec607@bllibl.com";
        emailInput.sendKeys(email);

        WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='update']")));
        continueBtn.click();

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='umpc']")));
        final String password = "Akakçe12345*";
        passwordInput.sendKeys(password);

        //Step 4: Giriş yap butonuna tıkla
        WebElement loginBtn = driver.findElement(By.xpath("//div[@class='bc']"));
        loginBtn.click();

        //Step 5: "Hesabım" sayfasına geçişi kontrol et
        WebElement myAccountBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/hesabim/']")));
        myAccountBtn.click();

        //Step 6: "Listelerim" butonuna,daha sonra da "Market Listem" butonuna click yap.
        WebElement myListBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mnu sec']/a[2]")));
        myListBtn.click();

        WebElement markedListBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Market Listem']/span[2]/span[1]")));
        markedListBtn.click();

        //Step 7: Açılan sayfada "Listenizde Hiç Ürün Yok" mesajını gör
        WebElement messageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='empty_list']/p")));
        Assert.assertTrue("Listenizde Hiç Ürün Yok mesajı görüntülenemiyor", messageText.isDisplayed());

        //Step 8:quit
        driver.quit();
    }
}
