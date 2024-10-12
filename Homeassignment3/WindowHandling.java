package Homeassignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WindowHandling {
	 public static void main(String[] args) {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        WebDriver driver = new ChromeDriver(options);
	            driver.get("http://leaftaps.com/opentaps/control/login");
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	            driver.findElement(By.id("password")).sendKeys("crmsfa");
	            driver.findElement(By.className("decorativeSubmit")).click();
	            driver.findElement(By.linkText("CRM/SFA")).click();
	            driver.findElement(By.linkText("Contacts")).click();
	            driver.findElement(By.linkText("Merge Contacts")).click();
	            driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
	            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	            driver.switchTo().window(tabs.get(1));
	            driver.findElement(By.xpath("(//a[contains(text(),'Demo Contact')])[1]")).click();
	            driver.switchTo().window(tabs.get(0));
	            driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	            tabs = new ArrayList<>(driver.getWindowHandles());
	            driver.switchTo().window(tabs.get(1));
	            driver.findElement(By.xpath("(//a[contains(text(),'Demo Contact')])[2]")).click();
	            driver.switchTo().window(tabs.get(0));
	            driver.findElement(By.className("buttonDangerous")).click();
	            driver.switchTo().alert().accept();
	            String title = driver.getTitle();
	            driver.quit();
	        }
	    }
