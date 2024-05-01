package demo1;

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
import org.testng.annotations.Test;

class ParallelTest1 {
	 private WebDriver driver;
	 private String baseUrl = "https://www.accuweather.com/";

	    @BeforeClass
	    public void setUp1() {
	        System.setProperty("webdriver.edge.driver", "E:\\VIT SYLLABUS\\4th Sem\\ST\\New folder\\demo1\\drivers\\msedgedriver.exe");
	        EdgeOptions options = new EdgeOptions();
	        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe ");
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	    }
	    
	    @Test
	    public void testTitle() {
	        driver.get(baseUrl);
	        String expectedTitle = "Local, National, & Global Daily Weather Forecast | AccuWeather";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
	        System.out.println("Test1 Execution"+Thread.currentThread().threadId());
	        try {
	        	Thread.sleep(5000);
	        	}
	        catch(Exception e) {
	        	System.out.println(e);
	        	}
	    }

	   @Test
	    public void testhomebutton()
	    {
	    	driver.get(baseUrl);
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	WebElement header_logo = driver.findElement(By.className("header-logo"));
	    	header_logo.click();
	    	WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home")));
	        Assert.assertTrue(result.isDisplayed(), "Search result not displayed");
	        System.out.println("Test2 Execution"+Thread.currentThread().threadId());
	        try {
		        Thread.sleep(5000);
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	    }
	    
	   @Test
	    public void testHamburgerButton() {
	        // Navigate to accuweather.com
	        driver.get("https://www.accuweather.com/");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement hamburgerButton = driver.findElement(By.className("hamburger-button"));
	        hamburgerButton.click();
	        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu-open")));
	        Assert.assertTrue(result.isDisplayed(), "Search result not displayed");
	        System.out.println("Test3 Execution"+Thread.currentThread().threadId());
	        try {
		        Thread.sleep(5000);
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	    }

	   @Test
	    public void testSearch1() {
	    	driver.get(baseUrl);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-input")));
	        searchBox.sendKeys("London");
	        searchBox.submit();
	        WebElement placename = driver.findElement(By.className("location-name"));
	        placename.click();
	        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("three-day")));
	        Assert.assertTrue(searchResult.isDisplayed(), "Search result not displayed");
	        System.out.println("Test4 Execution"+Thread.currentThread().threadId());
	        try {
		        Thread.sleep(5000);
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	    }
	   
	   @AfterClass
	    public void afterMethod1() throws Exception{
	        Thread.sleep(2000);
	        driver.quit();
	    }
}

class Parallel2{
	private WebDriver driver;
	private String baseUrl = "https://www.accuweather.com/";

	    @BeforeClass
	    public void setUp1() {
	        System.setProperty("webdriver.edge.driver", "E:\\VIT SYLLABUS\\4th Sem\\ST\\New folder\\demo1\\drivers\\msedgedriver.exe");
	        EdgeOptions options = new EdgeOptions();
	        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe ");
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	    }
	    
	    @Test
	    public void testSearch2() {
	    	driver.get(baseUrl);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-input")));
	        searchBox.sendKeys("123!@#456$%^");
	        searchBox.submit();
	        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("no-results-text")));
	        Assert.assertTrue(searchResult.isDisplayed(), "Search result not displayed");
	        System.out.println("Test5 Execution"+Thread.currentThread().threadId());
	        try {
		        Thread.sleep(5000);
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	    }

	    @Test
	    public void SeeMoreButton(){
	        driver.get("https://www.accuweather.com/");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement seemore = driver.findElement(By.className("cta-title"));
	        seemore.click();
	        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("map-radar")));
	        Assert.assertTrue(result.isDisplayed(), "Search result not displayed");
	        System.out.println("Test6 Execution"+Thread.currentThread().threadId());
	        try {
		        Thread.sleep(5000);
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	    }

	   @Test
	    public void News(){
	        driver.get("https://www.accuweather.com/");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement news = driver.findElement(By.className("right-rail-article__category"));
	        news.click();
	        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("article")));
	        Assert.assertTrue(result.isDisplayed(), "Search result not displayed");
	        System.out.println("Test7 Execution"+Thread.currentThread().threadId());
	        try {
		        Thread.sleep(5000);
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	    }
	    
	    @Test
	    public void Videos() {
	        driver.get(baseUrl);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement video = driver.findElement(By.className("right-rail-article__video-thumb"));
	        video.click();
	        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("video-wall")));
	        Assert.assertTrue(result.isDisplayed(), "Search result not displayed");
	        System.out.println("Test8 Execution"+Thread.currentThread().threadId());
	        try {
		        Thread.sleep(5000);
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	    }
	       
	   @AfterClass
	    public void afterMethod2() throws Exception{
	        Thread.sleep(2000);
	        driver.quit();
	    }
}
