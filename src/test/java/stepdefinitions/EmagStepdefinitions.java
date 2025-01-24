package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import pages.EmagPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmagStepdefinitions {

    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sheet1;
    int ilkBosHucreIndexi;
    String excelDosyaYolu;
    EmagPage emagPage = new EmagPage();

    @Then("urunListesi2 excelindeki Sheet1'e gider")
    public void urunlistesiExcelindekiSheetEGider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/urunListesi3.xlsx");
        workbook = WorkbookFactory.create(fileInputStream);
        sheet1 = workbook.getSheet("Sheet1");



    }

    @And("birinci satirdaki bos olan ilk hucrenin indexini kaydeder")
    public void birinciSatirdakiBosOlanIlkHucreninIndexiniKaydeder() {

        for (int i = 0; i < 1000000; i++) {

            if (sheet1.getRow(0).getCell(i) == null){
                ilkBosHucreIndexi = i;
                break;
            }
        }
    }

    @Then("birinci satirdaki bos olan ilk hucreye gunun tarihini kaydeder")
    public void birinciSatirdakiBosOlanIlkHucreyeGununTarihiniKaydeder() {
        String date = new SimpleDateFormat("dd-MMM-yy_hh-mm").format(new Date());
        sheet1.getRow(0).createCell(ilkBosHucreIndexi).setCellValue(date);

    }

    @And("her satirdaki urunu emag sitesinde aratir ve bulunan urunlerden ilkinin fiyatini kaydedilen index'deki sutuna yazar")
    public void herSatirdakiUrunuEmagSitesindeAratirVeBulunanUrunlerdenIlkininFiyatiniKaydedilenIndexDekiSutunaYazar() throws IOException {

        int sonSatirIndexi = sheet1.getLastRowNum();

        for (int i = 1; i <= sonSatirIndexi ; i++) {

            String satirdakiUrunIsmi = sheet1.getRow(i)
                    .getCell(0)
                    .getStringCellValue();

            Driver.getDriver().get(ConfigReader.getProperty("emagUrl"));
            emagPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);

            String ilkUrunFiyati = emagPage.ilkUrunFiyatElementi.getText();

            sheet1.getRow(i)
                    .createCell(ilkBosHucreIndexi)
                    .setCellValue(ilkUrunFiyati);

        }

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/urunListesi3.xlsx");
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();

    }
}
