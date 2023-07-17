package com.bases.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProdutoPO extends BasePO{
    
    @FindBy(css = "div.mt-5>div.card-header")
    private WebElement tituloFormulario;

    @FindBy(id = "inputNome")
    private WebElement inputNomeProduto;

    @FindBy(id = "inputPreco")
    private WebElement inputPreco;

    @FindBy(id = "inputValidade")
    private WebElement inputValidade;

    @FindBy(className = "btn-primary")
    private WebElement btnAdicionar;

    @FindBy(id = "conteudoTabela")
    private WebElement tabelaDados;

    @FindBy( xpath = "//form[@id='form']/div[@class='mb-3']/div[contains(.,'Nome invalido')]")
    private WebElement campoObrigatorioNomeProduto;

    @FindBy( xpath = "//form[@id='form']/div[@class='mb-3']/div[contains(.,'Preço invalido')]")
    private WebElement campoObrigatorioPreco;

    @FindBy( xpath = "//form[@id='form']/div[@class='mb-3']/div[contains(.,'Validade Invalida')]")
    private WebElement campoObrigatorioValidade;

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    public String getTituloFormulario(){
        return tituloFormulario.getText();
    }

    public void preencheProduto(String nomeProduto, String preco, String dataValidade){
        inputNomeProduto.sendKeys(nomeProduto);
        inputPreco.sendKeys(preco);
        inputValidade.sendKeys(dataValidade);
    }

    public void clicarBtnAdicionar(){
        btnAdicionar.click();
    }

    public String getMsgNomeProdutoObrigatorio(){
        return campoObrigatorioNomeProduto.getText();
    }

    public String getMsgPrecoObrigatorio(){
        return campoObrigatorioPreco.getText();
    }

    public String getMsgValidadeObrigatorio(){
        return campoObrigatorioValidade.getText();
    }

    public boolean isProductInTable(String nomeProduto, String preco, String dataValidade) {
        List<WebElement> linhas = tabelaDados.findElements(By.tagName("tr"));
    
        for (WebElement linha : linhas) {
            List<WebElement> colunas = linha.findElements(By.tagName("td"));
    
            String nomeProdutoTabela = colunas.get(1).getText().trim();
            String precoTabela = colunas.get(2).getText().trim();
            String dataValidadeTabela = colunas.get(3).getText().trim();
    
            if (nomeProdutoTabela.equals(nomeProduto) && precoTabela.equals(preco) && dataValidadeTabela.equals(dataValidade)) {
                return true;
            }
        }
    
        return false;
    }
}
