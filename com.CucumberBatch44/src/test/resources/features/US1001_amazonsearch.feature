Feature: US1001_amazon_search

  Scenario: TC01_Amazon Search Testi
    Given kullanici amazon sayfasina gider
    And iPhone icin arama yapar
    Then sonuclarin iphone icerdigini test eder
  Scenario: TC01_Amazon Search Testi 2
    Given kullanici amazon sayfasina gider
    And tea pot icin arama yapar
    Then sonuclarin tea pot icerdigini test eder
  Scenario: TC01_Amazon Search Testi 3
    Given kullanici amazon sayfasina gider
    And flower icin arama yapar
    Then sonuclarin flower icerdigini test eder