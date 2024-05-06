package br.challengingDOM.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static br.challengingDOM.core.DriverFactory.getDriver;

public class BasePage {

    public BasePage() {

    }
    public void escreve(String id_campo, String texto_escrever) {
        getDriver().findElement(By.id(id_campo)).sendKeys(texto_escrever);

    }

    public String getText(String xpath) {
        return getDriver().findElement(By.xpath(xpath)).getText();
        //return (String) ((JavascriptExecutor) driver).executeScript(scriptJs, driver.findElement(By.xpath(xpath)));
    }

    public String obterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicarRadioButton(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean checkRadioMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void clicarBotao(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void clickBtnByXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void clicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public int obterIndiceColunaAction(List<WebElement> colunas){
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++){
            if(colunas.get(i).getText().equalsIgnoreCase("Action")){
                idColuna = i;
                break;
            }
        }

        return idColuna + 1;
    }

    public WebElement obterTabela(String xpath){
        return getDriver().findElement(By.xpath(xpath));
    }

}
