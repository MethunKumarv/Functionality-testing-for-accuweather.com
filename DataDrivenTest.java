package demo1;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	private WebDriver driver;
	private String baseUrl = "https://www.accuweather.com/";

	    @BeforeClass
	    public void setUp1() 
	    {
	        System.setProperty("webdriver.edge.driver", "E:\\VIT SYLLABUS\\4th Sem\\ST\\New folder\\demo1\\drivers\\msedgedriver.exe");
	        EdgeOptions options = new EdgeOptions();
	        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe ");
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	    }
	    
	    @Test(dataProvider = "testdata")
	    public void testSearch1(String place, String validity) throws InterruptedException 
	    {
	    	driver.get(baseUrl);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-input")));
	        searchBox.sendKeys(place);
	        searchBox.submit();
	        Thread.sleep(2000);
	        try {
	        	driver.findElement(By.className("locations-list"));
	        	WebElement placename = driver.findElement(By.className("location-name")); 
	 	        placename.click();
	 	         
	 		     if(validity.equals("yes"))
	 		     {
	 		    	 WebElement searchResult1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("three-day")));
	 		    	 Assert.assertTrue(searchResult1.isDisplayed(), "Search result not displayed");
	 		     }
		        
	 		     if(validity.equals("no"))
	 		     {
	 		        WebElement searchResult2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("no-results-text")));
	 		        Assert.assertTrue(searchResult2.isDisplayed(), "Search result not displayed");
	 		     }
	        	} 
	        
	        	catch(org.openqa.selenium.NoSuchElementException e) 
	        	{
	        		
	        		if(validity.equals("yes"))
	        		{
	        			WebElement searchResult1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("three-day")));
	        			Assert.assertTrue(searchResult1.isDisplayed(), "Search result not displayed");
	        		}
		        
	        		if(validity.equals("no"))
	        		{
	        			WebElement searchResult2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("no-results-text")));
	        			Assert.assertTrue(searchResult2.isDisplayed(), "Search result not displayed");
	        		}
	        	}
	    }
	    
	    @DataProvider(name = "testdata")
	    public String [][] getData() throws IOException
	    {
	    	String path = "E:\\VIT SYLLABUS\\4th Sem\\ST\\testdata.xlsx";
	    	XLUtility xlutil = new XLUtility(path);
	    	int totalrows = xlutil.getRowCount("Sheet1");
	    	int totalcols = xlutil.getCellCount("Sheet1",1);
	    	String testdata[][] = new String[totalrows][totalcols];
	    	
	    	for(int i=1;i<=totalrows;i++)
	    	{
	    		for(int j=0;j<totalcols;j++)
	    		{
	    			testdata[i-1][j] = xlutil.getCellData("Sheet1",i,j);
	    		}
	    	}
	    	return testdata;
	    }
	    
	   @AfterClass
	    public void afterMethod1() throws Exception{
	        Thread.sleep(2000);
	        driver.quit();
	    }
}
