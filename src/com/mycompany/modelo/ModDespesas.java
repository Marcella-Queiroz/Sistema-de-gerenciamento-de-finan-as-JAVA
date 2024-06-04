package com.mycompany.modelo;

public class ModDespesas {
 private int id;
 private int categoriaId;
 private String nome;
 private float valor;
 private String vencimento;
 private String pagamento;

    public ModDespesas() {
    }

    public ModDespesas(int id, int categoriaId, String nome, float valor, String vencimento, String pagamento) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.nome = nome;
        this.valor = valor;
        this.vencimento = vencimento;
        this.pagamento = pagamento;
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

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "ModDespesas{" + "id=" + id + ", categoriaId=" + categoriaId + ", nome=" + nome + ", valor=" + valor + ", vencimento=" + vencimento + ", pagamento=" + pagamento + '}';
    }
 
 
 
}
