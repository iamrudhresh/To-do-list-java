import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    static class Task {
        private String description;
        private boolean isCompleted;

        public Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String taskDescription = scanner.nextLine();
                    Task taskToRemove = null;
                    for (Task task : tasks) {
                        if (task.getDescription().equals(taskDescription)) {
                            taskToRemove = task;
                            break;
                        }
                    }
                    if (taskToRemove != null) {
                        tasks.remove(taskToRemove);
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter task description to mark as completed: ");
                    String taskDescriptionToComplete = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.getDescription().equals(taskDescriptionToComplete)) {
                            task.setCompleted(true);
                            System.out.println("Task marked as completed successfully.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Tasks:");
                    for (Task task : tasks) {
                        System.out.println("- " + task.getDescription() + (task.isCompleted() ? " (Completed)" : ""));
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
