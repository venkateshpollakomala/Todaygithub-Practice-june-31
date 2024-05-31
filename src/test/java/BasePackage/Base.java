package BasePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;

	public WebDriver InitializeBrowserAndOpenApplication(String browsername) {
		
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			// Create Edge browser options
	        EdgeOptions options = new EdgeOptions();
	     // Disable notifications
	        options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
		}
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
}