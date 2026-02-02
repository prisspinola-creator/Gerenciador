import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate deadline;
    private Status status;

    public Tarefa(String titulo, String descricao, LocalDate deadline, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.deadline = deadline;
        this.status = status;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public LocalDate getDeadline() { return deadline; }
    public Status getStatus() { return status; }

    @Override
    public String toString() {
        return titulo + " - " + status + " - prazo: " + deadline;
    }
}