package dbs.sg.pageclass;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import dbs.sg.Base;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

public class creditcardspage extends Base
{
	private WebDriver localdriver;
	public creditcardspage(WebDriver dbsdriver) {
		this.localdriver=dbsdriver;
		PageFactory.initElements(localdriver, this);
	} 

	/*
	 * Author: Harshith R Description: method to validate the data for selected
	 * credit cards for compare
	 */ 
	 public void validatecredicarddata(DataTable table) {
		 List<Map<String, String>> ccards = table.asMaps(String.class, String.class);
		 String cc1 = ccards.get(0).get("card1");
		 String cc2 = ccards.get(0).get("card2");
		 validatecarddata(cc1);
		 validatecarddata(cc2);
	 }
	 
	 public void validatecarddata(String cardname) {
		 try {
			 boolean b;
			 WebElement ele;
			 switch (cardname) {
			case "DBS Altitude Visa Signature Card":
				//validating selected cards are displayed or not
				ele=localdriver.findElement(By.xpath("//div[text()='"+cardname+"']/../../div[starts-with(@data-flk-success,'atNodeInserted')]"));
				Assert.assertTrue(ele.isDisplayed());
				//validating the card data
				//best for
				b=localdriver.findElement(By.xpath("(//div[text()='Best For']/following-sibling::div)[1]")).getText().equals("It's the fastest way to fly anywhere.");
				Assert.assertTrue(b);
				//card type
				b=localdriver.findElement(By.xpath("(//div[text()='Card Type']/following-sibling::div)[1]")).getText().equals("VISA");
				Assert.assertTrue(b);		
				//min income per annum
				b=localdriver.findElement(By.xpath("(//div[text()='Min Income Per Annum']/following-sibling::div)[1]")).getText().equals("S$30,000");
				Assert.assertTrue(b);		
				//motoring
				b=localdriver.findElement(By.xpath("(//div[text()='Motoring']/following-sibling::div/span)[1]")).getText().equals("Get 14% instant fuel savings at Esso");
				Assert.assertTrue(b);
				test.log(LogStatus.PASS, "validated credit card: "+cardname);
				break;
			case "DBS Black Visa Card":
				//validating selected cards are displayed or not
				ele=localdriver.findElement(By.xpath("//div[text()='"+cardname+"']/../../div[starts-with(@data-flk-success,'atNodeInserted')]"));
				Assert.assertTrue(ele.isDisplayed());
				//validating the card data
				//best for
				b=localdriver.findElement(By.xpath("//div[text()='Shopping is the new black']")).isDisplayed();
				Assert.assertTrue(b);
				//card type
				b=localdriver.findElement(By.xpath("//div[text()='"+cardname+"']/../following-sibling::div//div[text()='VISA']")).isDisplayed();
				Assert.assertTrue(b);		
				//min income per annum
				b=localdriver.findElement(By.xpath("//div[text()='"+cardname+"']/../following-sibling::div//div[text()='S$30,000']")).isDisplayed();
				Assert.assertTrue(b);		
				//motoring
				b=localdriver.findElement(By.xpath("//div[text()='"+cardname+"']/../following-sibling::div//div/span[text()='Get 14% instant fuel savings at Esso']")).isDisplayed();
				Assert.assertTrue(b);
				test.log(LogStatus.PASS, "validated credit card: "+cardname);
				break;
			default:
				test.log(LogStatus.PASS, "select valid credit card");
				break;
			}
		} catch (Exception |AssertionError e) {
			aborttest(e+"");
		}
	 }
	 
	 public void aborttest(String exception) {
		 test.log(LogStatus.FAIL,exception);
		 Assert.fail();
	 }

}
