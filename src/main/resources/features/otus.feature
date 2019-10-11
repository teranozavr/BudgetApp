Feature: Otus Feature

  @1
  Scenario: Verify that user can open OTUS page
    When I open otus page
    Then I should see page url "https://otus.ru/"