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
    FunctionalitiesPage functionalitiesPage = new FunctionalitiesPage();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

    @When("user click logout Button")
    public void user_click_logout_button() {
        functionalitiesPage.logoutButton.click();
    }

    @When("user sees {string}")
    public void user_sees(String expected) {
        String actual = functionalitiesPage.text1.getText();
        Assert.assertEquals(expected, actual);
    }

    @When("user click Book Store Submodule")
    public void userClickBookStoreSubmodule() {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.bookStoreSubModule));
        BrowserUtils.scrollToElement(functionalitiesPage.bookStoreSubModule);
        functionalitiesPage.bookStoreSubModule.click();
    }

    @When("user types {string} on Search Name Area")
    public void user_types_on_search_name_area(String string) {
        try {
            wait.until(ExpectedConditions.visibilityOf(functionalitiesPage.searchArea));
            functionalitiesPage.searchArea.click();
            wait.until(ExpectedConditions.visibilityOf(functionalitiesPage.searchArea));
            functionalitiesPage.searchArea.sendKeys(string);
        } catch (TimeoutException t) {
        }

    }

    @When("user clicks Search Button")
    public void user_clicks_search_button() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.searchButton));
            functionalitiesPage.searchButton.click();
        } catch (TimeoutException t) {
        }
    }

    @Then("user does not see {string} on Title Area in Book Store Page")
    public void userDoesNotSeeOnTitleAreaInBookStorePage(String expected) {
        String actual = "";
        try {
            actual = functionalitiesPage.text2.getText();
        } catch (NoSuchElementException e) {
            actual = "";
        }
        Assert.assertNotEquals(expected, actual);
    }

    @Then("user sees {string} on Title Area in Book Store Page")
    public void user_sees_on_title_area_in_book_store_page(String expected) {
        String actual = "";
        try {
            actual = functionalitiesPage.text2.getText();
        } catch (NoSuchElementException e) {
            actual = "";
        }
        Assert.assertEquals(expected, actual);
    }

    @When("user clicks Go To Book Store Button")
    public void user_clicks_go_to_book_store_button() {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.GoToBookStoreButton));
        BrowserUtils.scrollToElement(functionalitiesPage.GoToBookStoreButton);
        functionalitiesPage.GoToBookStoreButton.click();
    }

    @When("user click {string} Book")
    public void user_click_book(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.choose1));
        functionalitiesPage.choose1.click();
    }

    @When("user click Add To Your Collection Button")
    public void user_click_add_to_your_collection_button() {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.addToYourCollection));
        BrowserUtils.scrollToElement(functionalitiesPage.addToYourCollection);
        functionalitiesPage.addToYourCollection.click();
    }

    @When("user sees {string} pop-up message1")
    public void user_sees_pop_up_message1(String string) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = getDriver().switchTo().alert();
        Thread.sleep(2000);
        String popupMessage = alert.getText();
        System.out.println("Popup Message: " + popupMessage);

    }

    @When("user click OK Button1")
    public void user_click_ok_button1() throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = getDriver().switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
    }

    @When("user click Profile SubModule Button")
    public void user_click_profile_sub_module_button() {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.profileSubModule));
        BrowserUtils.scrollToElement(functionalitiesPage.profileSubModule);
        functionalitiesPage.profileSubModule.click();
    }

    @Then("user sees {string} on Title Area in Profile Page")
    public void user_sees_on_title_area_in_profile_page(String expected) {
        String actual = functionalitiesPage.text3.getText();
        Assert.assertEquals(expected, actual);
    }

    @When("user clicks Delete Icon")
    public void user_clicks_delete_icon() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.deleteIcon));
            functionalitiesPage.deleteIcon.click();
        } catch (TimeoutException t) {
            System.out.println("There is no book to delete!!!");

        }
    }

    @When("user sees {string} pop-up message2")
    public void user_sees_pop_up_message2(String string) {
        try {
            System.out.println("Delete Message: " + functionalitiesPage.deleteText.getText());
        } catch (NoSuchElementException n) {
        }
    }

    @When("user click OK Button2")
    public void user_click_ok_button2() {
        try {
            Thread.sleep(1000);
            functionalitiesPage.deleteOK.click();
        } catch (NoSuchElementException n) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user sees {string} pop-up message3")
    public void userSeesPopUpMessage(String arg0) throws InterruptedException {
        try {
            Thread.sleep(2000);
            Alert alert = getDriver().switchTo().alert();
            Thread.sleep(2000);
            String popupMessage = alert.getText();
            System.out.println("Popup Message: " + popupMessage);
        } catch (NoAlertPresentException a) {
        }
    }

    @And("user click OK Button3")
    public void userClickOKButton() throws InterruptedException {
        try {
            Thread.sleep(2000);
            Alert alert = getDriver().switchTo().alert();
            Thread.sleep(2000);
            alert.accept();
        } catch (NoAlertPresentException a) {
        }
    }


    @When("user clicks Rows More Button")
    public void user_clicks_rows_more_button() {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.rowMoreButton));
        BrowserUtils.scrollToElement(functionalitiesPage.rowMoreButton);
        functionalitiesPage.rowMoreButton.click();
    }

    @When("user click {string}")
    public void user_click(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.rowMoreButton10));
        BrowserUtils.scrollToElement(functionalitiesPage.rowMoreButton10);
        functionalitiesPage.rowMoreButton10.click();
    }

    @Then("user sees {string} on the row number area")
    public void user_sees_on_the_row_number_area(String expected) {
        wait.until(ExpectedConditions.elementToBeClickable(functionalitiesPage.text4));
        BrowserUtils.scrollToElement(functionalitiesPage.text4);
        String actual = functionalitiesPage.text4.getText();
        Assert.assertEquals(expected, actual);
    }


}