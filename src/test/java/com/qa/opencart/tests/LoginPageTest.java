package com.qa.opencart.tests;


import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String actTitle=loginPage.getLoginPageTitle();
        System.out.println("page title: "+actTitle);
        Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginPageUrlTest(){
        String actUrl = loginPage.getLoginPageUrl();
        Assert.assertEquals(actUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION), true);
    }

    @Test(priority = 3)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @Test(priority = 4)
    public void registerLinkExistTest() {
        Assert.assertTrue(loginPage.isRegisterLinkExist());
    }

    @Test(priority = 5)
    public void loginTest() {
        accountsPage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
        Assert.assertEquals(accountsPage.getAccountPageTitle(),Constants.ACCOUNT_PAGE_TITLE);
    }
}
