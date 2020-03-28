package br.com.willbigas.controller;

import br.com.willbigas.model.Produto;

public class ProdutoController {


    public Produto calcular(Produto produto , boolean comEntrada) {
        produto = calcularValores(produto , comEntrada);
        return produto;
    }


    private Produto calcularValores(Produto produto , boolean comEntrada) {
        produto.setValorInicial(produto.getValor());
        produto.setValorParcelas(produto.getValor() / produto.getQtdParcelas());

        if (comEntrada) {
            produto.setValorTotalJuros(produto.getValorInicial() * ((produto.getJuros() / 100) - 0.05));
        } else {
            produto.setValorTotalJuros(produto.getValorInicial() * (produto.getJuros() / 100));
        }
        produto.setValorTotal(produto.getValorInicial() + produto.getValorTotalJuros());
        return produto;
    }
}
