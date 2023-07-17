package com.bases.dto;

public class ProdutoDTO {
    
    private String nomeProduto;
    private String preco;
    private String dataValidade;

    public ProdutoDTO(String nomeProduto, String preco, String dataValidade) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

}
