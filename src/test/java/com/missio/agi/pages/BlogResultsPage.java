package com.missio.agi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogResultsPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='page-title ast-archive-title']")
    private WebElement searchResultsElement;

    @FindBy(xpath = "//h1[@class='page-title ast-archive-title']/span")
    private WebElement searchResultsEspecificElement;



    @FindBy(xpath = "//section[@class='no-results not-found']")
    private WebElement noResultsMessage;

    public BlogResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchResultsDisplayed() {
        return searchResultsElement.isDisplayed();
    }

    public String getSearchResults() {
        return searchResultsElement.getText();
    }

    public String getSearchSpecificResults() {
        String result = searchResultsElement.getText();
        String specific = searchResultsEspecificElement.getText();
        return result ;
    }

    public boolean isNoResultsMessageDisplayed() {
        return noResultsMessage.isDisplayed();
    }

    public String getNoResultsMessage() {
        return noResultsMessage.getText();
    }
}