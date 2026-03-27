import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public static final File FILE = new File("tasks.json");

    public void save(List<Task> tasks)  throws IOException {
        StringBuilder sb =  new StringBuilder();
        sb.append("[\n");

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            sb.append("  {\n");
            sb.append("    \"id\": ").append(t.getId()).append(",\n");
            sb.append("    \"description\": \"").append(t.getDescription()).append("\",\n");
            sb.append("    \"status\": \"").append(t.status).append("\"\n");
            sb.append("    \"created-at\": \"").append(t.getCreatedAt()).append("\"\n");
            sb.append("    \"updated-at\": \"").append(t.getUpdatedAt()).append("\"\n");
            sb.append("  }");
            if (i < tasks.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        Files.writeString(FILE.toPath(), sb.toString());
    }

    public List<Task> parse(String json) throws IOException {
        List<Task> tasks = new ArrayList<>();

        String[] blocks = json.split("\\{");

        for (String block : blocks) {
            if (!block.contains("id")) continue;

            int id = Integer.parseInt(extractValue(block, "id"));
            String description = extractValue(block, "description");
            Status status = Status.valueOf(extractValue(block, "status"));

            Task task = new Task(id, description);
            task.status = status;
            tasks.add(task);
        }

        return tasks;
    }
    public String extractValue(String block, String key) {
        String search = "\"" + key + "\":";
        int start = block.indexOf(search) + search.length();

        while (block.charAt(start) == ' ') start++; // skip spaces

        if (block.charAt(start) == '"') {
            int end = block.indexOf('"', start + 1);
            return block.substring(start + 1, end);
        }

        int end = start;
        while (end < block.length() && ",\n\r}".indexOf(block.charAt(end)) == -1) {
            end++;
        }
        return block.substring(start, end).trim();
    }

    public List<Task> load() throws IOException {
        // if no file -> empty list
        if (!FILE.exists()) return new ArrayList<>();

        String content = Files.readString(FILE.toPath());
        return parse(content);
    }
}
