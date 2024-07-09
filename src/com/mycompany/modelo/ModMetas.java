package com.mycompany.modelo;

public class ModMetas {
    private int id;
    private String nome;
    private float valor;
    private int meses;
    private String dataInicial;
    private Double valor_depositado;
    

    public ModMetas() {
    }

    public ModMetas(int id, String nome, float valor, int meses, String dataInicial, Double valor_depositado) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.meses = meses;
        this.dataInicial = dataInicial;
        this.valor_depositado = valor_depositado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Double getValor_depositado() {
        return valor_depositado;
    }

    public void setValor_depositado(Double valor_depositado) {
        this.valor_depositado = valor_depositado;
    }

    @Override
    public String toString() {
        return "ModMetas{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", meses=" + meses + ", dataInicial=" + dataInicial + ", valor_depositado=" + valor_depositado + '}';
    }
}

    

    
