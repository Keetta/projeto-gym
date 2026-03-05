package gym.model;

public class PlanoPremium extends Plano {
    public PlanoPremium(String nome, double valorBase) {
        super(nome, valorBase);
    }

    @Override
    public double calcularMensalidade(){
        return getValorBase() * 1.25;
    }
}
