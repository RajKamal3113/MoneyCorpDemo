package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    @BeforeTest
    public void browserLaunch() throws InterruptedException {
        //launching the browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://www.moneycorp.com/en-gb/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Browser Launched" + url);
        String expectedtitle = "Moneycorp | Global Payments";
        Assert.assertEquals(driver.getTitle(),expectedtitle);
        driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();

    }

    @AfterTest
    public void browserClose() {
        driver.close();
        System.out.println("Driver is closed");
    }
}
