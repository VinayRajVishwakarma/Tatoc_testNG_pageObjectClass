package qaittesting.Tatoc_TestNg;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Tatoc {

	WebDriver driver;

	public Tatoc(WebDriver driver) {
		this.driver = driver;
	}

	public String basic_Course() {
		driver.findElement(By.cssSelector("a")).click();
		//return this.driver.getTitle().toString();
		
	String url = driver.getTitle();
		System.out.println(url);
		return url;
	}

	public String GreenBoxTap() {
		driver.findElement(By.className("greenbox")).click();
		return this.driver.getTitle().toString();
	}

	public String Box1_color() {
		ChangeTheColor();
		this.driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		return this.driver.getTitle().toString();
	}

	public String AfterDragAndDrop() {
		
		driver.switchTo().defaultContent();
		
		WebElement drag= driver.findElement(By.id("dragbox"));
		WebElement drop= driver.findElement(By.id("dropbox"));	
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
		
		this.driver.findElement(By.cssSelector("a")).click();
		return this.driver.getTitle().toString();
	}

	public void ChangeTheColor() {
		WebDriver element2 = driver.switchTo().frame(driver.findElement(By.id("main")));
		Boolean condition = true;
		String str = element2.findElement(By.id("answer")).getAttribute("class");
		System.out.println(str);
		while (condition) {
			driver.findElement(By.cssSelector("a")).click();
			
			WebElement childElement= driver.findElement(By.id("child"));
			driver.switchTo().frame(childElement);
		 String str2 = driver.findElement(By.id("answer")).getAttribute("class");
		 driver.switchTo().parentFrame();

		if(str.equals(str2)){
			condition = false;
		}
		}

	}
	
	public void LaunchPopUp(){
		driver.findElement(By.cssSelector("a")).click();
	}
	
	public String PopUpTab(){
		LaunchPopUp();
		 ArrayList tabs = new ArrayList (driver.getWindowHandles());
		    System.out.println(tabs.size());
		    driver.switchTo().window((String) tabs.get(1)); 
		    
		    System.out.println(driver.getTitle());
		    driver.findElement(By.id("name")).sendKeys("Vinay");
			driver.findElement(By.id("submit")).click();
			
			driver.switchTo().window((String) tabs.get(0));
			driver.findElements(By.tagName("a")).get(1).click();
			return this.driver.getTitle().toString();
	}
	public String GenerateToken(){
		driver.findElements(By.tagName("a")).get(0).click();
		String token = driver.findElement(By.id("token")).getText();
		return token;
	}
	public String CreateCookie(){
		String token =GenerateToken();
		String t1 = token.split(" ")[1];
		//System.out.println(token.split(" ")[1]+"######");
		
		Cookie cookie = new Cookie("Token",t1);
		driver.manage().addCookie(cookie);
		System.out.println(cookie);
				
		driver.findElements(By.tagName("a")).get(1).click();
	return driver.getTitle().toString();
	}
}
