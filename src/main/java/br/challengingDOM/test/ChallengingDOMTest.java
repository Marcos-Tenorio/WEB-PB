package br.challengingDOM.test;

import br.challengingDOM.core.BasePage;
import br.challengingDOM.core.BaseTest;
import br.challengingDOM.page.ChallengingDOMPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static br.challengingDOM.core.DriverFactory.getDriver;


public class ChallengingDOMTest extends BaseTest {

    private ChallengingDOMPage challengingDOMPage;

    @Before
    public void inicializaDriver() {
        challengingDOMPage = new ChallengingDOMPage();
    }

    @Test
    public void ct01ClicarBotoes() {
        String canvaAntes = challengingDOMPage.getScript();
        challengingDOMPage.clickBtnSucess();
        String canvaDepois = challengingDOMPage.getScript();

        Assert.assertNotSame(canvaAntes, canvaDepois);

        String canvaAntes1 = challengingDOMPage.getScript();
        challengingDOMPage.clickBtnAlert();
        String canvaDepois1 = challengingDOMPage.getScript();

        Assert.assertNotSame(canvaAntes1, canvaDepois1);

        String canvaAntes2 = challengingDOMPage.getScript();
        challengingDOMPage.clickBtn();
        String canvaDepois2 = challengingDOMPage.getScript();

        Assert.assertNotSame(canvaAntes2, canvaDepois2);
    }

    @Test
    public void ct02ClicarEditsEDeletesTabelaAction() {

        WebElement tabela = challengingDOMPage.getTabela();

        int i = challengingDOMPage.obterIndiceColunaAction(tabela.findElements(By.xpath(".//thead/tr/th")));

        List<WebElement> linhas = tabela.findElements(By.xpath(".//tbody/tr"));

        for (int i1 = 1; i1 <= linhas.size(); i1++) {
            List<WebElement> actions = tabela.findElements(By.xpath(".//tbody/tr[" + i1 + "]/td[" + i + "]/a"));
            for (WebElement action : actions) {
                try {
                    if (action.getAttribute("href").contains("#edit")) {
                        action.click();
                        Assert.assertTrue(getDriver().getCurrentUrl().contains("#edit"));
                    } else if (action.getAttribute("href").contains("#delete")) {
                        action.click();
                        Assert.assertTrue(getDriver().getCurrentUrl().contains("#delete"));
                    }
                } catch (StaleElementReferenceException ex) {
                    Assert.fail("Links edit ou delete da tabela do Challenging DOM nao foram encontrados");
                }
            }
        }
    }
}