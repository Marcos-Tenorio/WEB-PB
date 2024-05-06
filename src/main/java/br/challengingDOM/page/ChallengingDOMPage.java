package br.challengingDOM.page;

import br.challengingDOM.core.BasePage;
import br.challengingDOM.core.DriverFactory;
import org.openqa.selenium.WebElement;

import static br.challengingDOM.core.DriverFactory.getDriver;


public class ChallengingDOMPage extends BasePage {

    public void acessarTelaInicial(){
        getDriver().get("https://the-internet.herokuapp.com/challenging_dom");
    }
    public void clickBtnSucess(){
        clickBtnByXpath("//a[@class='button success']");
    }

    public void clickBtnAlert(){
        clickBtnByXpath("//a[@class='button alert']");
    }

    public void clickBtn(){
        clickBtnByXpath("//a[@class='button']");
    }

    public String getScript(){
        return getText("//div[@id='content']//script");
    }

    public WebElement getTabela(){
        return obterTabela("//*[@id=\"content\"]/div/div/div/div[2]/table");
    }

}
