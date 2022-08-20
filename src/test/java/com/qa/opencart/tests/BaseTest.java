package com.qa.opencart.tests;

import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    DriverFactory df;
    Properties prop;
    WebDriver driver;
    LoginPage loginPage;



    @BeforeTest
    public void setup(){
        df=new DriverFactory();
        prop=df.init_prop();
        driver=df.init_driver(prop);
        loginPage=new LoginPage(driver);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
