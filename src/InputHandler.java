import java.sql.SQLOutput;
import java.util.List;

public class InputHandler {
    public InputHandler(String args0, String args1, String args2) {
        TaskService service = new TaskService();
        // args[0] - command
        // args[1] - index
        // args[2] - description

        try {
            switch (args0) {
                case "add":
                    service.addTask(args1);
                    break;
                case "update":
                    service.updateTask(Integer.parseInt(args1), args2); // args1 - index, args2 - description
                    break;
                case "delete":
                    service.deleteTask(Integer.parseInt(args1));
                    break;
                case "mark-in-progress":
                    service.updateStatus(Integer.parseInt(args1), Status.IN_PROGRESS);
                case "mark-done":
                    service.updateStatus(Integer.parseInt(args1), Status.DONE);
                case "list":
                default:
                    System.out.println("Wrong command. Try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong format. Try again.");
        }
        catch (NullPointerException e) {
            System.out.println("Null-pointer");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // string instead of int
        //
    }
}
