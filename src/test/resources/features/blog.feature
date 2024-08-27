Feature: Pesquisar no blog agibank
  As a user
  I want to perform a search
  So that I can find information


  Scenario: Pesquisar por um termo específico
    Given I am on the homepage
    When I click on the search button
    And I enter "FGTS" in the search field
    And press enter in the search field
    Then the search results page should display results for "FGTS"
    And the search results page should display a list of results

  Scenario: Pesquisar por um termo inválido
    Given I am on the homepage
    When I click on the search button
    And I enter "p@ssw0rd" in the search field
    And press enter in the search field
    Then the search results page should display no results
    And the not search results page should display a list of results

  Scenario: Pesquisar com campo vazio
    Given I am on the homepage
    When I click on the search button
    And press enter in the search field
    Then the search results page should display a list of specific results


  Scenario: Navegar para a página inicial a partir da página de resultados de pesquisa
    Given I am on the search results page
    When I click on the home button
    Then I should be on the homepage

  Scenario: Pesquisar por FGTS
    Given I am on the homepage
    When I click on the search button
    And I enter "FGTS" in the search field
    And press enter in the search field
    Then the search results page should display results for "FGTS"
    And the search results page should display a list of results

