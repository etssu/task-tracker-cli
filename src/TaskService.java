import java.io.IOException;
import java.time.LocalDateTime;
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
            System.out.println("Error while saving task.");
        }
    }

    public void updateTask(int id, String newDescription) {
        try {
            List<Task> tasks = repo.load();
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.setDescription(newDescription);
                    task.setUpdatedAt(LocalDateTime.now()); // set the last time the task was updated
                }
            }
            repo.save(tasks); // update tasks
        } catch (IOException e) {
            System.out.println("Error while updating task.");
        }
    }
}
