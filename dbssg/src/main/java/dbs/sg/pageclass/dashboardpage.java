package dbs.sg.pageclass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;

import dbs.sg.Base;

public class dashboardpage extends Base
{
	private WebDriver localdriver;
	public dashboardpage(WebDriver dbsdriver) {
		this.localdriver=dbsdriver;
		PageFactory.initElements(localdriver, this);
	} 
	
	/*Author: Harshith r
	 * Description: method is for validating user landed on dashboard page*/
	public void validatelandedondashboarpage() {
		try {
			if(localdriver.findElement(By.xpath("//div[@id='flpHeader']//a[text()='Cards']")).isDisplayed()) {
				test.log(LogStatus.INFO, "user landed on dashboard page successfully");
				System.out.println("user landed on dashboard page successfully");
			}
		} catch (Exception e) {
			aborttest(e+"");
		}
	}
	
	public void aborttest(String exception) {
		 test.log(LogStatus.FAIL,exception);
		 Assert.fail();
	 }
	
}
