package br.challengingDOM.core;

import br.challengingDOM.page.ChallengingDOMPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.challengingDOM.core.DriverFactory.getDriver;
import static br.challengingDOM.core.DriverFactory.killDriver;

public class BaseTest {

    private ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void inicializa(){
        challengingDOMPage.acessarTelaInicial();
    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File(
                "target" + File.separator +
                "screenshot" + File.separator +
                testName.getMethodName() + ".jpg"));

        if (Properties.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
