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

    public void addTask(String description) throws IOException {
        List<Task> tasks = getTasks();
        int id = generateId(tasks);

        Task task = new Task(id, description);
        tasks.add(task);
        repo.save(tasks);
    }

    public void updateTask(int id, String newDescription) throws IOException {
        List<Task> tasks = getTasks();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                found = true;
                task.setDescription(newDescription);
                task.setUpdatedAt(LocalDateTime.now()); // set the last time the task was updated
                break;
            }
        }
        if (!found) throw new IllegalArgumentException("Task with id " + id + " does not exist");
        repo.save(tasks); // update tasks
    }

    public void deleteTask(int id) throws IOException {
        List<Task> tasks = getTasks();
        tasks.removeIf(task -> task.getId() == id);
        repo.save(tasks);
    }

    public void updateStatus(int id, Status status) throws IOException {
        List<Task> tasks = getTasks();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                found = true;
                task.setStatus(status);
                task.setUpdatedAt(LocalDateTime.now());
                break;
            }
        }
        if (!found) throw new IllegalArgumentException("Task with id " + id + " does not exist");
        repo.save(tasks);
    }


    public void printTasksByStatus(Status status) throws IOException {
        List<Task> tasks = getTasks();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
               System.out.println(task);
            }
        }
    }

    public void printAllTasks() throws IOException {
        List<Task> tasks = getTasks();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public List<Task> getTasks() throws IOException {
        return repo.load();
    }
}
