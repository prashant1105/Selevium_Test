package selenium.practice.test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FBCreateAcc
{
    String url;
    WebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        url = "https://www.facebook.com/login.php";
        System.setProperty("webdriver.chrome.driver", "/home/prashant_pk/IdeaProjects/Selevium_Test/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Title of the Web Page is: " +driver.getTitle());
    }

    @Test
    public void linkTest() throws Exception
    {
        String act_page_title = "Log in to Facebook";
        String exp_page_title = driver.getTitle();
        driver.findElement(By.linkText("Sign up for Facebook")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Demo");
        Thread.sleep(1000);
        driver.findElement(By.name("lastname")).sendKeys("Account");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_email__")).sendKeys("notactualmail@orkut.com");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("notactualmail@orkut.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password_step_input")).sendKeys("ItsWrongDuh123");
        Thread.sleep(1000);

        // Selecting the data from a Drop Down List!
        // Step 01: Selecting the CheckBox!
        Select dropDay = new Select(driver.findElement(By.id("day")));
        // Step 02: Selecting from the Available values using Visible Text!
        dropDay.selectByValue("20");
        Thread.sleep(1000);

        Select dropMon = new Select(driver.findElement(By.id("month")));
        dropMon.selectByValue("10");
        Thread.sleep(1000);

        Select dropYear = new Select(driver.findElement(By.id("year")));
        dropYear.selectByValue("1973");
        Thread.sleep(1000);

        // Checking the Radio Button!
        //WebElement radioBtn1 = driver.findElement(By.xpath("//*[@id=\"u_0_4_72\"]"));
//        WebElement radioBtn2 = driver.findElement(By.linkText("Male"));
//        //WebElement radioBtn3 = driver.findElement(By.id("u_0_6_rx"));
//
//        radioBtn2.click();
//        Thread.sleep(1000);
        // Selecting Radio Button not working!

        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(1000);

        Assert.assertEquals(act_page_title, exp_page_title);

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Using the FileUtils class, we can copy the generated screenshot file to any location!
        FileUtils.copyFile(scrFile, new File("/home/prashant_pk/Music/Screenshot.png"));
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }


}
