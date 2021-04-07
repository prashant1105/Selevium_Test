package selenium.practice.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo_Register
{
    String url1;
    WebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        url1 = "https://phptravels.com/";
        System.setProperty("webdriver.chrome.driver", "/home/prashant_pk/IdeaProjects/Selevium_Test/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Opening the Web Apps!
        driver.manage().window().maximize();
        driver.get(url1);
        Thread.sleep(2000);
        System.out.println("The Title of the page is: " +driver.getTitle());
    }

    @org.junit.Test
    public void linkTest() throws Exception
    {
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(2000);
        // Using Multiple Windows!
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Title of New Page is: " +driver.getTitle());
        // Getting the different Window Handles opened!
        Set<String> windHandles = driver.getWindowHandles();
        // Iterating through the Window Handles!
        Iterator<String> it_wind = windHandles.iterator();
        String homePage = it_wind.next().toString();
        String regPage = it_wind.next().toString();
        driver.switchTo().window(regPage);

        // Going through the contents of Register Web page!
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("inputFirstName")).sendKeys("Demo");
        Thread.sleep(1000);
        driver.findElement(By.id("inputLastName")).sendKeys("Account");
        Thread.sleep(1000);
        driver.findElement(By.id("inputEmail")).sendKeys("digida3678@naymeo.com");
        Thread.sleep(1000);
        driver.findElement(By.id("inputPhone")).sendKeys("9876543210");
        Thread.sleep(1000);
        driver.findElement(By.id("inputCompanyName")).sendKeys("Selenium Demo");
        Thread.sleep(1000);
        driver.findElement(By.id("inputAddress1")).sendKeys("Street 02");
        Thread.sleep(1000);
        driver.findElement(By.id("inputAddress2")).sendKeys("Harmo Road");
        Thread.sleep(1000);
        driver.findElement(By.id("inputCity")).sendKeys("Patna");
        Thread.sleep(1000);
        driver.findElement(By.id("stateinput")).sendKeys("Bihar");
        Thread.sleep(1000);
        driver.findElement(By.id("inputPostcode")).sendKeys("800002");
        Thread.sleep(1000);
        driver.findElement(By.id("inputCountry")).sendKeys("India");
        Thread.sleep(1000);
        driver.findElement(By.id("customfield1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("customfield2")).sendKeys("9876543210");
        Thread.sleep(1000);
        driver.findElement(By.id("inputNewPassword1")).sendKeys("ItsWrongOne");
        Thread.sleep(1000);
        driver.findElement(By.id("inputNewPassword2")).sendKeys("ItsWrongOne");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"frmCheckout\"]/p/input")).click();
        Thread.sleep(4000);

        // Going back to the Login Page o the Web site!
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("digida3678@naymeo.com");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("ItsWrongOne");
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(4000);

    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }


}
