package selenium.practice.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestRadioCheck
{
    String url;
    WebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        url = "http://demo.guru99.com/test/radio.html";
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
        // Checking the Radio Button!
        WebElement radioBtn1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radioBtn2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radioBtn3 = driver.findElement(By.id("vfb-7-3"));

        radioBtn2.click();
        Thread.sleep(5000);

        // Checking for the CheckBox!
        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));
        checkBox2.click();
        Thread.sleep(5000);


    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }


}
