import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar todas");
            System.out.println("3 - Filtrar por status");
            System.out.println("4 - Listar ordenadas por deadline");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String entrada = sc.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    if (titulo.length() <= 5) {
                        System.out.println("Erro: título deve ter mais de 5 caracteres.");
                        break;
                    }

                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Deadline (AAAA-MM-DD): ");
                    LocalDate deadline;
                    try {
                        deadline = LocalDate.parse(sc.nextLine());
                        if (deadline.isBefore(LocalDate.now())) {
                            System.out.println("Erro: deadline não pode ser no passado.");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                        break;
                    }

                    System.out.print("Status (PENDENTE, EM_ANDAMENTO, CONCLUIDO): ");
                    Status status;
                    try {
                        status = Status.valueOf(sc.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Status inválido.");
                        break;
                    }

                    Tarefa tarefa = new Tarefa(titulo, descricao, deadline, status);
                    gerenciador.adicionarTarefa(tarefa);
                    break;

                case 2:
                    gerenciador.listarTodas();
                    break;

                case 3:
                    System.out.println("Status disponíveis:");
                    for (Status s : Status.values()) {
                        System.out.println("- " + s);
                    }

                    System.out.print("Digite o status: ");
                    try {
                        Status filtro = Status.valueOf(sc.nextLine().toUpperCase());
                        gerenciador.filtrarPorStatus(filtro);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Status inválido. Use: PENDENTE, EM_ANDAMENTO ou CONCLUIDO.");
                    }
                    break;

                case 4:
                    gerenciador.listarOrdenadasPorDeadline();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
