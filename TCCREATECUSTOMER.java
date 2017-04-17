package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCREATECUSTOMER {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://efs-8210-hari.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTCCREATECUSTOMER() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Go to Home Page")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("nsundaragopalan@unomaha.edu");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("secret");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("Customers")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
    driver.findElement(By.linkText("Create Customer")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Rahul Dravid");
    driver.findElement(By.id("cust_number")).clear();
    driver.findElement(By.id("cust_number")).sendKeys("32476");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("7122 Jones Cir. Apt No 7");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Omaha");
    driver.findElement(By.id("state")).clear();
    driver.findElement(By.id("state")).sendKeys("Nebraska");
    driver.findElement(By.id("zip")).clear();
    driver.findElement(By.id("zip")).sendKeys("68106");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("rdravid@gmail.com");
    driver.findElement(By.id("home_phone")).clear();
    driver.findElement(By.id("home_phone")).sendKeys("4025946806");
    driver.findElement(By.id("cell_phone")).clear();
    driver.findElement(By.id("cell_phone")).sendKeys("4025946807");
    driver.findElement(By.xpath("//input[@value='Save']")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
    driver.findElement(By.xpath("(//a[contains(text(),'Update')])[4]")).click();
    driver.findElement(By.id("cell_phone")).clear();
    driver.findElement(By.id("cell_phone")).sendKeys("4025946809");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("7122 Jones Cir. Apt No 11");
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    driver.findElement(By.xpath("(//input[@value='Delete'])[4]")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    driver.findElement(By.linkText("Narahari S")).click();
    driver.findElement(By.linkText("Logout")).click();
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
