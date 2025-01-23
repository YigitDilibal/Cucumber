package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoqaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class DemoqaStepDefinitions {

    DemoqaPage demoqaPage = new DemoqaPage();

    @Then("Alerts'e tiklar")
    public void alerts_e_tiklar() {
        demoqaPage.alertsButonu.click();
    }
    @When("On button click, alert will appear after 5 seconds karsisindaki click me butonuna basar")
    public void on_button_click_alert_will_appear_after_seconds_karsisindaki_click_me_butonuna_basar() {

        demoqaPage.timerAlertButton.click();
    }
    @When("Alert'in gorunur olmasini bekler")
    public void alert_in_gorunur_olmasini_bekler() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    @Then("Alert uzerindeki yazinin {string} oldugunu test eder")
    public void alert_uzerindeki_yazinin_oldugunu_test_eder(String expectedAlertYazisi) {
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        Assertions.assertEquals(actualAlertYazisi,expectedAlertYazisi);
    }
    @Then("Ok diyerek alerti kapatir")
    public void ok_diyerek_alerti_kapatir() {

        Driver.getDriver().switchTo().alert().accept();
    }


    @Then("Elements menusunu acar")
    public void elementsMenusunuAcar() {
        demoqaPage.elementsMenusu.click();
    }

    @And("Dynamic Properties menusune gider")
    public void dynamicPropertiesMenusuneGider() {
        demoqaPage.DynamicPropertiesMenusu.click();
    }

    @When("Will enable 5 seconds butonunun enable olmasini bekler")
    public void willEnableSecondsButonununEnableOlmasiniBekler() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(demoqaPage.willEnable5SecondsButonu));

    }

    @And("Will enable 5 seconds butonunun enable oldugunu test eder")
    public void willEnableSecondsButonununEnableOldugunuTestEder() {
        Assertions.assertTrue(demoqaPage.willEnable5SecondsButonu.isEnabled());
    }


    @When("Visible after 5 seconds butonunun gorunur olmasini bekler")
    public void visibleAfterSecondsButonununGorunurOlmasiniBekler() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(demoqaPage.visibleAfterButonu));
    }


    @And("Visible after 5 seconds butonunun gorunur oldugunu test eder")
    public void visibleAfterSecondsButonununGorunurOldugunuTestEder() {
        Assertions.assertTrue(demoqaPage.visibleAfterButonu.isDisplayed());
    }

    @When("Color change butonunun renginin degismesini bekler")
    public void colorChangeButonununRengininDegismesiniBekler() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(demoqaPage.renkliColorChangeButonu));
    }

    @And("Color change butonunun renginin degistigini test eder")
    public void colorChangeButonununRengininDegistiginiTestEder() {
        Assertions.assertTrue(demoqaPage.renkliColorChangeButonu.isDisplayed());
    }
}
