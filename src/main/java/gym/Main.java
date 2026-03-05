package gym;

import java.util.Scanner;
import gym.model.Plano;
import gym.model.PlanoBasico;
import gym.model.PlanoPremium;
import gym.service.GymService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        exibirMenu(scanner);
    }

    public static void cadastrarAluno(Scanner scanner) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1. [📦] PLANO BÁSICO");
        System.out.println("2. [💎] PLANO PREMIUM");
        System.out.println("0. VOLTAR");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println("Plano Básico");
                break;
            case 2:
                System.out.println("Plano Premium");
                break;
            case 0: exibirMenu(scanner);
            default:
                System.out.println("[❌] Valor Inválido!");
        }
    }

    public static void exibirMenu(Scanner scanner) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1. [📝] CADASTRAR ALUNO");
        System.out.println("2. [📚] LISTAR ALUNOS");
        System.out.println("3. [📮] ATUALIZAR ALUNO");
        System.out.println("4. [🚯] REMOVER ALUNO");
        System.out.println("0. SAIR");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int option = scanner.nextInt();

        switch (option){
            case 1: cadastrarAluno(scanner); break;
            case 2: /* peraí */ break;
            case 3: /* peraí */ break;
            case 4: /* peraí */ break;
            case 0: return;
            default:
                System.out.println("[❌] Valor Inválido!");
        }
    }
}