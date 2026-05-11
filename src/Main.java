package taskmanager;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static TaskManager manager = new TaskManager();

	public static void main(String[] args) {

		int choice;

		do {
			System.out.println("\n========== STUDENT TASK MANAGER ==========");
			System.out.println("1. Create Task");
			System.out.println("2. View All Tasks");
			System.out.println("3. Edit Task");
			System.out.println("4. Mark Task Complete");
			System.out.println("5. Delete Task");
			System.out.println("6. Exit");
			System.out.print("Choose option: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch(choice) {
				case 1:
					createTask();
					break;
				case 2:
					viewAllTasks();
					break;
				case 3:
					editTask();
					break;
				case 4:
					markTaskComplete();
					break;
				case 5:
					deleteTask();
					break;
				case 6:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice.");
			}

		} while(choice != 6);

		scanner.close();
	}

	static void createTask() {
		System.out.print("Enter Task Title: ");
		String title = scanner.nextLine();

		System.out.print("Enter Task Description: ");
		String description = scanner.nextLine();

		System.out.print("Enter Due Date: ");
		String dueDate = scanner.nextLine();

		System.out.print("Enter Category Name: ");
		String categoryName = scanner.nextLine();

		Task task = manager.createTask(title, description, dueDate, categoryName);

		System.out.println("Task created with ID: " + task.getTaskID());
	}

	static void viewAllTasks() {
		System.out.println("\n=== ALL TASKS ===");
		manager.displayAllTasks();
	}

	static void editTask() {
		System.out.print("Enter Task ID: ");
		int taskID = scanner.nextInt();
		scanner.nextLine();

		Task task = manager.getTaskByID(taskID);

		if(task != null) {
			System.out.print("Enter New Title: ");
			String title = scanner.nextLine();

			System.out.print("Enter New Description: ");
			String description = scanner.nextLine();

			System.out.print("Enter New Due Date: ");
			String dueDate = scanner.nextLine();

			System.out.print("Enter New Category Name: ");
			String categoryName = scanner.nextLine();

			manager.editTask(taskID, title, description, dueDate, categoryName);
			System.out.println("Task updated successfully.");
		} else {
			System.out.println("Task not found.");
		}
	}

	static void markTaskComplete() {
		System.out.print("Enter Task ID: ");
		int taskID = scanner.nextInt();
		scanner.nextLine();

		Task task = manager.getTaskByID(taskID);

		if(task != null) {
			manager.completeTask(taskID);
			System.out.println("Task marked as complete.");
		} else {
			System.out.println("Task not found.");
		}
	}

	static void deleteTask() {
		System.out.print("Enter Task ID: ");
		int taskID = scanner.nextInt();
		scanner.nextLine();

		Task task = manager.getTaskByID(taskID);

		if(task != null) {
			manager.deleteTask(taskID);
			System.out.println("Task deleted successfully.");
		} else {
			System.out.println("Task not found.");
		}
	}
}
