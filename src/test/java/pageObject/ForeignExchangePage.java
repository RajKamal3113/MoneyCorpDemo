package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForeignExchangePage {
    WebDriver driver;
    @FindBys({
            @FindBy(xpath = "//a[@class='title u-m-b2']")
    })
    public List<WebElement> articleLink;
    public ForeignExchangePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    By searchBox = By.xpath("//div[@class='u-flex u-flex-align-center u-flex-justify-end']//div/form/input[1]");
    By searchIcon = By.xpath("//div[@class='u-flex u-flex-align-center u-flex-justify-end']//div/form/input[2]");

    public void setSearchBox() {
        //To search with string "international payments"
        String foreignExchangeUrl = captureUrl();
        if (foreignExchangeUrl.equalsIgnoreCase("https://www.moneycorp.com/en-us/business/foreign-exchange-solutions/")) {
            driver.findElement(searchBox).click();
            driver.findElement(searchBox).sendKeys("international payments");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
            driver.findElement(searchIcon).click();
            System.out.println("Clicked on Search box");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        }
        String searchUrl = captureUrl();
        if (searchUrl.equalsIgnoreCase("https://www.moneycorp.com/en-us/search/?q=international+payments")) {
            for (int i = 0; i < articleLink.size(); i++) {
                String linksOfArticle = articleLink.get(i).getAttribute("href");
                System.out.println("Links of Articles" + " " + (i+1) + "  " + linksOfArticle);
                if (linksOfArticle.startsWith("https://www.moneycorp.com/en-us/"))
                    System.out.println("Article consist of required link");
                else
                    System.out.println("Article does not consist of required link");
            }
        }
    }

    public String captureUrl() {
        //To validate the
        String validateResult = driver.getCurrentUrl();
        System.out.println("VALIDATE PAGE :: " + validateResult);
        return validateResult;
    }

}
