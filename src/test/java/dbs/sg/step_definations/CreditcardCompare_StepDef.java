package dbs.sg.step_definations;



import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import dbs.sg.Base;
import dbs.sg.pageclass.creditcardspage;
import dbs.sg.pageclass.dashboardpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class CreditcardCompare_StepDef extends Base
{
	WebDriverWait wait= new WebDriverWait(dbsdriver, 3000);
	creditcardspage creditcardspage = new creditcardspage(dbsdriver); 
	dashboardpage dashboarpage=new dashboardpage(dbsdriver);
	
	/*Author: Harshith r
	 * Description: method is for validating user landed on dashboard page*/
	@Given("^user launch on dashboard page$")
	public void user_launch_on_dashboard_page() {
		dashboarpage.validatelandedondashboarpage();
	}
	
	/* Description: method is for clicking on cards link*/
	@Then("^user clicks on cards link$")
	public void userClicksonCardsLink() {
		dbsdriver.findElement(By.xpath("//div[@id='flpHeader']//a[text()='Cards']")).click();
		test.log(LogStatus.INFO, "user clicked on cards link");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[starts-with(@data-flk-success,'atNodeInserted') and text()='Credit Cards']")));
	}

	
	/*Author: Harshith r
	 * Description: method is for clicking on credit card link*/
	 @And("^user clicks on credit cards link$")
	 public void userclicksoncreditcardslink() {
		 dbsdriver.findElement(By.xpath("//a[starts-with(@data-flk-success,'atNodeInserted') and text()='Credit Cards']")).click();
		 test.log(LogStatus.INFO, "credit cards link is displayed");
	 }
	 
	 
	/*Author: Harshith r
	 * Description: method selects the cards from input(parameterized) and validates the cards data*/
	 @Then("^user selects and validates credit cards$")
	 public void selctcardstocompareandValidate(DataTable table) {
		 try {
		 WebElement ele;
		 List<Map<String, String>> ccards = table.asMaps(String.class, String.class);
	    String cc1 = ccards.get(0).get("card1");
	    String cc2 = ccards.get(0).get("card2");
	    
		//selecting card1
	    ele=dbsdriver.findElement(By.xpath("//div[text()='"+cc1+"']/../../..//div[text()='Compare']/..//div"));
		((JavascriptExecutor) dbsdriver).executeScript("arguments[0].scrollIntoView(true);", ele);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		((JavascriptExecutor) dbsdriver).executeScript("arguments[0].click();",ele );
		Thread.sleep(2500);	
		
		//selecting card2
		ele=dbsdriver.findElement(By.xpath("//div[text()='"+cc2+"']/../../..//div[text()='Compare']/..//div"));
		((JavascriptExecutor) dbsdriver).executeScript("arguments[0].scrollIntoView(true);", ele);
		((JavascriptExecutor) dbsdriver).executeScript("arguments[0].click();", ele);
		
		//click on compare button
		dbsdriver.findElement(By.xpath("//button[@id='cardCompareBtn']")).click();
		test.log(LogStatus.PASS, "user selected cards and clicked on compare button");
		//validate the data displayed for each card for comparison
		creditcardspage.validatecredicarddata(table);
		 } catch (Exception e) {
			 test.log(LogStatus.FAIL, e);
			creditcardspage.aborttest(e+"");
		}
	 }

}
