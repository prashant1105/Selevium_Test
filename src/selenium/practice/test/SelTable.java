package selenium.practice.test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelTable
{
    String url;
    WebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        url = "https://www.seleniumeasy.com/test/table-search-filter-demo.html";
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
        // Get to the Web Page with the Table!

        // Fetch the Table and store it using the WebElement reference variable!
        WebElement tableDet = driver.findElement(By.id("task-table"));
        // Fetching all the rows inside the table using the <tr> tag and storing it in a list.
        List<WebElement> rows = tableDet.findElements(By.tagName("tr"));

        // Iterating over all the rows in the table!
        for(WebElement row : rows)
        {
            // Finding all the columns inside a particular row by using the <td> tag name!
            List<WebElement> cols = tableDet.findElements(By.tagName("td"));

            // Iterating over all the columns inside the particular row!
            for(WebElement col : cols)
            {
                System.out.println("Column Value: " +col.getText());
            }
        }




    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }

}
