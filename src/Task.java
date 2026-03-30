import java.time.LocalDateTime;

public class Task {
    private final int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt; // when the task was created
    private LocalDateTime updatedAt; // when the task was last updated

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

    public void setStatus(Status status) { this.status = status; }

    public String toString(){
        return "Id: " + id + "; Description: " + description + "; Status: " + status;
    }

}
