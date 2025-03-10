Feature: US1013 verilen urunler yeterince bulunabilmeli


  Scenario Outline: TC19 kullanici verilen urunlerin verilen listedeki minumum sayi
  veya daha fazla bulunabildigini test eder

    Given kullanici "toUrl" anasayfaya gider
    When arama kutusuna "<aranacakKelime>" yazip aratir
    Then arama sonucunda "<belirlenenMiktar>" veya daha fazla urun bulunabildigini test eder



    Examples:
      |aranacakKelime|belirlenenMiktar|
      |phone         |3               |
      |dress         |8               |
      |java          |0               |
      |samsung       |2               |
      |baby          |1               |
      |Cokoprens     |0               |
      |Nutella       |0               |