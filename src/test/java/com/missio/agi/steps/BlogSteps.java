package com.missio.agi.steps;



import com.missio.agi.core.DriverFactory;
import com.missio.agi.pages.BlogHomePage;
import com.missio.agi.pages.BlogResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlogSteps {
    private WebDriver driver;
    private BlogHomePage homePage;
    private BlogResultsPage searchResultsPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new BlogHomePage(driver);
        searchResultsPage = new BlogResultsPage(driver);
    }

    @After(order = 1)
    public void screenshot(Scenario scenario) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenchot/"+scenario.getId()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After(order = 0)
    public void tearDown() {
        DriverFactory.killDriver();
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        homePage.open();
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        homePage.clickSearchButton();
    }

    @When("I enter {string} in the search field")
    public void i_enter_in_the_search_field(String term) {
        homePage.enterSearchTerm(term);
    }

    @When("press enter in the search field")
    public void press_enter_in_the_search_field() {
        homePage.pressEnterInSearchField();
        try {
            Thread.sleep(500); // Espera de 0.5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the search results page should display a list of specific results")
    public void the_search_results_page_should_display_a_list_of_specific_results() {
        assertEquals("Resultados encontrados para:", searchResultsPage.getSearchResults());
    }

    @Then("the search results page should be displayed")
    public void the_search_results_page_should_be_displayed() {
        assertTrue(searchResultsPage.isSearchResultsDisplayed(), "Resultados encontrados para: ");
    }

    @Then("the search results page should display results for {string}")
    public void the_search_results_page_should_display_results_for(String term) {
        assertTrue(searchResultsPage.isSearchResultsDisplayed(), "Resultados encontrados para: " + term);
    }

    @Then("the search results page should display no results")
    public void the_search_results_page_should_display_no_results() {
        assertTrue(searchResultsPage.isSearchResultsDisplayed(), "Nenhum resultado encontrado.");
    }

    @Given("I am on the search results page")
    public void i_am_on_the_search_results_page() {
        homePage.open();
        homePage.clickSearchButton();
        homePage.pressEnterInSearchField();
    }

    @When("I click on the home button")
    public void i_click_on_the_home_button() {
        homePage.clickHomeButton();
    }

    @Then("I should be on the homepage")
    public void i_should_be_on_the_homepage() {
        assertTrue(homePage.isHomePageDisplayed(), "Página inicial não exibida.");
    }

    @And("the search results page should display a list of results")
    public void theSearchResultsPageShouldDisplayAListOfResults() {
        assertEquals("Resultados encontrados para: FGTS", searchResultsPage.getSearchSpecificResults());
    }

    @Then("the not search results page should display a list of results")
    public void the_not_search_results_page_should_display_a_list_of_results() {
        assertTrue(searchResultsPage.getNoResultsMessage().contains("Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras."));
    }
}