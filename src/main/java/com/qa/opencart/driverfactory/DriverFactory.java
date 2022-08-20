package com.qa.opencart.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;
    public Properties prop;

    /**
     * This method is used to initialize the webdriver
     * @param browserName
     * @return this will the driver
     */

    public WebDriver init_driver(Properties prop){
        String browserName= prop.getProperty("browser").trim();

        System.out.println("Browser name is: "+browserName);

        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }

        else if(browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }

        else if(browserName.equals("safari")){
            WebDriverManager.safaridriver().setup();
            driver=new SafariDriver();
        }

        else{
            System.out.println("Please pass the right browser"+browserName);
        }

        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

        return driver;

    }

    /**
     * This method is used initialize the properties
     * @return
     * this will return properties prop reference
     */
    public Properties init_prop()  {
        prop=new Properties();
        try {
            FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
