
  Feature: US1005 Kullanici parametre olarak verilen urunu aratir

    @paralel1


    Scenario: TC09 Kullanici verilen her urunu tek step ile aratabilmeli

      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna "bag" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And  aratma sonuclarindan ilk urunu tiklar
      And senkronizasyon icin 3 saniye bekler
      Then acilan urun sayfasindaki urun isminde case sensitive olmadan "bag" bulundugunu test eder
