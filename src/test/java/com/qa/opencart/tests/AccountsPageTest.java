package com.qa.opencart.tests;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accountPageSetup(){
        accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void accPageTitleTest(){
        String actTitle = accountsPage.getAccountPageTitle();
        System.out.println("acc page title: "+actTitle);
        Assert.assertEquals(actTitle, Constants.ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void accPageHeaderTest(){
        String header=accountsPage.getAccountsPageHeader();
        System.out.println("acc page header is: "+header);
        Assert.assertEquals(header,Constants.ACCOUNT_PAGE_HEADER);
    }

    @Test(priority = 3)
    public void isLogoutExistList(){
        Assert.assertTrue(accountsPage.isLogoutLinkExist());
    }

    @Test(priority = 4)
    public void accSectionsTest(){
        List<String> accountSecList =accountsPage.getAccountSecList();
        Assert.assertEquals(accountSecList,Constants.getExpectedAccSectList());
    }

    @DataProvider
    public Object[][] productData(){
        return new Object[][]{
                {"MacBook Pro"},
                {"Apple"},
                {"Samsung"},
        };
    }

    @Test(priority = 5, dataProvider = "productData")
    public void searchTest(String productName){
        accountsPage.doSearch(productName);
    }

}
