package Pkg.Utiltiy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class PojoClass {

	public static WebDriver fireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
}
