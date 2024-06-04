package com.mycompany.modelo;

public class ModMetas {
    private int id;
    private String nome;
    private float valor;
    private String descricao;
    private String dataInicial;
    private String dataFinal;

    public ModMetas() {
    }

    public ModMetas(int id, String nome, float valor, String descricao, String dataInicial, String dataFinal) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "ModMetas{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", descricao=" + descricao + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + '}';
    }
    
}
