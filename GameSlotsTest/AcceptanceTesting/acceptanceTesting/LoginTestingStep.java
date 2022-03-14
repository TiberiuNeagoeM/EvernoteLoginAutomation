package acceptanceTesting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class LoginTestingStep {

    public static WebDriver driver;
    static String baseurl = LoginTestingPage.URL;
//    public static String sessionId;
//    public static String sessionId;

    @Test
    public static void AuthotisedLogin() throws InterruptedException {
	driver.navigate().to(LoginTestingPage.URL);
	Login();
	TimeUnit.SECONDS.sleep(1);
    }

    public static void Login() throws InterruptedException {
	log("Click on the login button");
	driver.findElement(By.cssSelector(LoginTestingPage.loginHeaderButton)).click();
	log("Enter credentials");
	driver.findElement(By.cssSelector(LoginTestingPage.emailAdreesField)).sendKeys(LoginTestingPage.email);
	TimeUnit.SECONDS.sleep(3);
	try {
	WaitForElementVisible(LoginTestingPage.loginButton);
	driver.findElement(By.cssSelector(LoginTestingPage.loginButton)).click();
	TimeUnit.SECONDS.sleep(3);
	WaitForElementVisible(LoginTestingPage.passwordField);
	driver.findElement(By.cssSelector(LoginTestingPage.passwordField)).sendKeys(LoginTestingPage.Pass);
	WaitForElementVisible(LoginTestingPage.loginButton);
	driver.findElement(By.cssSelector(LoginTestingPage.loginButton)).click();
	} catch(Exception e) {
	    WaitForElementVisible(LoginTestingPage.loginButton);
		driver.findElement(By.cssSelector(LoginTestingPage.loginButton)).click();
		TimeUnit.SECONDS.sleep(3);
		WaitForElementVisible(LoginTestingPage.passwordField);
		driver.findElement(By.cssSelector(LoginTestingPage.passwordField)).sendKeys(LoginTestingPage.Pass);
		WaitForElementVisible(LoginTestingPage.loginButton);
		driver.findElement(By.cssSelector(LoginTestingPage.loginButton)).click();
	}
	log("Sucessful login");
	TimeUnit.SECONDS.sleep(1);
    }

    public static void LogOut() throws InterruptedException {
	driver.navigate().back();
	TimeUnit.SECONDS.sleep(2);
	log("Navigate to initial page");
	driver.findElement(By.xpath(LoginTestingPage.accountDropdownButton)).click();
	log("Click on the logout button");
	driver.findElement(By.xpath(LoginTestingPage.logoutButton)).click();
    }

    public static void MoveToTrash() throws InterruptedException {
	TimeUnit.SECONDS.sleep(2);
	log("Click on More button");
	driver.findElement(By.xpath(LoginTestingPage.moreButton)).click();
	log("Click on Move to trash");
	driver.findElement(By.xpath(LoginTestingPage.moveToTrash)).click();
    }

    @SuppressWarnings("deprecation")
    @BeforeTest
    public static void OpenBrowser(String baseurl) {
	ChromeDriverManager chromeDriverManager = new ChromeDriverManager();
	log("Initalizing ChromeDriver");
	chromeDriverManager.setup();
	log("Chrome Driver successfully initialized");
	driver = new ChromeDriver();
	log("Maximize Chrome window");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	log("Get to the diserved page");
	driver.get(baseurl);
    }

    public static void OpenNote() throws InterruptedException {
	WriteANote();
	log("Refresh the page");
	driver.navigate().refresh();
	log("Start login session");
	Login();
	TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public static void UnauthotisedLogin() throws InterruptedException {
	log("Get to the desired page");
	OpenBrowser(LoginTestingPage.URL);
	log("Click on login Button");
	driver.findElement(By.cssSelector(LoginTestingPage.loginHeaderButton)).click();
	log("Enter unauthorized credentials");
	driver.findElement(By.cssSelector(LoginTestingPage.emailAdreesField)).sendKeys(LoginTestingPage.email);
	WaitForElementVisible(LoginTestingPage.continueButton);
	driver.findElement(By.cssSelector(LoginTestingPage.loginButton)).click();
	TimeUnit.SECONDS.sleep(3);
	log("Enter unothrized password");
	WaitForElementVisible(LoginTestingPage.passwordField);
	driver.findElement(By.cssSelector(LoginTestingPage.passwordField)).sendKeys(LoginTestingPage.wrongPass);
	WaitForElementVisible(LoginTestingPage.loginButton);
	log("Click on login button");
	driver.findElement(By.cssSelector(LoginTestingPage.loginButton)).click();
	log("Wait to see the error message");
	WaitForElementVisible(LoginTestingPage.loginErrorMessage);
	TimeUnit.SECONDS.sleep(1);
    }

    public static void WaitForElementVisible(String option) {
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(option)));
    }

    // @Test
    public static void WriteANote() throws InterruptedException {
	log("Start creating new note session");
	WaitForElementVisible(LoginTestingPage.createNewNote);
	driver.findElement(By.cssSelector(LoginTestingPage.createNewNote)).click();
	log("Switch to iFrame *This process take up to 30 seconds*");
	driver.switchTo().frame(LoginTestingPage.iFrameLocator);
	log("Sucessfully switched to iFrame");
	driver.findElement(By.xpath(LoginTestingPage.messageTitle)).click();
	log("Click on title field");
	driver.findElement(By.xpath(LoginTestingPage.messageTitle)).sendKeys(LoginTestingPage.titleText);
	log("Get the actual date");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	Date date = new Date(System.currentTimeMillis());
	log("Print the date");
	System.out.println(formatter.format(date));
	driver.findElement(By.xpath(LoginTestingPage.messageBody)).click();
	log("Enter text message followed by the date");
	driver.findElement(By.xpath(LoginTestingPage.messageBody)).sendKeys(LoginTestingPage.messageText + "\n"
		+ " In order to verify that this the last note," + " here is the datetime " + date);

	TimeUnit.SECONDS.sleep(2);
	log("Start loging out session");
	LogOut();
	TimeUnit.SECONDS.sleep(2);

	log("Refresh the page");
	driver.navigate().refresh();
	log("Start loggin session");
	Login();
	log("Click on the first created note");
	String articleLocator = "(//div[@id='qa-HOME_NOTE_WIDGET_NOTE_LIST_2|0_0|0_3DJUU3|13'])[1]";
	driver.findElement(By.xpath(articleLocator)).click();
	TimeUnit.SECONDS.sleep(2);
    }
    
    public static void log(String logText) {
	System.out.println(logText);
    }
}