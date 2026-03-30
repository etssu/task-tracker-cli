import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // args[0] - command
        // args[1] - index
        // args[2] - description

        // TODO implement input control

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Print the original ArrayList
        System.out.println("Original List :" + list);

        // remove elements which are odd parity
        list.removeIf(n -> n % 2 != 0);

        // processed arraylist
        System.out.println("List after removeIf() method :"
                + list);

        TaskRepository repo = new TaskRepository();
        System.out.println("Args[0] - " + args[0]);
        System.out.println("Args[1] - " + args[1]);
        /*
        if (args[0].equals("add")) {
            List<Task> tasks = repo.load();
            tasks.add(new Task(1, args[1]));
            repo.save(tasks);
            System.out.println("Task " + args[1] + " has been saved. ID: " + tasks.get(0).getId());
        } */
    }
}