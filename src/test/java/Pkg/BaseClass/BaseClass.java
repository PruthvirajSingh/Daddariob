package Pkg.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.databind.JsonNode;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pkg.PageObject.CreateAccount;
import Pkg.PageObject.LoginAndAddProductIntoCart;
import Pkg.PageObject.LoginPage;
import Pkg.PageObject.Logout;
import Pkg.Utiltiy.Sparkreport;
import Pkg.Utiltiy.UtilClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Proxy;
public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public LoginPage login;
	public static Sparkreport report;
	public static UtilClass util;
	public ExtentReports extent;
	public static ExtentTest extentTest;
	public Logout logout;
	public CreateAccount createAccount;
	public static JsonNode node;
	public LoginAndAddProductIntoCart loginCartAdd;
	public static WebDriver chromeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("116");
		//New set up
		 // Set a user agent string to mimic a real browser
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("force-device-scale-factor=1.2");
		options.addArguments("high-dpi-support=1.2");
		options.addArguments("--disable-blink-features=AutomationControlled"); // Disables automation detection
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
	public static String jsonValue(String key) {
        return BaseClass.node.get(key).asText();
    }
	public static String jsonArrayValue(String parentkey, String key) {
		System.out.println(BaseClass.node.get(parentkey).get(key).asText());
        return BaseClass.node.get(parentkey).get(key).asText();
    }
	public static int jsonArrayValueInt(String parentkey, String key) {
	    JsonNode node = BaseClass.node.get(parentkey).get(key);
	    if (node != null && node.isInt()) {
	        int intValue = node.asInt();
	        System.out.println(intValue);
	        return intValue;
	    } else {
	        // Handle the case where the value is not found or not an integer.
	        // You can choose to return a default value or throw an exception here.
	        throw new IllegalArgumentException("Value not found or not an integer");
	    }
	}
	@BeforeClass(alwaysRun= true)
	public void beforeClass() throws IOException {
		node=UtilClass.readJson(System.getProperty("user.dir")+"\\src\\main\\resources\\JsonData\\Daddario.json");
	}
	@BeforeTest(alwaysRun= true)
	public void beforeTest() throws IOException  {
		report = new Sparkreport("Test","extent report", "ABC", "ABC");
		//new chagews in the bulid
	}
	
	@BeforeMethod(alwaysRun= true)
	@Parameters("browser")
	public void beforeMethod(@Optional("1") String browser) throws Exception {
		  int browserCode;
		    
		    try {
		        browserCode = Integer.parseInt(browser);
		    } catch (NumberFormatException e) {
		        throw new Exception("Invalid browser code");
		    }

		    switch (browserCode) {
		        case 1:
		            // Chrome
		            driver = chromeBrowser();
		            break;
		        case 2:
		            // Firefox
		            WebDriverManager.firefoxdriver().setup();
		            driver = new FirefoxDriver();
		            break;
		        case 3:
		            // Edge
		            WebDriverManager.edgedriver().setup();
		            driver = new EdgeDriver();
		            break;
		        default:
		            throw new Exception("Invalid browser code");
		    }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\Config\\Config.Properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.navigate().to(prop.getProperty("URL"));
		login = new LoginPage(driver);
		logout=new Logout(driver);
		createAccount=new CreateAccount(driver);
		loginCartAdd=new LoginAndAddProductIntoCart(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void closeWindow(ITestResult result) throws IOException, InterruptedException {
		  report.flush();
		  driver.close();
		  driver.quit();
	}

	

	@AfterClass(alwaysRun = true)
	public void logout() throws InterruptedException {
		login = null;
	}

	@AfterTest(alwaysRun= true)
	public void tearDown() throws InterruptedException {
//		driver.quit();
		System.gc();
	}

}
