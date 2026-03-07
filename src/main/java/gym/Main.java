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

        scanner.close();
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
        scanner.nextLine();

        Plano plano;

        if(option == 1) {
            plano = new PlanoBasico("Básico", 100);
        }
        else if(option == 2) {
            plano = new PlanoPremium("Premium", 100);
        }
        else {
            System.out.println("[❌] Plano inválido!");
            return;
        }

        Aluno aluno = new Aluno(id, nome, idade, plano);
        service.cadastrarAluno(aluno);
    }

    public static void exibirMenu(Scanner scanner, GymService service) {
        int option;

        do {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("1. [📝] CADASTRAR ALUNO");
            System.out.println("2. [📚] LISTAR ALUNOS");
            System.out.println("3. [📮] ATUALIZAR ALUNO");
            System.out.println("4. [🚯] REMOVER ALUNO");
            System.out.println("5. [💰] RELATÓRIO FINANCEIRO");
            System.out.println("6. [🔎] BUSCAR ALUNO POR NOME");
            System.out.println("0. SAIR");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    exibirCadastroAluno(scanner, service);
                    break;
                case 2:
                    service.listarAlunos();
                    break;
                case 3:
                    System.out.print("ID do aluno a atualizar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Nova idade: ");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Escolha o novo plano:");
                    System.out.println("1 - Básico");
                    System.out.println("2 - Premium");

                    int planoOpt = scanner.nextInt();
                    scanner.nextLine();

                    Plano novoPlano;

                    if(planoOpt == 1){
                        novoPlano = new PlanoBasico("Básico", 100);
                    }
                    else if(planoOpt == 2){
                        novoPlano = new PlanoPremium("Premium", 100);
                    }
                    else{
                        System.out.println("[❌] Plano inválido!");
                        break;
                    }

                    service.atualizarAluno(idUpdate, novoNome, novaIdade, novoPlano);
                    break;
                case 4:
                    System.out.print("ID do aluno a remover: ");
                    int idRemove = scanner.nextInt();
                    scanner.nextLine();
                    service.removerAluno(idRemove);
                    break;
                case 5:
                    service.relatorioMensalidade();
                    break;
                case 6:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeBusca = scanner.nextLine();
                    service.buscarAlunoPorNome(nomeBusca);
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("[❌] Valor inválido!");
            }
        } while (option != 0);
    }
}