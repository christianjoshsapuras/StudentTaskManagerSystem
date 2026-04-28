package taskmanager;

import java.util.Scanner;
import java.util.Date;

public class Main {
	
	static TaskManager manager = new TaskManager();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean running = true;
		
		while(running) {
			System.out.println("\n========== STUDENT TASK MANAGER ==========");
			System.out.println("1. Create Category");
			System.out.println("2. Create Student");
			System.out.println("3. Create Task");
			System.out.println("4. Add Task to Student");
			System.out.println("5. View Student Tasks");
			System.out.println("6. Mark Task Complete");
			System.out.println("7. Delete Task");
			System.out.println("8. View All Tasks");
			System.out.println("9. Exit");
			System.out.print("Choose option: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				case 1:
					createCategory();
					break;
				case 2:
					createStudent();
					break;
				case 3:
					createTask();
					break;
				case 4:
					addTaskToStudent();
					break;
				case 5:
					viewStudentTasks();
					break;
				case 6:
					markTaskComplete();
					break;
				case 7:
					deleteTask();
					break;
				case 8:
					viewAllTasks();
					break;
				case 9:
					running = false;
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}
		
		scanner.close();
	}
	
	static void createCategory() {
		System.out.print("Enter Category ID: ");
		int catID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Category Name: ");
		String name = scanner.nextLine();
		
		Category cat = new Category(catID, name);
		manager.addCategory(cat);
		System.out.println("✓ Category created: " + name);
	}
	
	static void createStudent() {
		System.out.print("Enter Student ID: ");
		int studID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Student Name: ");
		String name = scanner.nextLine();
		
		Student student = new Student(studID, name);
		manager.addStudent(student);
		System.out.println("✓ Student created: " + name);
	}
	
	static void createTask() {
		System.out.print("Enter Task Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter Task Description: ");
		String description = scanner.nextLine();
		
		Task task = manager.createTask(title, description, new Date());
		System.out.println("✓ Task created: " + title);
		
		System.out.print("Assign to category? (y/n): ");
		String ans = scanner.nextLine();
		if(ans.equalsIgnoreCase("y")) {
			System.out.print("Enter Category ID: ");
			int catID = scanner.nextInt();
			Category cat = manager.getCategoryByID(catID);
			if(cat != null) {
				task.setCategory(cat);
				System.out.println("✓ Task assigned to: " + cat.getName());
			} else {
				System.out.println("✗ Category not found");
			}
		}
	}
	
	static void addTaskToStudent() {
		System.out.print("Enter Student ID: ");
		int studID = scanner.nextInt();
		System.out.print("Enter Task ID: ");
		int taskID = scanner.nextInt();
		scanner.nextLine();
		
		Student student = manager.getStudentByID(studID);
		Task task = manager.getTaskByID(taskID);
		
		if(student != null && task != null) {
			student.addTask(task);
			System.out.println("✓ Task added to student");
		} else {
			System.out.println("✗ Student or Task not found");
		}
	}
	
	static void viewStudentTasks() {
		System.out.print("Enter Student ID: ");
		int studID = scanner.nextInt();
		scanner.nextLine();
		
		Student student = manager.getStudentByID(studID);
		if(student != null) {
			System.out.println("\n=== " + student.getName() + "'s Tasks ===");
			if(student.getTasks().isEmpty()) {
				System.out.println("No tasks");
			} else {
				for(Task task : student.getTasks()) {
					String cat = task.getCategory() != null ? task.getCategory().getName() : "No category";
					System.out.println(task.getTaskID() + ". " + task.getTitle() + 
						" (" + cat + ") - " + (task.getStatus() ? "COMPLETED" : "PENDING"));
				}
			}
		} else {
			System.out.println("✗ Student not found");
		}
	}
	
	static void markTaskComplete() {
		System.out.print("Enter Task ID: ");
		int taskID = scanner.nextInt();
		scanner.nextLine();
		
		Task task = manager.getTaskByID(taskID);
		if(task != null) {
			manager.completeTask(taskID);
			System.out.println("✓ Task marked as complete");
		} else {
			System.out.println("✗ Task not found");
		}
	}
	
	static void deleteTask() {
		System.out.print("Enter Task ID: ");
		int taskID = scanner.nextInt();
		scanner.nextLine();
		
		manager.deleteTask(taskID);
		System.out.println("✓ Task deleted");
	}
	
	static void viewAllTasks() {
		System.out.println("\n=== ALL TASKS ===");
		if(manager.getAllTasks().isEmpty()) {
			System.out.println("No tasks");
		} else {
			manager.displayAllTasks();
		}
	}
	
}
