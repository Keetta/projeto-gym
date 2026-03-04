package gym.model;

public class PlanoBasico extends Plano {
        public PlanoBasico(String nome, double valorBase) {
            super(nome, valorBase);
        }

        @Override
        public double calcularMensalidade(){
            return getValorBase();
        }
}
