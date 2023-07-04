package org.testClass;

import baseClass.BaseClass;
import org.testng.annotations.Test;
import pageObject.ForeignExchangePage;
import pageObject.HomePage;

public class TestClass extends BaseClass {

    @Test(priority = 1)
    public static void TC1() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.setLanguageDropDown();
        hp.setUsaLanguage();
        hp.setForeignExchange();
    }
    @Test(priority = 2)
    public static void TC2() throws InterruptedException{
        ForeignExchangePage fep = new ForeignExchangePage(driver);
        fep.setSearchBox();
    }
}
