package com.mycompany.modelo;

public class ModReceitas {
    private int id;
    private int categoriaId;
    private String nome;
    private float valor;
    private String dataDeLançamento;

    public ModReceitas() {
    }

    public ModReceitas(int id, int categoriaId, String nome, float valor, String dataDeLançamento) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.nome = nome;
        this.valor = valor;
        this.dataDeLançamento = dataDeLançamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
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

    public String getDataDeLançamento() {
        return dataDeLançamento;
    }

    public void setDataDeLançamento(String dataDeLançamento) {
        this.dataDeLançamento = dataDeLançamento;
    }

    @Override
    public String toString() {
        return "ModReceitas{" + "id=" + id + ", categoriaId=" + categoriaId + ", nome=" + nome + ", valor=" + valor + ", dataDeLan\u00e7amento=" + dataDeLançamento + '}';
    }
    
}
