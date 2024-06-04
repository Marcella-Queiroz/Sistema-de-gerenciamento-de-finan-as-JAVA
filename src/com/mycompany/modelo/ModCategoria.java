package com.mycompany.modelo;

public class ModCategoria {
    private int id;
    private int tipoCategoria;
    private String nome;

    public ModCategoria() {
    }

    public ModCategoria(int id, int tipoCategoria, String nome) {
        this.id = id;
        this.tipoCategoria = tipoCategoria;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(int tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ModCategoria{" + "id=" + id + ", tipoCategoria=" + tipoCategoria + ", nome=" + nome + '}';
    }
}
