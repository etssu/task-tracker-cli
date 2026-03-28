import java.time.LocalDateTime;

public class Task {
    private final int id;
    private String description;
    Status status;
    LocalDateTime createdAt; // when the task was created
    LocalDateTime updatedAt; // when the task was last updated

    public Task(int id, String description){ // create task
        this.id = id;
        this.description = description;
        this.status = Status.TODO;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setDescription(String description) { this.description = description; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

}
