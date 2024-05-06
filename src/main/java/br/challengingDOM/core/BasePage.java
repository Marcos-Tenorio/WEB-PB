package br.challengingDOM.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static br.challengingDOM.core.DriverFactory.getDriver;

public class BasePage {

    public BasePage() {

    }

    public String getText(String xpath) {
        return getDriver().findElement(By.xpath(xpath)).getText();
    }

    public void clickBtnByXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
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

    public int obterIndiceColuna(List<WebElement> colunas, String text){
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++){
            if(colunas.get(i).getText().equalsIgnoreCase(text)){
                idColuna = i;
                break;
            }
        }

        return idColuna + 1;
    }

}
