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

}
