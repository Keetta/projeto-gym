package gym.model;


public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private Plano plano;

    public Aluno(int id, String nome, int idade, Plano plano) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.plano = plano;
    }

        public int getId(){
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

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public Plano getPlano() {
            return plano;
        }

        public void setPlano(Plano plano) {
            this.plano = plano;
        }

        @Override
        public String toString () {
        return String.format("ID: %d | Nome: %-15s | Idade: %d | Plano: %-12s | Total: R$ %.2f",
                id,
                nome,
                idade,
                plano.getNome(),
                plano.calcularMensalidade());


    }
}