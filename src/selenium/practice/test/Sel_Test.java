package selenium.practice.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sel_Test
{
    String url1;
    String url2;
    WebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        url1 = "https://www.youtube.com/";
        url2 = "https://zoom.us/";
        System.setProperty("webdriver.chrome.driver", "/home/prashant_pk/IdeaProjects/Selevium_Test/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Opening the Web Apps!
        driver.manage().window().maximize();
//        driver.get(url1);
        driver.get(url2);
        System.out.println("The Title of the page is: " +driver.getTitle());

    }

    @org.junit.Test
    public void linkTest() throws Exception
    {
        // Using the ID Locator to locate a part of the Web Page! (FirstPreference)
        // Sending some value to the Website Search!
//        driver.findElement(By.id("search")).sendKeys("Python Programming");
        // For clicking on the Search button!
//        driver.findElement(By.id("search-icon-legacy")).click();
//        Thread.sleep(3000);

        // Using the Name Locator to locate a part of the Web Page!
//        driver.findElement(By.name("search_query")).sendKeys("Selenium Web Drivers");
//        driver.findElement(By.id("search-icon-legacy")).click();
//        Thread.sleep(3000);

        // Using the Link Tag Locator to locate a part of the Web Page!
//        driver.findElement(By.linkText("Plans & Pricing")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.linkText("Zoom for Education")).click();
//        Thread.sleep(2000);

        // Using the CSS Selector Locator to locate a part of the Web Page!
//        driver.findElement(By.cssSelector("#btnJoinMeeting")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li:nth-child(9) > a")).click();
//        Thread.sleep(2000);

        // Using the XPath (XML Doc) Locator to locate a part of the Web Page! (Second Preference)
        driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("digida3678@naymeo.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("HiItsWrongPass");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        Thread.sleep(2000);

    }

    @After
    public void tearDown() throws Exception
    {
        driver.close();
    }



}
