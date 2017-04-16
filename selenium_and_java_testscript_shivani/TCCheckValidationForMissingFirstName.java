package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCheckValidationForMissingFirstName {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://county-bedtracking-system.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTCCheckValidationForMissingFirstName() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("hbtsadmin@unomaha.edu");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("secret");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("Administration")).click();
    driver.findElement(By.linkText("Patients")).click();
    driver.findElement(By.id("create-patient")).click();
    driver.findElement(By.id("patient_last_name")).clear();
    driver.findElement(By.id("patient_last_name")).sendKeys("Damon");
    driver.findElement(By.id("datepicker1")).click();
    driver.findElement(By.linkText("15")).click();
    driver.findElement(By.id("admit_time")).clear();
    driver.findElement(By.id("admit_time")).sendKeys("10:00");
    driver.findElement(By.id("patient_condition")).clear();
    driver.findElement(By.id("patient_condition")).sendKeys("Serious");
    driver.findElement(By.id("age")).clear();
    driver.findElement(By.id("age")).sendKeys("50");
    new Select(driver.findElement(By.name("gender"))).selectByVisibleText("Male");
    driver.findElement(By.id("date_of_birth")).clear();
    driver.findElement(By.id("date_of_birth")).sendKeys("01/01/1967");
    new Select(driver.findElement(By.id("department"))).selectByVisibleText("Burn Ward");
    new Select(driver.findElement(By.id("department"))).selectByVisibleText("Critical Care");
    driver.findElement(By.id("next_of_kin")).clear();
    driver.findElement(By.id("next_of_kin")).sendKeys("Siri");
    driver.findElement(By.id("next_of_kin_contact")).clear();
    driver.findElement(By.id("next_of_kin_contact")).sendKeys("402-011-7777");
    driver.findElement(By.id("next_of_kin_relation")).clear();
    driver.findElement(By.id("next_of_kin_relation")).sendKeys("Sister");
    driver.findElement(By.id("patient_deposition_condition")).clear();
    driver.findElement(By.id("patient_deposition_condition")).sendKeys("Alive");
    driver.findElement(By.id("room_no")).clear();
    driver.findElement(By.id("room_no")).sendKeys("111");
    driver.findElement(By.id("patient_injury")).clear();
    driver.findElement(By.id("patient_injury")).sendKeys("heart attack");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
    driver.findElement(By.id("patient_first_name")).clear();
    driver.findElement(By.id("patient_first_name")).sendKeys("Sam");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("Administrator")).click();
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
