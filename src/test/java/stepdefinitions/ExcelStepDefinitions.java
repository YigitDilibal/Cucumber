package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestotomasyonuPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExcelStepDefinitions {

    Sheet sheet1;
    String satirdakiUrunIsmi;
    double satirdakiMinimumSonucSayisi;
    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
    int bulunanSonucSayisi;

    @Given("kullanici urunListesi excel'indeki Sheet1 e gider")
    public void kullaniciUrunListesiExcelIndekiSheetEGider() throws IOException {
        String excelDosyaYolu = "src/test/resources/urunListesi.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        sheet1 = workbook.getSheet("Sheet1");

    }

    @Then("Listede verilen {string} daki urun ismini ve minimum sonuc sayisini kaydeder")
    public void listedeVerilenDakiUrunIsminiVeMinimumSonucSayisiniKaydeder(String satirNoStr) {

        int satirNo = Integer.parseInt(satirNoStr);
        satirdakiUrunIsmi = sheet1.getRow(satirNo-1) // verilen satira gider
                                        .getCell(0) // satirda urun ismi olan cell'e gider
                                        .getStringCellValue(); // cell'deki String degeri alir

        satirdakiMinimumSonucSayisi = sheet1.getRow(satirNo-1) // verilen satira gider
                                      .getCell(1) // satirda urun ismi olan cell'e gider
                                      .getNumericCellValue(); // cell'deki double degeri alir


    }

    @And("arama kutusuna kaydedilen urun ismini yazip aratir")
    public void aramaKutusunaKaydedilenUrunIsminiYazipAratir() {
        testotomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);

    }

    @Then("arama sonucunda minimum sonuc sayisi veya daha fazla urun bulunabildigini test eder")
    public void aramaSonucundaMinimumSonucSayisiVeyaDahaFazlaUrunBulunabildiginiTestEder() {

        String aramaSonucYazisi = testotomasyonuPage.aramaSonucYaziElementi.getText();

        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // 3

        bulunanSonucSayisi = Integer.parseInt(aramaSonucYazisi);

        Assertions.assertTrue(bulunanSonucSayisi >= satirdakiMinimumSonucSayisi);



    }

    @And("bulunan sonuc sayisini {string} daki 4.sutuna, tarihi de 5.sutuna yazar")
    public void bulunanSonucSayisiniDakiSutunaTarihiDeSutunaYazar(String satirNoStr) throws IOException {

        String excelDosyaYolu = "src/test/resources/urunListesi.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        sheet1 = workbook.getSheet("Sheet1");

        String date = new SimpleDateFormat("_yyMMdd_hhmmss").format(new Date());
        int satirNo = Integer.parseInt(satirNoStr);

        sheet1.getRow(satirNo-1).createCell(3).setCellValue(bulunanSonucSayisi);
        sheet1.getRow(satirNo-1).createCell(4).setCellValue(date);

        FileOutputStream fileOutputStream = new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
