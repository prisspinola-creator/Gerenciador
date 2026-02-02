import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Predicate;

public class ValidadorTarefas {
    private static final Predicate<Tarefa> tituloValido = t -> t.getTitulo().length() > 5;
    private static final Predicate<Tarefa> deadlineValido = t -> !t.getDeadline().isBefore(LocalDate.now());
    private static final Predicate<Tarefa> statusValido = t -> Optional.ofNullable(t.getStatus()).isPresent();

    public static boolean validar(Tarefa tarefa) {
        return tituloValido.and(deadlineValido).and(statusValido).test(tarefa);
    }
}