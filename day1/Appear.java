package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Appear {
	public static void main(String[] args)  throws IOException
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/appear.html");
	WebDriverWait ExWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	ExWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn")));
	boolean ButtonAppeared = driver.findElement(By.id("btn")).isDisplayed();
	if (ButtonAppeared == true)
	{
		System.out.println("The button has appeared");
	} else {
		System.out.println("The button has not appeared");
	}
	String Buttontext = driver.findElement(By.id("btn")).getText();
	System.out.println("The button text is " +Buttontext);
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File(".src/main/resources/Snaps/Img001.jpg");
	FileUtils.copyFile(source, dest);
}
}



