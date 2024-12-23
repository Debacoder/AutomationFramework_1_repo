package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extReports;
	public static ExtentTest test;
	public FileUtility flib= new FileUtility();
	public JavaUtility jlib= new JavaUtility();
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;

	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/"+jlib.getSystemTime()+".html");
		extReports=new ExtentReports();
		extReports.attachReporter(spark);
	}

	@Parameters("Browser")
	@BeforeClass
	public void launcBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(flib.getDataFromProperty("url"));
	}

	@BeforeMethod
	public void login() throws IOException {
		wp =new WelcomePage(driver);
		wp.getLogInlink().click();
		lp= new LoginPage(driver);
		lp.getEmailTextField().sendKeys(flib.getDataFromProperty("email"));
		lp.getPasswordLink().sendKeys(flib.getDataFromProperty("pass"));
		lp.getLoginButton().click();

	}



	@AfterMethod
	public void logout() {
		hp= new HomePage(driver);
		hp.getLogOutLink().click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void reportBackup() {
		extReports.flush();
	}
}


