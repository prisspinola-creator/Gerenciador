import java.util.*;
import java.util.stream.Collectors;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        if (ValidadorTarefa.validar(tarefa)) {
            tarefas.add(tarefa);
            System.out.println("Tarefa adicionada com sucesso!");
        } else {
            System.out.println("Erro: tarefa inválida.");
        }
    }

    public void listarTodas() {
        tarefas.forEach(System.out::println);
    }

    public void filtrarPorStatus(Status status) {
        tarefas.stream()
                .filter(t -> t.getStatus() == status)
                .forEach(System.out::println);
    }

    public void listarOrdenadasPorDeadline() {
        tarefas.stream()
                .sorted(Comparator.comparing(Tarefa::getDeadline))
                .forEach(System.out::println);
    }
}