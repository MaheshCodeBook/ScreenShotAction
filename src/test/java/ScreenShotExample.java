import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


 public class ScreenShotExample {
     public static void main(String[] args) {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.get("https://qajobbyapp.ccbp.tech/login");

         WebElement usernameEl = driver.findElement(By.id("userNameInput"));
         usernameEl.sendKeys("rahul");
         WebElement passwordEl = driver.findElement(By.id("passwordInput"));
         passwordEl.sendKeys("rahul@2021");

         WebElement buttonEl = driver.findElement(By.className("login-button"));
         buttonEl.submit();

         String homePageUrl=  "https://qajobbyapp.ccbp.tech/";

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlToBe(homePageUrl));

         String currentUrl = driver.getCurrentUrl();

         if(currentUrl.equals(homePageUrl)){
             System.out.println("Navigation to home page is successful!");
         }

         TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
         File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);

         try {
             FileUtils.copyFile(screenshot, new File("G:\\NxtWave Automated\\abc.png"));
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }

         driver.quit();
     }
 }