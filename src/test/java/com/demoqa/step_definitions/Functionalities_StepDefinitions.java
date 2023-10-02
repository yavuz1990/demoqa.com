package com.demoqa.step_definitions;

import com.demoqa.pages.FunctionalitiesPage;
import com.demoqa.utilities.BrowserUtils;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static com.demoqa.utilities.Driver.getDriver;

public class Functionalities_StepDefinitions {
    FunctionalitiesPage functionalitiesPage=new FunctionalitiesPage();
    WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    int totalNumber;
    @When("user click logout Button")
    public void user_click_logout_button() {
        functionalitiesPage.logoutButton.click();
    }
    @When("user sees {string}")
    public void user_sees(String expected) {
        String actual=functionalitiesPage.text1.getText();
        Assert.assertEquals(expected,actual);
    }
    @When("user click Book Store Submodule")
    public void userClickBookStoreSubmodule() {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.bookStoreSubModule));
        BrowserUtils.scrollToElement(functionalitiesPage.bookStoreSubModule);
        functionalitiesPage.bookStoreSubModule.click();
    }
    @When("user types {string} on Search Name Area")
    public void user_types_on_search_name_area(String string) {
        try{
            wait.until(ExpectedConditions.visibilityOf(functionalitiesPage.searchArea));
            functionalitiesPage.searchArea.click();
            wait.until(ExpectedConditions.visibilityOf(functionalitiesPage.searchArea));
            functionalitiesPage.searchArea.sendKeys(string); }
        catch (TimeoutException t){}

    }
    @When("user clicks Search Button")
    public void user_clicks_search_button() {
        //Thread.sleep(5000);
        try{
            wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.searchButton));
            functionalitiesPage.searchButton.click();}
        catch (TimeoutException t){}
    }
    @Then("user does not see {string} on Title Area in Book Store Page")
    public void userDoesNotSeeOnTitleAreaInBookStorePage(String expected) {
        String actual ="";
        try{
            actual=functionalitiesPage.text2.getText();
        }
        catch (NoSuchElementException e) {
            actual = "";
        }
        //String actual=functionalitiesPage.text2.getText();
        Assert.assertNotEquals(expected,actual);
    }
    @Then("user sees {string} on Title Area in Book Store Page")
    public void user_sees_on_title_area_in_book_store_page(String expected) {
        String actual=functionalitiesPage.text2.getText();
        Assert.assertEquals(expected,actual);
    }

    @When("user clicks Go To Book Store Button")
    public void user_clicks_go_to_book_store_button() {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.GoToBookStoreButton));
        BrowserUtils.scrollToElement(functionalitiesPage.GoToBookStoreButton);
        functionalitiesPage.GoToBookStoreButton.click();
    }
    @When("user click {string} Book")
    public void user_click_book(String string) {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.choose1));
        functionalitiesPage.choose1.click();
    }
    @When("user click Add To Your Collection Button")
    public void user_click_add_to_your_collection_button() {
        //Roll down
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.addToYourCollection));
        BrowserUtils.scrollToElement(functionalitiesPage.addToYourCollection);
        functionalitiesPage.addToYourCollection.click();
    }
    @When("user sees {string} pop-up message1")
    public void user_sees_pop_up_message1(String string) throws InterruptedException {
        Thread.sleep(2000);//wait ile değiştir
        Alert alert = getDriver().switchTo().alert();
        Thread.sleep(2000);//wait ile değiştir
        String popupMessage = alert.getText();
        System.out.println("Popup Message: " + popupMessage);

    }
    @When("user click OK Button1")
    public void user_click_ok_button1() throws InterruptedException {
        Thread.sleep(2000);//wait ile değiştir
        Alert alert = getDriver().switchTo().alert();
        Thread.sleep(2000);//wait ile değiştir
        alert.accept();
    }
    @When("user click Profile SubModule Button")
    public void user_click_profile_sub_module_button() {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.profileSubModule));
        BrowserUtils.scrollToElement(functionalitiesPage.profileSubModule);
        functionalitiesPage.profileSubModule.click();
    }
    @Then("user sees {string} on Title Area in Profile Page")
    public void user_sees_on_title_area_in_profile_page(String expected) {
        String actual=functionalitiesPage.text3.getText();
        Assert.assertEquals(expected,actual);
    }

    @When("user clicks Delete Icon")
    public void user_clicks_delete_icon() {

        try{
            wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.deleteIcon));
            functionalitiesPage.deleteIcon.click();
        }
        catch (TimeoutException t){
            System.out.println("Silinecek Kitap Yok!!!");

        }
    }
    @When("user sees {string} pop-up message2")
    public void user_sees_pop_up_message2(String string) throws InterruptedException {
        try{
            Thread.sleep(1000);//wait ile değiştir
            System.out.println("Delete Message: " + functionalitiesPage.deleteText.getText());
        }
        catch(NoSuchElementException n){}
    }
    @When("user click OK Button2")
    public void user_click_ok_button2() throws InterruptedException {
        try{
            Thread.sleep(1000);//wait ile değiştir
            functionalitiesPage.deleteOK.click();
        }
        catch(NoSuchElementException n){}
    }
    @And("user sees {string} pop-up message3")
    public void userSeesPopUpMessage(String arg0) throws InterruptedException {
        try{
            Thread.sleep(2000);//wait ile değiştir
            Alert alert = getDriver().switchTo().alert();
            Thread.sleep(2000);//wait ile değiştir
            String popupMessage = alert.getText();
            System.out.println("Popup Message: " + popupMessage);}
        catch (NoAlertPresentException a){}
    }
    @And("user click OK Button3")
    public void userClickOKButton() throws InterruptedException {
        try{
            Thread.sleep(2000);//wait ile değiştir
            Alert alert = getDriver().switchTo().alert();
            Thread.sleep(2000);//wait ile değiştir
            alert.accept();
        }
        catch (NoAlertPresentException a){}
    }
    @Then("user sees that the book was deleted")
    public void user_sees_that_the_book_was_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks Rows More Button")
    public void user_clicks_rows_more_button() {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.rowMoreButton));
        BrowserUtils.scrollToElement(functionalitiesPage.rowMoreButton);
        functionalitiesPage.rowMoreButton.click();
    }
    @When("user click {string}")
    public void user_click(String string) {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.rowMoreButton10));
        BrowserUtils.scrollToElement(functionalitiesPage.rowMoreButton10);
        functionalitiesPage.rowMoreButton10.click();
    }
    @Then("user sees {string} on the row number area")
    public void user_sees_on_the_row_number_area(String expected) {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.text4));
        BrowserUtils.scrollToElement(functionalitiesPage.text4);
        String actual=functionalitiesPage.text4.getText();
        Assert.assertEquals(expected,actual);
    }



}