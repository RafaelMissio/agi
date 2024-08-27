package com.missio.agi.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='slide-search astra-search-icon']/span[@class='ast-icon icon-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='search-field']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class='custom-logo-link']")
    private WebElement homeButton;

    @FindBy(xpath = "//div[@class='search-suggestions']")
    private WebElement searchSuggestions;

    @FindBy(xpath = "//div[@class='ast-search-menu-icon slide-search']")
    private WebElement initialPage;

    public BlogHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://blogdoagi.com.br/");
        driver.manage().window().maximize();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterSearchTerm(String term) {
        searchField.sendKeys(term);
    }

    public void pressEnterInSearchField() {
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickHomeButton() {
        homeButton.click();
    }

    public boolean areSearchSuggestionsDisplayed() {
        return searchSuggestions.isDisplayed();
    }

    public boolean isHomePageDisplayed() {
        return initialPage.isDisplayed();
    }

}