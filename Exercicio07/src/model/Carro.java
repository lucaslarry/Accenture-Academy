package model;

public class Carro {
    private boolean ligado = false;

    public boolean isLigado() { return ligado; }
    public void setLigado(boolean ligado) { this.ligado = ligado; }
    public String buzinar() { return "Beep Beep! (Som emitido)"; }
}