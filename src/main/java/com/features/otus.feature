Feature: Otus Feature

  @1
  Scenario: Verify that user can open OTUS page
    Given Init Chrome Driver
    When I open otus page
    Then I should see page url "https://otus.ru/"