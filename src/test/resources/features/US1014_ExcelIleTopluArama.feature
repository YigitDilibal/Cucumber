Feature: US1014 excelde verilen urunler aratilir ve sonuclar kaydedilir



  Scenario Outline: TC20 kullanici excelde verilen urunlerin
                    belirlenen miktar veya daha fazla bulundugunu test edebilmeli
                    ve bulunan sonuc sayisini tarih ile kaydedebilmeli

    Given kullanici urunListesi excel'indeki Sheet1 e gider
    Then Listede verilen "<satir>" daki urun ismini ve minimum sonuc sayisini kaydeder
    When kullanici "toUrl" anasayfaya gider
    And arama kutusuna kaydedilen urun ismini yazip aratir
    Then arama sonucunda minimum sonuc sayisi veya daha fazla urun bulunabildigini test eder
    And bulunan sonuc sayisini "<satir>" daki 4.sutuna, tarihi de 5.sutuna yazar

    Examples:
    |satir|
    |2    |
    |3    |
    |4    |
    |5    |
    |6    |
    |7    |
    |8    |
    |9    |
    |10   |