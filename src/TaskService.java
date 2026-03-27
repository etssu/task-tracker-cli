import java.io.IOException;
import java.util.List;

public class TaskService {
    private TaskRepository repo = new TaskRepository();

    public void addTask(Task task) throws IOException {
        List<Task> tasks = repo.load();
        tasks.add(task);
        try {
            repo.save(tasks);
        } catch (IOException e) {
            System.out.println("Error while saving task");
        }
    }

    public void updateTask(Task task) throws IOException {
        List<Task> tasks = repo.load();

    }
}
