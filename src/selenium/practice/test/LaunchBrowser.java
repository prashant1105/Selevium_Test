package selenium.practice.test;

import com.sun.source.tree.PackageTree;
import jdk.jfr.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LaunchBrowser {
    public static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.youtube.com/";
        System.setProperty("webdriver.chrome.driver", "/home/prashant_pk/IdeaProjects/Selevium_Test/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Opening the Web Apps!
        driver.manage().window().maximize();
        driver.navigate().to(url);
        String title = driver.getTitle();

//        if(title.equalsIgnoreCase("Youtube"))
//            System.out.println("Title Mismatch");
//        else
//            System.out.println(title);
        System.out.println(title);

        // Locating a Web Element!
        String tag_name = "";
        tag_name = driver.findElement(By.cssSelector("#container")).getText();
        System.out.println(tag_name);

//        WebElement myBlog = driver.findElement(By.cssSelector("body > header > nav > ul > li:nth-child(3) > a"));
//        Actions action = new Actions(driver);
//        action.moveToElement(myBlog);
//        action.click();



        // Selecting from a Dropdown!
        WebElement category = driver.findElement(By.cssSelector("#endpoint"));
        Actions action = new Actions(driver);
        action.moveToElement(category).click();
        Thread.sleep(2000);
//
//        WebElement data = driver.findElement(By.cssSelector("#test-menu-left > div.slider > ul > li:nth-child(1) > ul > li:nth-child(6) > a"));
//        action.moveToElement(data);
//        action.click();
//        action.perform();
//        Thread.sleep(3000);
//
//        WebElement ml_train = driver.findElement(By.linkText("Machine Learning Certification Training"));
//        action.moveToElement(ml_train);
//        action.click();
//        action.perform();
//        Thread.sleep(5000);








    }

}
