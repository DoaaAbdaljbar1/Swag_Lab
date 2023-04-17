package swag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HomePage {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/");
		String userName ="standard_user";
		String passWord ="secret_sauce";
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passWord);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		

List<WebElement> myButtons=driver.findElements(By.className("btn"));
for(int i=0;i< myButtons.size();i++) {
	myButtons.get(i).click();}
	int expectedItems=6;
	String actuallItemsAdd= driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
	int theRealy=Integer.parseInt(actuallItemsAdd);
Assert.assertEquals( theRealy,expectedItems );




	}

}
