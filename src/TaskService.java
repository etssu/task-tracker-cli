import java.io.IOException;
import java.util.List;

public class TaskService {
    private final TaskRepository repo = new TaskRepository();

    private int generateId(List<Task> tasks) {
        int maxId = 0;
        for (Task task : tasks) {
            if (maxId < task.getId()) {
                maxId = task.getId();
            }
        }
        return maxId + 1; // new id = maximum + 1
    }

    public void addTask(String description) {
        try {
            List<Task> tasks = repo.load();
            int id = generateId(tasks);

            Task task = new Task(id, description);
            tasks.add(task);
            repo.save(tasks);
        } catch (IOException e) {
            System.out.println("Error while saving task");
        }
    }



    public void updateTask(int id, String newDescription) throws IOException {
        List<Task> tasks = repo.load();

    }
}
