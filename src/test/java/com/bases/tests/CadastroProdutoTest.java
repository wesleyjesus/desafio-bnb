package com.bases.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bases.data.ProdutoData;
import com.bases.pages.ProdutoPO;
import com.bases.utils.BaseTest;
import com.bases.utils.FileTelasUtils;

public class CadastroProdutoTest extends BaseTest {

    private ProdutoPO produtoPage;
    
    // private List<String> arquivosHtml = Arrays.asList(
    //         FileTelasUtils.TELA_1,
    //         FileTelasUtils.TELA_2,
    //         FileTelasUtils.TELA_3);

    @BeforeEach
    public void prepararTeste() {
        produtoPage = new ProdutoPO(driver);
    }

    /**
     * @throws InterruptedException
     * 
     */
    @Test
    public void TC001_Cadastrar_produto_com_dados_validos() throws InterruptedException {


        driver.get(FileTelasUtils.TELA_3);
        ProdutoData dadosProduto = new ProdutoData();

        // Validando se estou realmente utilizando a tela 3
        String tituloFormulario = produtoPage.getTituloFormulario();
        Assertions.assertEquals("Teste 3", tituloFormulario);

        produtoPage.preencheProduto(dadosProduto.produtoValido().getNomeProduto(),
                dadosProduto.produtoValido().getPreco(), dadosProduto.produtoValido().getDataValidade());
        produtoPage.clicarBtnAdicionar();

        Thread.sleep(1000);

        Assertions.assertTrue(produtoPage.isProductInTable(
                dadosProduto.produtoValido().getNomeProduto(),
                dadosProduto.produtoValido().getPreco(),
                dadosProduto.produtoValido().getDataValidade()), "O produto não foi adicionado à tabela.");

    }

    @Test
    public void TC002_Cadastrar_produto_com_dados_em_branco() throws InterruptedException {
        
                driver.get(FileTelasUtils.TELA_3);
                ProdutoData dadosProduto = new ProdutoData();

                produtoPage.preencheProduto(dadosProduto.produtoEmBranco().getNomeProduto(),
                        dadosProduto.produtoEmBranco().getPreco(), dadosProduto.produtoEmBranco().getDataValidade());
                produtoPage.clicarBtnAdicionar();

                Assertions.assertEquals("Nome invalido", produtoPage.getMsgNomeProdutoObrigatorio());
                Assertions.assertEquals("Preço invalido", produtoPage.getMsgPrecoObrigatorio());
                Assertions.assertEquals("Validade Invalida", produtoPage.getMsgValidadeObrigatorio());

    }

    @Test
    public void TC003_Cadastrar_produto_igual_a_um_ja_cadastrado() throws InterruptedException {

                 driver.get(FileTelasUtils.TELA_3);
                ProdutoData dadosProduto = new ProdutoData();

                produtoPage.preencheProduto(dadosProduto.produtoIgual().getNomeProduto(),
                        dadosProduto.produtoIgual().getPreco(), dadosProduto.produtoIgual().getDataValidade());
                produtoPage.clicarBtnAdicionar();

                produtoPage.preencheProduto(dadosProduto.produtoIgual().getNomeProduto(),
                        dadosProduto.produtoIgual().getPreco(), dadosProduto.produtoIgual().getDataValidade());
                produtoPage.clicarBtnAdicionar();

                // Era para ter uma validação de produtos iguais, porém não existe tratamento para esta regra.
    }

    @Test
    public void TC004_Cadastrar_produto_preco_menor_que_0() throws InterruptedException {

                 driver.get(FileTelasUtils.TELA_3);
                ProdutoData dadosProduto = new ProdutoData();

                produtoPage.preencheProduto(dadosProduto.produtoPrecoMenorQueZero().getNomeProduto(),
                        dadosProduto.produtoPrecoMenorQueZero().getPreco(), dadosProduto.produtoPrecoMenorQueZero().getDataValidade());
                produtoPage.clicarBtnAdicionar();
Thread.sleep(3000);
                Assertions.assertEquals("Preço invalido", produtoPage.getMsgPrecoObrigatorio());

    }

    @Test
    public void TC005_Cadastrar_produto_informando_letras_no_campo_preco() throws InterruptedException {

                 driver.get(FileTelasUtils.TELA_3);
                ProdutoData dadosProduto = new ProdutoData();

                produtoPage.preencheProduto(dadosProduto.produtoComLetraNoPreco().getNomeProduto(),
                        dadosProduto.produtoComLetraNoPreco().getPreco(), dadosProduto.produtoComLetraNoPreco().getDataValidade());
                produtoPage.clicarBtnAdicionar();
        Thread.sleep(3000);
                Assertions.assertEquals("Preço invalido", produtoPage.getMsgPrecoObrigatorio());

    }

     @Test
    public void TC007_Cadastrar_produto_validade_apos_31_12_2021() throws InterruptedException {

                 driver.get(FileTelasUtils.TELA_3);
                ProdutoData dadosProduto = new ProdutoData();

                produtoPage.preencheProduto(dadosProduto.produtoComValidadeApos().getNomeProduto(),
                        dadosProduto.produtoComValidadeApos().getPreco(), dadosProduto.produtoComValidadeApos().getDataValidade());
                produtoPage.clicarBtnAdicionar();
        Thread.sleep(2000);
                Assertions.assertEquals("Validade invalido", produtoPage.getMsgValidadeObrigatorio());

    }

    @Test
    public void TC009_Cadastrar_produto_informando_letras_na_validade() throws InterruptedException {

                 driver.get(FileTelasUtils.TELA_3);
                ProdutoData dadosProduto = new ProdutoData();

                produtoPage.preencheProduto(dadosProduto.produtoComLetraNaValidade().getNomeProduto(),
                        dadosProduto.produtoComLetraNaValidade().getPreco(), dadosProduto.produtoComLetraNaValidade().getDataValidade());
                produtoPage.clicarBtnAdicionar();

                Assertions.assertEquals("Validade Invalida", produtoPage.getMsgValidadeObrigatorio());

    }

}