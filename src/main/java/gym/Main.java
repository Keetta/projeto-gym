package gym;

import java.util.Scanner;

import gym.model.Aluno;
import gym.model.Plano;
import gym.model.PlanoBasico;
import gym.model.PlanoPremium;
import gym.service.GymService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GymService service = new GymService();

        exibirMenu(scanner, service);
    }

    public static void exibirCadastroAluno(Scanner scanner, GymService service) {

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1. [📦] PLANO BÁSICO");
        System.out.println("2. [💎] PLANO PREMIUM");
        System.out.println("0. VOLTAR");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int option = scanner.nextInt();
        scanner.nextLine();

        if(option == 0) return;

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        Plano plano;

        if(option == 1){
            plano = new PlanoBasico("Básico", 100);
        } else {
            plano = new PlanoPremium("Premium", 100);
        }

        Aluno aluno = new Aluno(id, nome, idade, plano);

        service.cadastrarAluno(aluno);
    }

    public static void exibirMenu(Scanner scanner, GymService service) {

        int option;
        do {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("1. [📝] CADASTRAR ALUNO");
            System.out.println("2. [📚] LISTAR ALUNOS");
            System.out.println("3. [📮] ATUALIZAR ALUNO");
            System.out.println("4. [🚯] REMOVER ALUNO");
            System.out.println("0. SAIR");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            option = scanner.nextInt();

            switch (option){
                case 1: exibirCadastroAluno(scanner, service); break;
                case 2: service.listarAlunos(); break;
                case 3: service.atualizarAluno(); break;
                case 4: service.removerAluno(); break;
                case 0: return;
                default:
                    System.out.println("[❌] Valor Inválido!");
            }
        } while (option != 0);
    }
}