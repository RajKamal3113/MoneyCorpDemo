package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;


    }

    By languageDropDown = By.xpath("//*[@id=\"language-dropdown\"]");
    By usaLanguage = By.xpath(".//a[@aria-label='USA English']");

    By foreignExchange = By.xpath("//h3[contains(text(),'Foreign exchange solutions')]//parent::div//a//span");

    public void setLanguageDropDown(){
        //To find the language dropdown
        driver.findElement(languageDropDown).click();
        System.out.println("Language dropdown is clicked");
    }

    public void setUsaLanguage() {
        //To change the language to US
        driver.findElement(usaLanguage).click();
        System.out.println("US English language is selected");
    }

    public void setForeignExchange() {
        //To click on find out more button under foreign solution exchange
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(foreignExchange));
        System.out.println("Navigated foreign solution exchange page successfully");
        String foreignExpTitle = "Foreign Exchange Solutions | moneycorp USA";
        Assert.assertEquals(driver.getTitle(),foreignExpTitle);
    }

}
