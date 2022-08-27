package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By header= By.cssSelector("div#logo a");
    private By accPageHeaders = By.cssSelector("div#content h2");
    private By searchField = By.name("search");
    private By searchIcon = By.cssSelector("div#search button");
    private By logoutLink = By.linkText("Logout");

    public AccountsPage(WebDriver driver){
        this.driver=driver;
        elementUtil=new ElementUtil(driver);
    }

    public String getAccountPageTitle(){
        return elementUtil.waitForTitleToBe(Constants.ACCOUNT_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
    }

    public String getAccountsPageHeader(){
        return elementUtil.doElementGetText(header);
    }

    public boolean isLogoutLinkExist(){
        return elementUtil.doIsDisplayed(logoutLink);
    }

    public void logout(){
        if(isLogoutLinkExist()){
            elementUtil.doClick(logoutLink);
        }
    }

    public List<String> getAccountSecList(){
        List<WebElement> accSecList=elementUtil.waitForElementsToBeVisible(accPageHeaders,10);
        List<String> accSecValList=new ArrayList<String>();

        for(WebElement e:accSecList){
            String text=e.getText();
            accSecValList.add(text);
        }

        return accSecValList;
    }

    public boolean isSearchList(){
        return elementUtil.doIsDisplayed(searchField);
    }

    public SearchResultPage doSearch(String productName){
        System.out.println("Searching the product: "+productName);
        elementUtil.doClear(searchField);
        elementUtil.doSendKeys(searchField,productName);
        elementUtil.doClick(searchIcon);
        return new SearchResultPage(driver);
    }



}
