
  Feature: US1007 Kullanici yanlis bilgilerle giris yapamaz
    @paralel2

    Scenario: TC11 Kullanici gecersiz email ve gecerli password ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      When anasayfadaki account linkine tiklar
      Then email kutusuna configuration dosyasindaki "toGecersizEmail" degerini girer
      And password kutusuna configuration dosyasindaki "toGecerliPassword" degerini girer
      And login sayfasindaki signIn butonuna basar
      Then basarili sekilde giris yapilamadigini test eder


      Scenario: TC12 Kullanici gecerli email ve gecersiz password ile giris yapamamali

        Given kullanici testotomasyonu anasayfaya gider
        When anasayfadaki account linkine tiklar
        Then email kutusuna configuration dosyasindaki "toGecerliEmail" degerini girer
        And password kutusuna configuration dosyasindaki "toGecersizPassword" degerini girer
        And login sayfasindaki signIn butonuna basar
        Then basarili sekilde giris yapilamadigini test eder

    Scenario: TC12 Kullanici gecersiz email ve gecersiz password ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      When anasayfadaki account linkine tiklar
      Then email kutusuna configuration dosyasindaki "toGecersizEmail" degerini girer
      And password kutusuna configuration dosyasindaki "toGecersizPassword" degerini girer
      And login sayfasindaki signIn butonuna basar
      Then basarili sekilde giris yapilamadigini test eder