package br.com.willbigas.model;

public class Produto {

    private String nome;
    private Double valor;
    private Integer qtdParcelas;
    private Double juros;
    private Double valorInicial;
    private Double valorParcelas;
    private Double valorTotal;
    private Double valorTotalJuros;

    public Produto() {
    }

    public Produto(String nome, Double valor, Integer qtdParcelas, Double juros) {
        this.nome = nome;
        this.valor = valor;
        this.qtdParcelas = qtdParcelas;
        this.juros = juros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorTotalJuros() {
        return valorTotalJuros;
    }

    public void setValorTotalJuros(Double valorTotalJuros) {
        this.valorTotalJuros = valorTotalJuros;
    }
}
