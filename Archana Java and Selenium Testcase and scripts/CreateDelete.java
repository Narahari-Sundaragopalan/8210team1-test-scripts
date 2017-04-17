package county;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateDelete {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Archana Raghu\\Desktop\\MSD\\chromedriver.exe");
	    driver = new ChromeDriver();
    
    baseUrl = "http://county-bedtracking-system.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateDelete() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("hbtsadmin@unomaha.edu");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("secret");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("Administration")).click();
    driver.findElement(By.linkText("Users")).click();
    driver.findElement(By.id("create-user")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("rohan");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("rrrrrrrr@unomaha.edu");
    driver.findElement(By.id("security_question1")).clear();
    driver.findElement(By.id("security_question1")).sendKeys("what is you favourite band ?");
    driver.findElement(By.id("security_answer1")).clear();
    driver.findElement(By.id("security_answer1")).sendKeys("bodom");
    driver.findElement(By.id("security_question2")).clear();
    driver.findElement(By.id("security_question2")).sendKeys("what is favourite tv show?");
    driver.findElement(By.id("security_answer2")).clear();
    driver.findElement(By.id("security_answer2")).sendKeys("friends");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("secret123");
    driver.findElement(By.name("password_confirmation")).clear();
    driver.findElement(By.name("password_confirmation")).sendKeys("secret123");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("Administration")).click();
    driver.findElement(By.linkText("Users")).click();
    driver.findElement(By.linkText("rohan")).click();
    driver.findElement(By.id("delete")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to delete[\\s\\S]$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

