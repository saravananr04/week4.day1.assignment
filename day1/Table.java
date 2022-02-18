package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement ToyTable = driver.findElement(By.id("table_id"));
		List<WebElement> Rows = ToyTable.findElements(By.tagName("tr"));
		System.out.println("Number of rows: " + Rows.size());
		WebElement firstRow = Rows.get(1);
		int TotalColumn = firstRow.findElements(By.tagName("td")).size();
		System.out.println("Number of Columns: " + TotalColumn);
		
		for (int i = 0; i < Rows.size(); i++) {
			WebElement currentRow = Rows.get(i);
			List<WebElement> listColumns = currentRow.findElements(By.tagName("td"));
			for (int j = 0; j < listColumns.size(); j++) {
				if (listColumns.get(j).getText().contains("Learn to interact with Elements")) {
					System.out.println(listColumns.get(1).getText());
				}
				else if(listColumns.get(j).getText().contains("Learn to interact using Keyboard, Actions")) {
					driver.findElement(By.xpath("(//tr[@class='even']//input)[2]")).click();
				}
				File source = driver.getScreenshotAs(OutputType.FILE);
				File dest = new File(".src/main/resources/snaps/Img03.jpg");
				FileUtils.copyFile(source, dest);

			}
		}

	}

}