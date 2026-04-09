
public class InputHandler {
    private final TaskService service;

    public InputHandler(TaskService service) {
        this.service = service;
    }

    public void handle(String[] args) {
        try {
            switch (args[0]) {
                case "add":
                    service.addTask(args[1]);
                    break;
                case "update":
                    service.updateTask(Integer.parseInt(args[1]), args[2]); // args1 - index, args2 - description
                    break;
                case "delete":
                    service.deleteTask(Integer.parseInt(args[1]));
                    break;
                case "mark-in-progress":
                    service.updateStatus(Integer.parseInt(args[1]), Status.IN_PROGRESS);
                    break;
                case "mark-done":
                    service.updateStatus(Integer.parseInt(args[1]), Status.DONE);
                    break;
                case "list":
                    if (args.length < 2 || args[1].isEmpty() ) {
                        service.printAllTasks();
                    }
                    try {
                        Status status = Status.valueOf(args[1].toUpperCase());
                        service.printTasksByStatus(status);
                    }  catch (IllegalArgumentException e) {
                        System.out.println("Invalid status");
                    }
                    break;
                default:
                    System.out.println("Wrong command. Try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong format. Try again.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
