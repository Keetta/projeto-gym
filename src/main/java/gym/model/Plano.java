package gym.model;

public abstract class Plano {
    private String nome;
    private double valorBase;

    public Plano(String nome, double valorBase){
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public String getNome() {
        return nome;
    }

    public double getValorBase() {
        return valorBase;
    }

    public abstract double calcularMensalidade();
}