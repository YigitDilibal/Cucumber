
  Feature: US1006 kullanici gecerli bilgilerle giris yapar

    Scenario: TC10 kullanici configuration dosyasindaki gecerli datalarla giris yapabilmeli

      Given kullanici testotomasyonu anasayfaya gider
      Then anasayfadaki account linkine tiklar
      When email kutusuna configuration dosyasindaki "toGecerliEmail" degerini girer
      And password kutusuna configuration dosyasindaki "toGecerliPassword" degerini girer
      Then login sayfasindaki signIn butonuna basar
      And senkronizasyon icin 2 saniye bekler
      And basarili sekilde giris yapilabildigini test eder
      And senkronizasyon icin 2 saniye bekler
      Then logout butonuna basar