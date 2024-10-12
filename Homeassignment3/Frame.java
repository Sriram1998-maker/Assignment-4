package Homeassignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;


public class Frame {
	public static void main(String[] args) {
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");
     WebDriver driver = new ChromeDriver(options);
         driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.switchTo().frame("iframeResult");
         driver.findElement(By.xpath("//button[text()='Try it']")).click();
         String alertText = driver.switchTo().alert().getText();
         System.out.println("Alert text: " + alertText);
         driver.switchTo().alert().accept();
         WebElement resultText = driver.findElement(By.id("demo"));
         String displayedText = resultText.getText();
         if (displayedText.contains("Hello")) {
             System.out.println("Action performed correctly: " + displayedText);
         } else {
             System.out.println("Action not performed as expected: " + displayedText);
         }
         driver.quit();
     }
}
