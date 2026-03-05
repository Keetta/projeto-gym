package gym.service;

import gym.model.Aluno;
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

    public void atualizarAluno() {
        System.out.println("Você vai atualizar um aluno!");
    }

    public void removerAluno() {
        System.out.println("Você vai remover um aluno!");
    }
}