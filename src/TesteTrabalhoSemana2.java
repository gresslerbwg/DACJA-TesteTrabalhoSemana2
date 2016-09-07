import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TesteTrabalhoSemana2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver","/home/gressler/Downloads/selenium-java-3.0.0-beta2/geckodriver");
	  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette", true);
	  driver = new FirefoxDriver(capabilities);
	  baseUrl = "http://localhost:8080/";
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
  }

  @Test
  public void testE1() throws Exception {
    driver.get(baseUrl + "/DACJA-TrabalhoSemana2/");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("box");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("A tradução da palavra \"box\" é \"caixa\".", driver.findElement(By.cssSelector("h1")).getText());
  }
  
  @Test
  public void testE2() throws Exception {
    driver.get(baseUrl + "/DACJA-TrabalhoSemana2/");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("lion");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("A tradução da palavra \"lion\" é \"leão\".", driver.findElement(By.cssSelector("h1")).getText());
  }
  
  @Test
  public void testE3() throws Exception {
    driver.get(baseUrl + "/DACJA-TrabalhoSemana2/");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("snake");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("A tradução da palavra \"snake\" é \"snake\".", driver.findElement(By.cssSelector("h1")).getText());
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
