package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FunctionalitiesPage {
    public FunctionalitiesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']")
    public WebElement logoutButton;
    @FindBy(xpath = "//h5[normalize-space()='Login in Book Store']")
    public WebElement text1;
    @FindBy(xpath = "//div[@class='o_loading']")
    public WebElement loading_Bar;
    @FindBy(xpath = "//input[@id='searchBox']")
    public WebElement searchArea;
    @FindBy(xpath = "//span[@id='basic-addon2']//span//*[name()='svg']")
    public WebElement searchButton;
    @FindBy(xpath = "//a[normalize-space()='Git Pocket Guide']")
    public WebElement text2;
    @FindBy(xpath = "//button[@id='gotoStore']")
    public WebElement GoToBookStoreButton;
    @FindBy(xpath = "//a[normalize-space()='Git Pocket Guide']")
    public WebElement choose1;
    @FindBy(xpath = "//div[@class='text-right fullButton']//button[@id='addNewRecordButton']")
    public WebElement addToYourCollection;
    @FindBy(xpath = "//div[@class='text-right fullButton']//button[@id='addNewRecordButton']")
    public WebElement profileSubModule;
    @FindBy(xpath = "//a[normalize-space()='Git Pocket Guide']")
    public WebElement text3;
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M864 256H7')]")
    public WebElement deleteIcon;
    //input[@value='1']



}
