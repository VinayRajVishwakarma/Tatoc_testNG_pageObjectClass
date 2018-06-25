package qaittesting.Tatoc_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class TATOC_test {

	WebDriver driver;
	Tatoc page;

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		page = new Tatoc(driver);
	}

	@Test
	public void test01() {
		Assert.assertTrue((page.basic_Course().equalsIgnoreCase("Grid Gate - Basic Course - T.A.T.O.C")),"Page is not correct");
	}

	@Test
	public void test02() {

		Assert.assertTrue(page.GreenBoxTap().contentEquals("Frame Dungeon - Basic Course - T.A.T.O.C"));
	}

	
	  @Test 
	  public void test03(){ 
	  Assert.assertTrue(page.Box1_color().contentEquals("Drag - Basic Course - T.A.T.O.C"));
	  }
	  
	  @Test 
	  public void test04(){ 
		 
	  Assert.assertTrue(page.AfterDragAndDrop().contentEquals("Windows - Basic Course - T.A.T.O.C")); 
	  }
	  
	  @Test
	  public void test05(){
		Assert.assertTrue(page.PopUpTab().contentEquals("Cookie Handling - Basic Course - T.A.T.O.C"));  
	  }
	  
	  @Test 
	  public void test06(){
		  
		 Assert.assertTrue(page.CreateCookie().contentEquals("End - T.A.T.O.C"), "Cookie not created");
	  }

}
