package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //.declare private driver

    private WebDriver driver;
    private ElementUtil elementUtil;

    //2. page constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        elementUtil=new ElementUtil(driver);
    }

    //3.
    private By emailId = By.id("input-email");
    private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPwdLink = By.linkText("Forgotten Password");

    private By registerLink = By.linkText("Register");

    //4.page action

    public String getLoginPageTitle(){
        return elementUtil.waitForTitleContains(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
    }

    public String getLoginPageUrl(){
        return elementUtil.waitForUrl(Constants.DEFAULT_TIME_OUT,Constants.LOGIN_PAGE_URL_FRACTION);
    }

    public boolean isForgotPwdLinkExist(){
       return elementUtil.doIsDisplayed(forgotPwdLink);
    }

    public boolean isRegisterLinkExist(){
        return elementUtil.doIsDisplayed(forgotPwdLink);
    }

    public void doLogin(String un,String pwd){
        System.out.println("login with : "+un+" : "+pwd);
        elementUtil.doSendKeys(emailId,un);
        elementUtil.doSendKeys(password,pwd);
        elementUtil.doClick(loginBtn);
    }
}
