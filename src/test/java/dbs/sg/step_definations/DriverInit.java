package dbs.sg.step_definations;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.LogStatus;

import dbs.sg.Base;
import io.cucumber.java.*;

public class DriverInit extends Base
{
    @Before
    public void beforeScenario() {
    	reports.loadConfig(new File("/extent-config.xml"));
    	 test=reports.startTest("compare credit cards");
    	launchdriver();
    }
    public void launchdriver() {
    	System.setProperty ("webdriver.edge.driver", "drivers\\msedgedriver.exe");
    	dbsdriver=new EdgeDriver();
    	dbsdriver.manage().window().maximize();
    	dbsdriver.get(url);
    	dbsdriver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    	
    }
    @After
    public void afterScenario() {
    	reports.flush();
    	dbsdriver.quit();
    }
    
}
