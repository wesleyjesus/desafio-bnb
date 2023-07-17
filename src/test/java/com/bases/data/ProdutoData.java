package com.bases.data;

import com.bases.dto.ProdutoDTO;

public class ProdutoData {
    
    public ProdutoDTO produtoValido(){
        return new ProdutoDTO("Produto 1", "150,00", "30/12/2021");
    }

    public ProdutoDTO produtoEmBranco(){
        return new ProdutoDTO("", "", "");
    }

    public ProdutoDTO produtoIgual(){
        return new ProdutoDTO("Produto igual", "10,00", "01/01/2020");
    }

    public ProdutoDTO produtoPrecoMenorQueZero(){
        return new ProdutoDTO("Produto preco menor que zero", "-1", "01/01/2020");
    }

    public ProdutoDTO produtoComLetraNoPreco(){
        return new ProdutoDTO("Produto preco menor que zero", "asdfas", "01/01/2020");
    }

    public ProdutoDTO produtoComValidadeApos(){
        return new ProdutoDTO("Produto preco menor que zero", "50,00", "01/01/2022");
    }

    public ProdutoDTO produtoComLetraNaValidade(){
        return new ProdutoDTO("Produto preco menor que zero", "50,00", "sadfsa");
    }
    
}
