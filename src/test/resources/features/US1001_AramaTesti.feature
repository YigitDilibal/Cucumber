
Feature: US1001 Kullanici testotomasyonu sayfasinda arama yapar

  @paralel1

  Scenario: TC01 kullanici phone arattiginda sonuc bulabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder


    Scenario: TC02 kullanici dress arattiginda sonuc bulabilmeli
      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna dress yazip aratir
      Then arama sonucunda urun bulunabildigini test eder


      Scenario: TC03 kullanici Java arattiginda sonuc bulamamali
        Given kullanici testotomasyonu anasayfaya gider
        When arama kutusuna Java yazip aratir
        Then arama sonucunda urun bulunamadigini test eder