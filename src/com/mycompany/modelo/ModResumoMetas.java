package com.mycompany.modelo;

public class ModResumoMetas extends ModMetas{
    private Double sugestaoDeposito;
    private Double valorDepositar;
    private Double valorInserir;

    public ModResumoMetas() {
    }

    public ModResumoMetas(Double sugestaoDeposito, Double valorDepositar, Double valorInserir) {
        this.sugestaoDeposito = sugestaoDeposito;
        this.valorDepositar = valorDepositar;
        this.valorInserir = valorInserir;
    }

    public Double getSugestaoDeposito() {
        return sugestaoDeposito;
    }

    public void setSugestaoDeposito(Double sugestaoDeposito) {
        this.sugestaoDeposito = sugestaoDeposito;
    }

    public Double getValorDepositar() {
        return valorDepositar;
    }

    public void setValorDepositar(Double valorDepositar) {
        this.valorDepositar = valorDepositar;
    }
    
    public Double getValorInserir(Double valorInserir){
        return valorInserir;
    }
    
    public void setValorInserir(Double valorInserir){
        this.valorInserir = valorInserir;
    }
    @Override
    public String toString() {
        return "ModResumoMetas{" + "sugestaoDeposito=" + sugestaoDeposito + ", valorDepositar=" + valorDepositar + '}';
    }
    
}
