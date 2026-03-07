package gym.service;

import gym.model.Aluno;
import gym.model.Plano;
import java.util.ArrayList;
import java.util.List;

public class GymService {

    private List<Aluno> alunos = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("[✅] Aluno cadastrado com sucesso!");
    }

    public void listarAlunos() {
        if(alunos.isEmpty()){
            System.out.println("[⚠] Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public void atualizarAluno(int id, String novoNome, int novaIdade, Plano novoPlano) {
        Aluno aluno = buscarAlunoPorId(id);
        if(aluno != null){
            aluno.setNome(novoNome);
            aluno.setIdade(novaIdade);
            aluno.setPlano(novoPlano);
            System.out.println("[✅] Aluno atualizado com sucesso!");
        } else {
            System.out.println("[⚠] Aluno não encontrado!");
        }
    }

    public void removerAluno(int id) {
        Aluno aluno = buscarAlunoPorId(id);
        if(aluno != null){
            alunos.remove(aluno);
            System.out.println("[✅] Aluno removido com sucesso!");
        } else {
            System.out.println("[⚠] Aluno não encontrado!");
        }
    }

    private Aluno buscarAlunoPorId(int id){
        for(Aluno a : alunos){
            if(a.getId() == id) return a;
        }
        return null;
    }

    public void buscarAlunoPorNome(String nome){
        boolean encontrado = false;

        for(Aluno aluno : alunos){
            if(aluno.getNome().equalsIgnoreCase(nome)){
                System.out.println(aluno);
                encontrado = true;
            }
        }

        if(!encontrado){
            System.out.println("[⚠] Nenhum aluno encontrado com esse nome...");
        }
    }

    public void relatorioMensalidade() {

        if(alunos.isEmpty()){
            System.out.println("[⚠] Nenhum aluno cadastrado.");
            return;
        }

        double total = 0;

        for(Aluno aluno : alunos){
            total += aluno.getPlano().calcularMensalidade();
        }

        System.out.printf("[💰] Receita mensal da academia: R$ %.2f%n", total);
    }
}